package com.soramusoka.destinyApiClient.dto_layer.custom_errors;

public class DestinyApiClientException extends Exception {
    public DestinyApiClientException() {

    }

    public DestinyApiClientException(String message) {
        super(message);
    }

    public DestinyApiClientException(Throwable cause) {
        super(cause);
    }

    public DestinyApiClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
