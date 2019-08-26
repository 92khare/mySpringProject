package com.websystique.springmvc.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.websystique.springmvc.domain.Message;

@RestController
public class HelloWorldRestController {

	@RequestMapping("/")
	public String welcome() {// Welcome page, non-rest
		return "Welcome to RestTemplate Example.";
	}

	@RequestMapping("/hello")
	@ResponseBody
	public ResponseEntity message(@Valid @RequestBody Message msg, BindingResult br) throws HttpMessageNotReadableException {// REST
																													// Endpoint.
	//	
		if (br.hasErrors()) {
			for (Object object : br.getAllErrors()) {
				if (object instanceof FieldError) {
					System.out.println("Feild Error");
					FieldError fieldError = (FieldError) object;

					System.out.println(fieldError.getField());
					System.out.println(fieldError.getCode());
				}

				if (object instanceof ObjectError) {
					System.out.println("Object Error");
					ObjectError objectError = (ObjectError) object;

					System.out.println(objectError.getObjectName());
					System.out.println(objectError.getCode());
				}
			}
			return new ResponseEntity<>("{errors:400}", HttpStatus.BAD_REQUEST);
		}
		System.out.println("Incoming request :" + msg.toString());
		System.out.println(msg.getDealObj().length);
		System.out.println(msg.getName());
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

}
