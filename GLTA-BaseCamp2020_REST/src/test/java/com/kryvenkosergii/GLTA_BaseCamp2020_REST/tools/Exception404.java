package com.kryvenkosergii.GLTA_BaseCamp2020_REST.tools;

public class Exception404 extends CommonException {
	private static final long serialVersionUID = 1L;

	public Exception404() {
		super();
	}

	public Exception404(Exception e) {
		super(e);
	}
	
	public Exception404(String message) {
		super(message);
	}
	
	public Exception404(String message, Exception e) {
		super(message, e);
	}
}
