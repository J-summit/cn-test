package cn.lansky.springmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 *
 *
 * @author sky
 * @since
 */
@Controller
public class HelloController {

	@ModelAttribute
	public void test() {
		System.out.println("ModelAttribute");
	}

	@RequestMapping("/helloworld")
	public String getHelloword(@Valid HttpServletRequest request) {
		System.out.println("hello world");
		return "success";
	}


}
