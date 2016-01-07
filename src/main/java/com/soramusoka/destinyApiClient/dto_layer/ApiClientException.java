package com.soramusoka.destinyApiClient.dto_layer;

public class ApiClientException extends Exception {
    public ApiClientException() {

    }

    public ApiClientException(String message) {
        super(message);
    }

    public ApiClientException(Throwable cause) {
        super(cause);
    }

    public ApiClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
