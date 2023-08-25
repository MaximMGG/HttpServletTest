package com.httpservlet.test.httpservlets.servlet.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class LocalDateFormatter {
    
    private static final String PATTERN = "yyyy-MM-dd";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

    public static LocalDate format(String date) {
        return LocalDate.parse(date, FORMATTER);
    }

    public static boolean isValid(String date) {
        try {
            return Optional.ofNullable(date)
                            .map(LocalDateFormatter::format)
                            .isPresent();
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
}
