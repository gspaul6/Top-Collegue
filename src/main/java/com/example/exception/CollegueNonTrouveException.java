package com.example.exception;

public class CollegueNonTrouveException extends RuntimeException {

	public CollegueNonTrouveException() {

		super();
	}

	public CollegueNonTrouveException(String message, Throwable cause) {
		super(message, cause);
	}

	public CollegueNonTrouveException(String message) {
		super(message);
	}

	public CollegueNonTrouveException(Throwable cause) {
		super(cause);
	}

}
