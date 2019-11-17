package com.zhangzhao.ch04.s2_constraint_violation.core;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotEmptyValidator implements ConstraintValidator<NotEmpty, String> {

  public void initialize(NotEmpty constraintAnnotation) {
  }

  public boolean isValid(String value, ConstraintValidatorContext context) {
    return true;
  }
}
