package com.sehron.service.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/public")
public class PublicController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String terminate() {
		return "Hello, you are in a public area." ;
	}

}
