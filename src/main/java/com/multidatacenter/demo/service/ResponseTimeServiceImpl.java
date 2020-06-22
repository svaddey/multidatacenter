package com.multidatacenter.demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.multidatacenter.demo.model.ResponseTime;
import com.multidatacenter.demo.repository.ResponseTimeRepository;

@Service
public class ResponseTimeServiceImpl implements ResponseTimeService {
	@Autowired
	ResponseTimeRepository responseTimeRepository;

	@Value("${response.time.location}")
	private String fileLocation;

	@Override
	public ResponseTime getById(int id) {
		return responseTimeRepository.findById(id).orElse(null);
	}

	@Override
	public ResponseTime getResponseTime() {
		List<ResponseTime> responseTimes = (List<ResponseTime>) responseTimeRepository.findAll();

		ResponseTime responseTime = responseTimes.get(0);

		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(fileLocation)));
			String currentLine = reader.readLine();
			if (StringUtils.hasText(currentLine)) {
				responseTime.setActual(Integer.parseInt(currentLine));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return responseTime;
	}
}
