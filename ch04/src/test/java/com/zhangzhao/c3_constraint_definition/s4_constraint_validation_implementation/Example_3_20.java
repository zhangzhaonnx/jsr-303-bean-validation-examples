package com.zhangzhao.c3_constraint_definition.s4_constraint_validation_implementation;

import com.zhangzhao.c3_constraint_definition.s1_constraint_annotation.Example_3_3.DateParametersConsistent;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

/**
 * Cross-parameter validator implementation
 */
public class Example_3_20 {

  /**
   * Check that two date parameters of a method are in the expected order. Expects the 2nd and 3rd
   * parameter of the validated method to be of type java.util.Date.
   */
  @SupportedValidationTarget(ValidationTarget.PARAMETERS)
  private class DateParametersConsistentValidator implements
      ConstraintValidator<DateParametersConsistent, Object[]> {

    /**
     * Validate a specified value. returns false if the specified value does not conform to the
     * definition
     */
    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
      if (value.length != 3) {
        throw new IllegalArgumentException("Unexpected method signature");
      }
      // one or both limits are unbounded => always consistent
      if (value[1] == null || value[2] == null) {
        return true;
      }
      return ((Date) value[1]).before((Date) value[2]);
    }
  }
}
