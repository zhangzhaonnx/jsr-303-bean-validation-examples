package com.zhangzhao.c3_constraint_definition.s1_constraint_annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

/**
 * Simple constraint definition
 */
public class Example_3_2 {

  /**
   * Mark a String as representing a well formed order number
   */
  @Documented
  @Constraint(validatedBy = OrderNumberValidator.class)
  @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
  @Retention(RUNTIME)
  private @interface OrderNumber {

    String message() default "{com.acme.constraint.OrderNumber.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

  }

  private static class OrderNumberValidator implements ConstraintValidator<OrderNumber, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      return false;
    }
  }
}
