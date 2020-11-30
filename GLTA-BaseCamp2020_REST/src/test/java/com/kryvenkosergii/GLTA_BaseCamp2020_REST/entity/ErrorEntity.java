package com.kryvenkosergii.GLTA_BaseCamp2020_REST.entity;

public class ErrorEntity {
	private String timestamp;
	private int status;
	private String error;
	private String message;
	private String path;

	public ErrorEntity() {
		timestamp = "";
		status = -1;
		error = "";
		message = "";
		path = "";
	}
	
	public ErrorEntity(String timestamp, int status,
			String error, String message, String path) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public int getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

	@Override
	public String toString() {
		return "ErrorEntity [timestamp=" + timestamp
				+ ", status=" + status
				+ ", error=" + error
				+ ", message=" + message
				+ ", path=" + path + "]";
	}

}
