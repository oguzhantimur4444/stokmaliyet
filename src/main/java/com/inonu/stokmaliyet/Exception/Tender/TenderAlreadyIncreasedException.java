package com.inonu.stokmaliyet.Exception.Tender;

public class TenderAlreadyIncreasedException extends RuntimeException {
    public TenderAlreadyIncreasedException(String message) {
        super(message);
    }
}
