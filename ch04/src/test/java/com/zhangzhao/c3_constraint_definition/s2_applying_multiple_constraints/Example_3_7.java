package com.zhangzhao.c3_constraint_definition.s2_applying_multiple_constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.zhangzhao.c3_constraint_definition.s2_applying_multiple_constraints.Example_3_7.ZipCode.List;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

/**
 * Multi-valued constraint definition
 */
public class Example_3_7 {

  /**
   * Validate a zip code for a given country The only supported type is String
   */
  @Documented
  @Constraint(validatedBy = ZipCodeValidator.class)
  @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
  @Retention(RUNTIME)
  @Repeatable(List.class)
  public @interface ZipCode {

    String countryCode();

    String message() default "{com.acme.constraint.ZipCode.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Defines several @ZipCode annotations on the same element
     *
     * @see {@link ZipCode}
     */
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {

      ZipCode[] value();
    }
  }

  private static class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      return false;
    }
  }
}
