package org.design.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.design.exception.DateTimeParsingException;
import org.design.exception.interceptor.ExceptionLogger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@ApplicationScoped
public class DateTimeConverter {

    @ExceptionLogger
    public LocalDate convertStringToDate(String date, String dateFormat) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
            return LocalDate.parse(date, dateTimeFormatter);
        } catch (DateTimeParseException exception) {
            throw new DateTimeParsingException("Could not parse");
        }
    }
}
