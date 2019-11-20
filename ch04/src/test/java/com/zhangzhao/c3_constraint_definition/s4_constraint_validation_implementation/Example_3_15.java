package com.zhangzhao.c3_constraint_definition.s4_constraint_validation_implementation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

/**
 * Example of cross parameter ConstraintValidator
 */
public class Example_3_15 {

  @SupportedValidationTarget(ValidationTarget.PARAMETERS)
  private static class ScriptAssertValidator implements
      ConstraintValidator<ScriptAssert, Object[]> {

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
      return false;
    }
  }

  private @interface ScriptAssert {

  }
}
