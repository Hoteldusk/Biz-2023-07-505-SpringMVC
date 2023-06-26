package com.callor.hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 33);
		model.addAttribute("tel", "010-1111-1111");
		
		return "home";
	}
	
	@RequestMapping(value="/hello")
	public String hello(Model model) {
		AddressDto addrDto = new AddressDto();
		addrDto.setName("성춘향");
		addrDto.setAge(16);
		addrDto.setTel("010-222-2222");
		addrDto.setAddress("전라북도 남원시");
		
		model.addAttribute("ADDR", addrDto);
		
		// WEB-INF/views.hello.jsp 를 찾아서 rendering 해 달라
		return "hello";
	}
	
	@RequestMapping(value="/user")
	public String user(Model model) {
		List<AddressDto> addrList = new ArrayList<AddressDto>();
		AddressDto addrDto1 = new AddressDto();
		addrDto1.setName("홍길동");
		addrDto1.setAge(20);
		addrDto1.setTel("010-1111-1111");
		addrDto1.setAddress("광주광역시");
		
		addrList.add(addrDto1);
		
		AddressDto addrDto2 = new AddressDto();
		addrDto2.setName("성춘향");
		addrDto2.setAge(16);
		addrDto2.setTel("010-1111-1112");
		addrDto2.setAddress("대전광역시");
		
		addrList.add(addrDto2);
		
		AddressDto addrDto3 = new AddressDto();
		addrDto3.setName("이몽룡");
		addrDto3.setAge(21);
		addrDto3.setTel("010-1111-1113");
		addrDto3.setAddress("부산광역시");
		
		addrList.add(addrDto3);
		
		for (AddressDto addressDto : addrList) {
			System.out.println(addressDto.toString());
		}
		
		model.addAttribute("ADDRS", addrList);
		
		return "user2";
	}
	
}
