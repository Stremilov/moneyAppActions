package org.dev13pl.hackatonitonebackend.exception;

public class NoDateProvidedException extends RuntimeException {
    public NoDateProvidedException() {
        super("No date provided");
    }
}
