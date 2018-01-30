package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {
	
	@RequestMapping("/")
	public Map<Integer, String> get(){
		Map<Integer,String> map = new HashMap<>();
		map.put(1,"Rahul");
		return map;
	}

}
