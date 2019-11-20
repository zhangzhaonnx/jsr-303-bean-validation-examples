package com.zhangzhao.c3_constraint_definition.s4_constraint_validation_implementation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Use of ConstraintValidatorContext
 */
public class Example_3_22 {

  /**
   * Check that a String begins with "SN-" and has a specified length.
   * <p>
   * Error messages are using either key:
   * <ul>
   * <li>com.acme.constraint.SerialNumber.wrongprefix if the string doesn't begin with
   * "SN-"</li>
   * <li>com.acme.constraint.SerialNumber.wronglength if the string doesn't have the
   * specified length</li>
   * </ul>
   */
  public class SerialNumberValidator implements ConstraintValidator<SerialNumber, String> {

    private int length;

    /**
     * Configure the constraint validator based on the elements specified at the time it was
     * defined.
     *
     * @param constraint the constraint definition
     */
    @Override
    public void initialize(SerialNumber constraint) {
      this.length = constraint.length();
    }

    /**
     * Validate a specified value. returns false if the specified value does not conform to the
     * definition.
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      if (value == null) {
        return true;
      }

      context.disableDefaultConstraintViolation();

      if (!value.startsWith("SN-")) {
        String wrongPrefix = "{com.acme.constraint.SerialNumber.wrongprefix}";
        context.buildConstraintViolationWithTemplate(wrongPrefix)
            .addConstraintViolation();
        return false;
      }
      if (value.length() != length) {
        String wrongLength = "{com.acme.constraint.SerialNumber.wronglength}";
        context.buildConstraintViolationWithTemplate(wrongLength)
            .addConstraintViolation();
        return false;
      }
      return true;
    }
  }

  public @interface SerialNumber {

    int length();
  }
}
