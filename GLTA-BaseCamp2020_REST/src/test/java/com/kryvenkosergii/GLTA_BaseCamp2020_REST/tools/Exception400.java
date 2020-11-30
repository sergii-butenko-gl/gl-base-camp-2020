package com.kryvenkosergii.GLTA_BaseCamp2020_REST.tools;

public class Exception400 extends CommonException {
	private static final long serialVersionUID = 1L;

	public Exception400() {
		super();
	}

	public Exception400(Exception e) {
		super(e);
	}
	
	public Exception400(String message) {
		super(message);
	}
	
	public Exception400(String message, Exception e) {
		super(message, e);
	}
}
