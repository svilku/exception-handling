package org.design;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.design.entity.ExceptionEntity;
import org.design.exception.DateTimeParsingException;
import org.design.repository.ExceptionRepository;
import org.design.service.DateTimeConverter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
class DateTimeConverterTest {

    @Inject
    DateTimeConverter dateTimeConverter;

    @Inject
    ExceptionRepository repository;

    @Test
    void convertStringToDate() {
        //Arrange & Act
        LocalDate date = dateTimeConverter.convertStringToDate("01-Jan-2017", "dd-MMM-yyyy");

        //Assert
        assertThat(date).isEqualTo("2017-01-01");
    }

    @Test
    @Disabled
    void throw_exception_convertStringToDate() {
        assertThrows(DateTimeParsingException.class,
                () -> dateTimeConverter.convertStringToDate("01-Jan-2017", "yyyy-MM-dd"));

    }

    @Test
    void save_exception_convertStringToDate() {
        //Arrange & Act
        dateTimeConverter.convertStringToDate("01-Jan-2017", "yyyy-MM-dd");

        //Assert
        List<ExceptionEntity> entity = repository.listAll();
        assertThat(entity.size()).isOne();
    }

}