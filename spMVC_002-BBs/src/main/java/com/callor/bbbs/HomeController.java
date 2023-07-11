package com.callor.bbbs;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.bbbs.dao.BbsDao;
import com.callor.bbbs.models.BbsDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private final BbsDao bbsDao;

	public HomeController(BbsDao bbsDao) {
		this.bbsDao = bbsDao;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
//		List<BbsDto> bbsList = bbsDao.selectAll();
		List<BbsDto> bbsList = bbsDao.findUserSelectLimit();
		model.addAttribute("BBS_LIST", bbsList);
		
		return "home";
	}
	
	@RequestMapping(value = "/search/detail", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam("seq")long seq) {
		BbsDto dto = bbsDao.findBySeq(seq);
		model.addAttribute("BBS", dto);
		
		return "detail";
	}
}
