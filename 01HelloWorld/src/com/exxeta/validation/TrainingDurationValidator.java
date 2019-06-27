package com.exxeta.validation;

import com.exxeta.entities.Training;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TrainingDurationValidator implements ConstraintValidator<ValidDuration, Training> {
   public void initialize(ValidDuration constraint) {
   }

   @Override
   public boolean isValid(Training training, ConstraintValidatorContext context) {
      LocalDate beginn = training.getBeginn();
      LocalDate ende = training.getEnde();

      if (beginn == null || ende == null) {
         return false;
      }

      if (beginn.isAfter(ende)) {
         return false;
      }

      long numberOfDays = ChronoUnit.DAYS.between(beginn, ende) + 1;
      return numberOfDays <= 5;
   }
}
