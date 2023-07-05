package com.toindph26899.demo.exception;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;

public class NumberException extends RuntimeException {

    public NumberException(String msg) {
        super(msg);
    }

}
