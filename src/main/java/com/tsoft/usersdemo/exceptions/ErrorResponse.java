package com.tsoft.usersdemo.exceptions;

import java.util.List;

public class ErrorResponse {
    private List<String> message;

    public ErrorResponse(List<String> message) {
        this.message = message;
    }

    public List getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }


}
