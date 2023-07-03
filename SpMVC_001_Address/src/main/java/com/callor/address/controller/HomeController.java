package com.callor.address.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.address.models.AddrDto;
import com.callor.address.service.AddrService;

/*
 * Controller class
 * @Controller Annotation 이 부착된 class
 * Client 로 부터 Request(요청)이 다다르면, 어디로 요청을 전달할지
 * Routing 역할을 하는 class
 */

@Controller
public class HomeController {

	protected final AddrService addrService;

	public HomeController(AddrService addrService) {
		this.addrService = addrService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		List<AddrDto> addrList = addrService.selectAll();
		model.addAttribute("ADDRS", addrList);

		return "home";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<AddrDto> list() {
		List<AddrDto> addrList = addrService.selectAll();
		return addrList;
	}

	// produces
	// Server 가 Browser 에 데이터를 응답할때
	// 한글이 포함되어 있으면 Encoding 을 하여서 보내라
	// View 에 rendering 을 할때는 의미가 없다
	// @ResponseBody 가 설정되어 있을때
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	/*
	 * Controller 의 method 에 @ResponseBody Annotation 이 부착되면 문자열을 그대로 (direct)
	 * Client 로 Response 하라 라는 의미
	 */

	// @ResponseBody
//	public String insert(String a_id, String a_name, String a_tel, String a_addr) {
//
//		return String.format("이름 : %s 전화번호 : %s 주소 : %s", a_name, a_tel, a_addr);
//	}
	public String insert(@ModelAttribute AddrDto addrDto) {

		addrService.insert(addrDto);

//		redirect 안쓸경우
//		내가 데이터를 만들고 view 를 생성하는 일을 할때
//		List<AddrDto> addrList = addrSerivce.selectAll() , 매개변수 model 추가
//		model.addAtribute("ADDRS", addrList)
//		return "home";

//		데이터를 만들고 viwe를 생성하여 client에게 response 하는 URL 이 이미 있으니
//		client 야 번거롭지만 한번 더 요청해 주라
		return "redirect:/";

//		return String.format("이름 : %s, 전화번호 : %s, 주소 :%s", addrDto.getA_name(), addrDto.getA_tel(),
//				addrDto.getA_addr());
	}

	/*
	 * localhost:8080/address/insert 로 요청이 오면 addr/input.jsp 파일을 열어서 Response 하도록
	 * method 생성
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String input(Model model) {
		model.addAttribute("BODY", "INPUT");
		/*
		 * Controller 의 method 에서 문자열을 return 하면 "/views/문자열.jsp" 파일을 rendering 하여
		 * Client 로 Response를 하라 라는 의미
		 */
		return "home";
	}

	@RequestMapping(value = "/insert/test", method = RequestMethod.GET)
	public String input() {
		return "addr/input";
	}

	@RequestMapping(value = "/id_check", method = RequestMethod.GET)
	@ResponseBody
	public String idCheck(String id) {
		return addrService.idCheck(id);
//		AddrDto addrDto = addrService.findById(id);
//		if (addrDto == null) {
//			return "OK";
//		} else {
//			return "FAIL";
//		}
	}

	/*
	 * localhost:8080/addr/detail?id=A0001 형식으로 request 가 오면 id=A0001 에 설정된 A0001 값을
	 * id 매개 변수로 받는다 URL : localhost:8080/addr/detail queryString : ?id=A0001
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(String id, Model model) {
		// request 에 설정된 id값으로 DB table 에서 주소 정보를 SELECT
		AddrDto addrDto = addrService.findById(id);

		// SELECT 된 주소를 model 에 담아서 view 로 전달
		model.addAttribute("ADDR", addrDto);
		// home.jsp 에 include 되어 보여질 화면(변수) 세팅
		model.addAttribute("BODY", "DETAIL");

		return "home";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {
		int result = addrService.delete(id);

		if (result > 0) {
			return "redirect:/";
		} else {
			// 삭제에 실패 했을 경우
			// 현재 id의 detail 화면으로 되돌아 가라
			return "redirect:/detail?id=" + id;
		}
	}
	
	// 데이터 업데이트할 화면 보여주기
	// Spring 에서는 RequestMapping을 참조하여
	// update GETTER method 라고 부른다
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, Model model) {
		
		// 변경할 주소 데이터 SELECT 하여 model 에 담기
		AddrDto addrDto = addrService.findById(id);
		model.addAttribute("ADDR", addrDto);
		model.addAttribute("BODY","UPDATE");
		
		return "home";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String update(@ModelAttribute AddrDto addrDto) {
		
		int result = addrService.update(addrDto);
		String id = addrDto.getA_id();
		
		// update 가 성공하면 detail 화면을 보여서 변경 된 것을 확인
		if (result > 0) {
			return "redirect:/detail?id=" + id;
			// update 가 실패하면 다시 update 화면을 보여주기
		} else {
			return "redirect:/update?id=" + id;
		}
	}
}
