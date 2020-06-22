package com.multidatacenter.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Response time is too long")
public class ResponseTimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResponseTimeException(String errorMessage) {
		super(errorMessage);
	}
}
