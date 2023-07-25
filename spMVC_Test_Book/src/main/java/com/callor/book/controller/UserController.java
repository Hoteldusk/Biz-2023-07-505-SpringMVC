package com.callor.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.book.models.BooksDto;
import com.callor.book.models.UsersDto;
import com.callor.book.service.UsersService;

@Controller
public class UserController {
	
	private final UsersService usersService;

	@Autowired
	public UserController(UsersService usersService) {
		this.usersService = usersService;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String users(@ModelAttribute("USER") UsersDto usersDto, Model model) {
		List<UsersDto> userList = usersService.findAllUsers();
		model.addAttribute("USERLIST", userList);
		return "users";
	}
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String inputUser(@ModelAttribute("USER") UsersDto usersDto) {
		usersService.saveUsers(usersDto);
		return "redirect:/users";
	}
	@RequestMapping(value = "/users/detail", method = RequestMethod.GET)
	public String detailBook(Model model, String id) {
		UsersDto usersDto = usersService.findUserById(id);
		model.addAttribute("USER", usersDto);
		return "users/user_detail";
	}
	@RequestMapping(value = "/users/update", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("USER") UsersDto usersDto) {
		usersService.updateUsers(usersDto);
		return "redirect:/users";
	}
}
