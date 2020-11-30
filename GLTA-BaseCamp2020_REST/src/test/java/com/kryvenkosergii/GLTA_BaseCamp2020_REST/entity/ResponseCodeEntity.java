package com.kryvenkosergii.GLTA_BaseCamp2020_REST.entity;

public class ResponseCodeEntity {

	private int responsecode;

	public ResponseCodeEntity() {
		responsecode = -1;
	}
	
	public ResponseCodeEntity(int responsecode) {
		this.responsecode = responsecode;
	}

	public int getResponsecode() {
		return responsecode;
	}

	@Override
	public String toString() {
		return "SimpleEntity [responsecode=" + responsecode + "]";
	}

}
