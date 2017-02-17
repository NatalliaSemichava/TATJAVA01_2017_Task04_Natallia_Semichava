package com.company.catalog.dao.connection.exception;

public class ConnectionException extends Exception {
    private static final long serialVersionUID = 1L;
    public ConnectionException(String message, Exception e){
        super(message, e);
    }
}
