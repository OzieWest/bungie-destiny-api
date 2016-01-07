package com.soramusoka.destinyApiClient.dto_layer;

public class ApiClientException extends Exception {
    public String ErrorStatus;
    public int ErrorCode;

    public ApiClientException() {

    }

    public ApiClientException(String message) {
        super(message);
    }

    public ApiClientException(String message, String errorStatus) {
        super(message);
        this.ErrorStatus = errorStatus;
    }

    public ApiClientException(String message, String errorStatus, int errorCode) {
        super(message);
        this.ErrorStatus = errorStatus;
        this.ErrorCode = errorCode;
    }

    public ApiClientException(Throwable cause) {
        super(cause);
    }

    public ApiClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
