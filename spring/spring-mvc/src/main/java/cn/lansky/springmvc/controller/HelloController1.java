package cn.lansky.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController1 {


	@RequestMapping("/helloworld1")
	public String getHelloword(HttpServletRequest request) {
		System.out.println("hello world");
		return "success";
	}

	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:helloworld1";
	}

	@RequestMapping("/forward")
	public String forword() {
		return "forward:helloworld1";
	}
}
