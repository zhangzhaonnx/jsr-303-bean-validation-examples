package com.zhangzhao.ch03.s1_constraint_annotation;

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
 * Constraint definition with mandatory parameter
 */
public class Example_3_6 {

  /**
   * Defines the list of values accepted. Accepts int or Integer objects.
   */
  @Documented
  @Constraint(validatedBy = DiscreteListOfIntegerValidator.class)
  @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
  @Retention(RUNTIME)
  private @interface Acceptable {

    int[] value();

    String message() default "{com.acme.constraint.Acceptable.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
  }

  private static class DiscreteListOfIntegerValidator implements
      ConstraintValidator<Acceptable, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
      return false;
    }
  }
}
