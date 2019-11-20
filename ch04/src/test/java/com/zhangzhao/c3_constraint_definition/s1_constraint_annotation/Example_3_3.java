package com.zhangzhao.c3_constraint_definition.s1_constraint_annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

/**
 * Simple cross-parameter constraint definition
 */
public class Example_3_3 {

  /**
   * Cross-parameter constraint ensuring that two date parameters of a method are in the correct
   * order.
   */
  @Documented
  @Constraint(validatedBy = DateParametersConsistentValidator.class)
  @Target({METHOD, CONSTRUCTOR, ANNOTATION_TYPE})
  @Retention(RUNTIME)
  public @interface DateParametersConsistent {

    String message() default "{com.acme.constraint.DateParametersConsistent.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
  }


  private static class DateParametersConsistentValidator implements
      ConstraintValidator<DateParametersConsistent, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
      return false;
    }
  }
}
