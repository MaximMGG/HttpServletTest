package com.httpservlet.test.httpservlets.servlet.validator;

public interface Validator<T> {
    
    ValidationResult isValid(T objrct);
}
