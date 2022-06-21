package ro.springboot.spring.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiException {

	private final String message;
	private final HttpStatus httpStatus;
	private final ZonedDateTime timesamp;

	public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timesamp) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.timesamp = timesamp;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public ZonedDateTime getTimesamp() {
		return timesamp;
	}

}
