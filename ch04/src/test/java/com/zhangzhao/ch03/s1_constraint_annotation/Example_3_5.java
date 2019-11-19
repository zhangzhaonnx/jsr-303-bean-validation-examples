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
 * Constraint definition with default parameter
 */
public class Example_3_5 {

  /**
   * A frequency in Hz as audible to human ear. Adjustable to the age of the person. Accepts
   * Numbers.
   */
  @Documented
  @Constraint(validatedBy = AudibleValidator.class)
  @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
  @Retention(RUNTIME)
  private @interface Audible {

    Age age() default Age.YOUNG;

    String message() default "{com.acme.constraint.Audible.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    enum Age {
      YOUNG,
      WONDERING,
      OLD
    }
  }


  private static class AudibleValidator implements ConstraintValidator<Audible, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
      return false;
    }
  }
}
