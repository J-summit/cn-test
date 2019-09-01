package cn.lansky.springmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "你找不到了吧")  // 404
public class BookNotFoundException extends RuntimeException {
	// ...
}