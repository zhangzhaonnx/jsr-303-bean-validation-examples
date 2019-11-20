package com.zhangzhao.c3_constraint_definition.s4_constraint_validation_implementation;

import java.time.ZonedDateTime;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Past;

/**
 * Validation of a temporal constraint
 */
public class Example_3_23 {

  /**
   * Validates that the given {@link ZonedDateTime} is in the past.
   */
  public class PastValidatorForZonedDateTime implements ConstraintValidator<Past,
      ZonedDateTime> {

    @Override
    public boolean isValid(ZonedDateTime value, ConstraintValidatorContext context) {
      if (value == null) {
        return true;
      }
      ZonedDateTime now = ZonedDateTime.now(context.getClockProvider().getClock());
      return value.isBefore(now);
    }
  }
}
