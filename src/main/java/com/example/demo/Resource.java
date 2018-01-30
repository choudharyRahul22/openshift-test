package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {
	
	@RequestMapping("/")
	public Map<Integer, String> get(){
		
		return getData();
	}
	
	public Map<Integer,String> getData() {
		
		Ignition.setClientMode(true);

		Ignite objIgnite = Ignition.start("C:\\Optum\\IgniteEbookPractice\\apache-ignite-fabric-2.3.0-bin\\examples\\config\\iris-poc-config.xml");

		IgniteCache<Integer, String> objIgniteCache = objIgnite.getOrCreateCache("irisCache");
		
		// Populating the cache with few values
		System.out.println("**************Start putting data into ignite cache**************");
		objIgniteCache.put(1, "iris-ui");
		objIgniteCache.put(2, "iris-spring");
		objIgniteCache.put(3, "iris-ignite");
		objIgniteCache.put(4, "iris-oracle");

		// Get these items from cache
		System.out.println("**************Start fetching data from ignite cache**************");
		System.out.println(objIgniteCache.get(1));
		System.out.println(objIgniteCache.get(2));
		System.out.println(objIgniteCache.get(3));
		System.out.println(objIgniteCache.get(4));
		
		Map<Integer,String> map = new HashMap<>();
		map.put(1,objIgniteCache.get(1));
		map.put(2,objIgniteCache.get(2));
		map.put(3,objIgniteCache.get(3));
		map.put(4,objIgniteCache.get(4));
		return map;
	}

}
