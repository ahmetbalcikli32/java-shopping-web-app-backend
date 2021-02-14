package com.ahmetbalcikli.shoppingWebApp.tools.exceptions;

import lombok.Data;

@Data
public class RecordNotFountException extends RuntimeException {

    private String message;

    public RecordNotFountException(String message) {
        super(message);
    }
}
