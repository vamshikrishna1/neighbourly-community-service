package com.neighbourly.community.exception;

public class CommunityNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CommunityNotFoundException(String message) {
        super(message);
    }

    public CommunityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
