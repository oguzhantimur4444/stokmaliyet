package com.inonu.stokmaliyet.Exception.Tender;

public class TenderNotFoundException extends RuntimeException {
    public TenderNotFoundException(String message) {
        super(message);
    }
}
