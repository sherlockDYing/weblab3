package com.lab3.demo.response;

public class ErrorResponse {
    private String description;

    public ErrorResponse(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
