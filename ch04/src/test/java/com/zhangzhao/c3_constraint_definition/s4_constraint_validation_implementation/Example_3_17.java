package com.zhangzhao.c3_constraint_definition.s4_constraint_validation_implementation;

import java.util.Collection;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Size;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

/**
 * Invalid ConstraintValidator definitions
 */
public class Example_3_17 {

  /**
   * parameterized type
   */
  private class SizeValidatorForString implements ConstraintValidator<Size, Collection<String>> {

    @Override
    public boolean isValid(Collection<String> value, ConstraintValidatorContext context) {
      return false;
    }
  }

  /**
   * parameterized type using bounded wildcard
   */
  private class SizeValidatorForCollection implements ConstraintValidator<Size, Collection<?
      extends Address>> {

    @Override
    public boolean isValid(Collection<? extends Address> value,
        ConstraintValidatorContext context) {
      return false;
    }
  }

  /**
   * cross-parameter validator accepting the wrong type
   */
  @SupportedValidationTarget(ValidationTarget.PARAMETERS)
  private class NumberPositiveValidator implements ConstraintValidator<NumberPositive, Number> {

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
      return false;
    }
  }

  private class Address {

  }

  private @interface NumberPositive {

  }
}
