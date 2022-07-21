package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.AddressService;

@Controller
@CrossOrigin
@RequestMapping("/api")
public class AddressController {

	@Autowired
	private AddressService service;

	/**
	 * 
	 * 郵便番号から住所を検索し、JSONで返す
	 * 
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/zipcode", method = RequestMethod.GET)
	public Map<String, String> address(String zipcode) {

		return service.findByZipcode(zipcode);
	}
}
