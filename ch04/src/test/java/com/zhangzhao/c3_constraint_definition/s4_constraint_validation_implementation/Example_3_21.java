package com.zhangzhao.c3_constraint_definition.s4_constraint_validation_implementation;

import com.zhangzhao.c3_constraint_definition.s4_constraint_validation_implementation.Example_3_16.ELScript;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

/**
 * Generic and cross-parameter validator implementation
 */
public class Example_3_21 {

  /**
   * Checks that an object passes the Expression Language expression provided by the constraint.
   */
  @SupportedValidationTarget({ValidationTarget.ANNOTATED_ELEMENT, ValidationTarget.
      PARAMETERS})
  public class ELScriptValidator implements ConstraintValidator<ELScript, Object> {

    public boolean isValid(Object value, ConstraintValidatorContext context) {
      return false;
    }
  }
}
