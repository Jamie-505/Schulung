package com.exxeta.validation;

import com.exxeta.entities.Training;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TrainingDurationValidatorTest {

    @Test
    void isValid() {
        Training training = Training.builder().name("Java EE")
                .beginn(LocalDate.of(2019, 6, 1))
                .ende(LocalDate.of(2019, 6, 5))
                .build();
        TrainingDurationValidator validator = new TrainingDurationValidator();
        assertTrue(validator.isValid(training, null));
    }

    @Test
    void durationTooLong() {
        Training training = Training.builder().name("Java EE")
                .beginn(LocalDate.of(2019, 6, 1))
                .ende(LocalDate.of(2019, 6, 6))
                .build();
        TrainingDurationValidator validator = new TrainingDurationValidator();
        assertFalse(validator.isValid(training, null));
    }
}