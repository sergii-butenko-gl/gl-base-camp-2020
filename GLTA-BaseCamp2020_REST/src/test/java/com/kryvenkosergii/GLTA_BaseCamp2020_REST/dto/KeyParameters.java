package com.kryvenkosergii.GLTA_BaseCamp2020_REST.dto;

public enum KeyParameters {

    NAME("name"),
    JOB("job"),
    PAGE("page");

    private String key;

    private KeyParameters(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        //return String.valueOf(key);
    	return key;
    }
}
