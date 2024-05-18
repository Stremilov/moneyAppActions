package org.dev13pl.hackatonitonebackend.exception;

public class UserExistsException extends RuntimeException {
    public UserExistsException() {
        super("User already exists");
    }
}
