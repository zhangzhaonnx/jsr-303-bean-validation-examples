package com.zhangzhao.ch03.s4_constraint_validation_implementation;

import java.util.Collection;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Size;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

/**
 * Valid ConstraintValidator definitions
 */
public class Example_3_16 {

  /**
   * String is not making use of generics
   */
  private class SizeValidatorForString implements ConstraintValidator<Size, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      return false;
    }
  }

  /**
   * Collection uses generics but the raw type is used
   */
  private class SizeValidatorForCollection implements ConstraintValidator<Size, Collection> {

    @Override
    public boolean isValid(Collection value, ConstraintValidatorContext context) {
      return false;
    }
  }

  /**
   * Collection uses generics and unbounded wildcard type
   */
  private class SizeValidatorForCollection2 implements ConstraintValidator<Size, Collection<?>> {

    @Override
    public boolean isValid(Collection<?> value, ConstraintValidatorContext context) {
      return false;
    }
  }

  /**
   * Validator for cross-parameter constraint
   */
  @SupportedValidationTarget(ValidationTarget.PARAMETERS)
  private class DateParametersConsistentValidator
      implements ConstraintValidator<DateParametersConsistent, Object[]> {

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
      return false;
    }
  }

  /**
   * Validator for both annotated elements and executable parameters
   */
  @SupportedValidationTarget({
      ValidationTarget.ANNOTATED_ELEMENT,
      ValidationTarget.PARAMETERS})
  private class ELScriptValidator implements ConstraintValidator<ELScript, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
      return false;
    }
  }


  public @interface DateParametersConsistent {

  }

  public @interface ELScript {

  }
}
