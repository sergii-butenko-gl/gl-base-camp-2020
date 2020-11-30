package com.kryvenkosergii.GLTA_BaseCamp2020_REST.data;

public class SupportData {

    private String url;
    private String text;

    public SupportData(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "SupportData [url=" + url + ", text=" + text + "]";
    }

}
