package com.example.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollegueInvalidException extends RuntimeException {
	private static final Logger LOG = LoggerFactory.getLogger(CollegueInvalidException.class);

	public CollegueInvalidException(String message) {
		LOG.error(message);
	}

}
