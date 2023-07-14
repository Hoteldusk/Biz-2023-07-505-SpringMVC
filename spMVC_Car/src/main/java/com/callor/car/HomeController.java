package com.callor.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.car.models.RecordDto;
import com.callor.car.service.CarService;

@Controller
public class HomeController {

	protected final CarService carService;

	@Autowired
	public HomeController(CarService carService) {
		this.carService = carService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		List<RecordDto> recordList = carService.getDatas();

		model.addAttribute("RECORDS", recordList);

		return "home";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(@RequestParam("c_divison") String division,
			@RequestParam("c_depDist") String departureDistance, @RequestParam("c_location") String location,
			@RequestParam("arrDist") String arrivalDistance, @RequestParam("c_cost") int cost) {

		carService.saveData(division, departureDistance, location, arrivalDistance, cost);

		return "redirect:/";
	}
	
	
}
