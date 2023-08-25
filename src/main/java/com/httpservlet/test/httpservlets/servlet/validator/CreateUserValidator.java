package com.httpservlet.test.httpservlets.servlet.validator;

import com.httpservlet.test.httpservlets.servlet.dto.CreateUserDto;
import com.httpservlet.test.httpservlets.servlet.entity.Gender;
import com.httpservlet.test.httpservlets.servlet.utils.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    private CreateUserValidator(){}

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        ValidationResult validationResult = new ValidationResult();
        if (!LocalDateFormatter.isValid(object.getBirthday())) {
            validationResult.add(Error.of("invalid.birthday", "Birthday is invalid"));
        }
        if (object.getGender() == null ||Gender.valueOf(object.getGender()) == null) {
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }
        return validationResult;
        
    }
    
    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
