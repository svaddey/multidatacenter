package com.multidatacenter.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.multidatacenter.demo.model.ResponseTime;
import com.multidatacenter.demo.service.ResponseTimeService;

@RestController
public class ResponseTimeController {
	@Autowired
	ResponseTimeService responseTimeService;
	
	@GetMapping({ "/", "/index" })
    public ResponseEntity<ResponseTime> index() {
        ResponseTime responseTime = responseTimeService.getResponseTime();
        if (responseTime.getActual() > responseTime.getValue()) {
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Response time too long");
        } else {
        	return ResponseEntity.ok(responseTime);
        }
    }
}
