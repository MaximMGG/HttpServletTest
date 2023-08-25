package com.httpservlet.test.httpservlets.servlet.validator;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

    private List<Error> errors = new ArrayList<Error>();

    public List<Error> getErrors() {
        return errors;
    }

    public void add(Error error) {
        this.errors.add(error);
    }

    public boolean isValid() {
        return errors.isEmpty();
    }

    
}
