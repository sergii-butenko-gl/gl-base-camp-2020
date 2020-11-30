package com.kryvenkosergii.GLTA_BaseCamp2020_REST.tools;

public class CommonException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CommonException() {
		super();
	}

	public CommonException(Exception e) {
		super(e);
	}
	
	public CommonException(String message) {
		super(message);
	}
	
	public CommonException(String message, Exception e) {
		super(message, e);
	}
	
}
