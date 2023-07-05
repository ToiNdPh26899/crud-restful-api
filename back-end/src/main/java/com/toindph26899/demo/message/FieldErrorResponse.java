package com.toindph26899.demo.message;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FieldErrorResponse {

    private List<ErrorMessage> fieldErrors;

    public FieldErrorResponse() {

    }

    public FieldErrorResponse(List<ErrorMessage> errorMessages) {
        this.fieldErrors = errorMessages;
    }
}
