package com.httpservlet.test.httpservlets.servlet.exception;
import java.util.List;

import com.httpservlet.test.httpservlets.servlet.validator.Error;

import lombok.Getter;

public class ValidationException extends RuntimeException {

    @Getter
    private final List<Error> errors;

    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }
    
}
