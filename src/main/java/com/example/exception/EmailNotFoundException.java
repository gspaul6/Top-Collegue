package com.example.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(CollegueInvalidException.class);

	public EmailNotFoundException(String message) {
		LOG.error(message);
	}

}
