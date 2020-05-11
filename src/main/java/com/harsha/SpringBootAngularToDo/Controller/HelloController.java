package com.harsha.SpringBootAngularToDo.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping(path= {"/hello","/hello/{name}"})
	public String hello(@PathVariable(value="name") String name) {
		return "Hello "+name;
	}
	
	
}
