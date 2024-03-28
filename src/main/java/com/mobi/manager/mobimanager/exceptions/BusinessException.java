package com.mobi.manager.mobimanager.exceptions;

public class BusinessException extends RuntimeException {

    private static final long serialVersionID = 1L;

    public BusinessException(String message) {
        super(message);
    }
}
