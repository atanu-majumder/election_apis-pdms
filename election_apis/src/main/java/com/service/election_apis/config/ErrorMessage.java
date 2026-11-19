package com.service.election_apis.config;

public class ErrorMessage {

	private int statusCode;
    private String title;
    private String response;

    public ErrorMessage() {
    }

    public ErrorMessage(int statusCode, String title, String response) {
        this.statusCode = statusCode;
        this.title = title;
        this.response = response;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
