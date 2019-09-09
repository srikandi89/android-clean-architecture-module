package com.trackdesk.domain.entities.register;

public class RegisterResponseEntity {
    private int statusCode;
    private String accessToken;

    public RegisterResponseEntity() {}

    public RegisterResponseEntity(int statusCode, String accessToken) {
        this.statusCode = statusCode;
        this.accessToken = accessToken;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
