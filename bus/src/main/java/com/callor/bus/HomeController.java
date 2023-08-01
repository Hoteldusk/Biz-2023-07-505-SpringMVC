package com.callor.bus;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.bus.dao.BusDao;
import com.callor.bus.dto.RequestMessage;
import com.callor.bus.dto.TerDriveVO;
import com.callor.bus.dto.TerLinkVO;
import com.callor.bus.dto.UserDto;
import com.callor.bus.dto.UsuallyDto;
import com.callor.bus.service.BusService;
import com.callor.bus.service.LoadDB;
import com.callor.bus.service.SaveDB;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	private final BusService busService;
	private final SaveDB saveDB;
	private final LoadDB loadDB;
	private final BusDao busDao;

	@Autowired
	public HomeController(BusService busService, SaveDB saveDB, LoadDB loadDB, BusDao busDao) {
		this.busService = busService;
		this.saveDB = saveDB;
		this.loadDB = loadDB;
		this.busDao = busDao;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(HttpSession httpSession, Model model) {
		UserDto userDto = (UserDto) httpSession.getAttribute("USER");
		if (userDto == null) {
			model.addAttribute("LOGINOUT", "LOGIN");
		} else {
			userDto = busService.findById(userDto.getBu_id());
			model.addAttribute("LOGINOUT", "LOGOUT");
			model.addAttribute("LOGINUSER", userDto);
		}
		return "home";

	}

	@RequestMapping(value = "/userprint", method = RequestMethod.GET)
	public String userPrint(Model model) {

		List<UserDto> userList = busService.selectAll();

		model.addAttribute("USERS", userList);
		return "userPrint";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String join(@ModelAttribute("NEWUSER") UserDto userDto, Model model) {
		UserDto dto = busService.findById(userDto.getBu_id());

		if (dto == null) {
			busService.insert(userDto);
			return "home";
		} else {
			model.addAttribute("SAMEID", "이미 존재하는 ID 입니다");
			return "join";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserDto userDto, HttpSession httpSession, Model model) {
		String msg = busService.userLogin(userDto);
		if (msg.equals("OK")) {
			httpSession.setAttribute("USER", userDto);
			model.addAttribute("LOGINOUT", "LOGOUT");
			return "redirect:/";
		} else {
			model.addAttribute("FAIL", msg);
			return "login";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession, Model model) {

		// Session에 저장된 데이터를 clear
		httpSession.setAttribute("USER", null);

		// Session 자체를 모두 소멸
		httpSession.removeAttribute("USER");

		model.addAttribute("LOGINOUT", "LOGIN");
		return "redirect:/";
	}

	@RequestMapping(value = "/searcharea", method = RequestMethod.GET)
	public String searchArea() {

		return "searcharea";
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(HttpSession httpSession, Model model) {

		UserDto userDto = (UserDto) httpSession.getAttribute("USER");
		if (userDto != null) {
			UserDto selectDto = busService.findById(userDto.getBu_id());
			model.addAttribute("MYUSER", selectDto);
			return "mypage";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/updateuser", method = RequestMethod.GET)
	public String update(HttpSession httpSession, Model model) {

		UserDto userDto = (UserDto) httpSession.getAttribute("USER");
		userDto = busService.findById(userDto.getBu_id());
		model.addAttribute("MYUSER", userDto);
		return "updateuser";
	}

	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public String update(UserDto userDto) {

		busService.update(userDto);
		return "redirect:/mypage";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(name = "id") String id, HttpSession httpSession) {
		log.debug("id정보 : {}", id);
		busService.delete(id);

		httpSession.setAttribute("USER", null);
		httpSession.removeAttribute("USER");

		return "redirect:/";
	}

	@RequestMapping(value = "/usually", method = RequestMethod.GET)
	public String usually(HttpSession httpSession, Model model) {
		UserDto userDto = (UserDto) httpSession.getAttribute("USER");
		if (userDto != null) {
			List<UsuallyDto> usList = busService.usuallyList(userDto.getBu_id());
			model.addAttribute("USLIST", usList);
			return "usually";
		} else {
			return "redirect:/login";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/mypage/savedb", method = RequestMethod.GET)
	public RequestMessage saveDB(Model model, HttpSession httpSession) {

		RequestMessage message = new RequestMessage();

		UserDto userDto = (UserDto) httpSession.getAttribute("USER");
		if (userDto != null) {
			String id = userDto.getBu_id();
			if (id.equals("test")) {
				try {
					saveDB.saveTerDB();
					saveDB.saveTerLinkDB();
					saveDB.saveTerDriveDB();
					saveDB.saveTerScheduleDB();

					message.setMessage("DB저장에 성공했습니다");

					return message;
				} catch (JSONException e) {

					message.setMessage("DB저장에 실패했습니다");

					return message;
				}

			} else {
				message.setMessage("권한이 없습니다");

				return message;
			}
		} else {
			message.setMessage("권한이 없습니다");

			return message;
		}
	}

	@RequestMapping(value = "/searchbus", method = RequestMethod.GET)
	public String searchBus(Model model, @RequestParam(required = false, defaultValue = "default") String scode,
			@RequestParam(required = false, defaultValue = "default") String ecode) {

		UsuallyDto usDto = new UsuallyDto();
		usDto.setUs_stcode(scode);
		usDto.setUs_etcode(ecode);
		model.addAttribute("USNOSUN", usDto);

		List<TerLinkVO> terlist = loadDB.loadDepTerData();
		model.addAttribute("DEPTERS", terlist);
		return "searchbus";
	}

	@ResponseBody
	@RequestMapping(value = "/bookmark", method = RequestMethod.GET)
	public RequestMessage bookmark(String depTerId, String arrTerId, String depTerName, String arrTerName,
			HttpSession httpSession) {
		UsuallyDto usuallyDto = new UsuallyDto();
		UserDto userDto = (UserDto) httpSession.getAttribute("USER");

		usuallyDto.setUs_buid(userDto.getBu_id());
		usuallyDto.setUs_stcode(depTerId);
		usuallyDto.setUs_etcode(arrTerId);
		usuallyDto.setS_terminal(depTerName.trim());
		usuallyDto.setE_terminal(arrTerName);

		int result = busDao.usuallyinsert(usuallyDto);
		RequestMessage message = new RequestMessage();

		if (result != 0) {
			message.setMessage("즐겨찾기 추가에 성공했습니다");
		} else {
			message.setMessage("즐겨찾기에 실패했습니다");
		}

		return message;
	}

	@ResponseBody
	@RequestMapping(value = "/searchbus/loadDepTer", method = RequestMethod.GET)
	public List<TerLinkVO> loadDepTer() {
		return loadDB.loadDepTerData();
	}

	@ResponseBody
	@RequestMapping(value = "/searchbus/loadArrTer", method = RequestMethod.GET)
	public List<TerLinkVO> loadArrTer(String depTerId) {
		return loadDB.loadArrTerData(depTerId);
	}

	@ResponseBody
	@RequestMapping(value = "/searchbus/loadSchedule", method = RequestMethod.GET)
	public List<TerDriveVO> loadSchedule(String depTerId, String arrTerId) {
		return loadDB.loadTerDriveAndSchedule(depTerId, arrTerId);
	}
}
