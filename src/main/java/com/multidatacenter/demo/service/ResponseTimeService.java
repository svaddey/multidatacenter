package com.multidatacenter.demo.service;

import com.multidatacenter.demo.model.ResponseTime;

public interface ResponseTimeService {
	public ResponseTime getById(int id);
	public ResponseTime getResponseTime();
}
