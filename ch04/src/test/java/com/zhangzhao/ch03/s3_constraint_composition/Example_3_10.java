package com.zhangzhao.ch03.s3_constraint_composition;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.zhangzhao.ch03.s3_constraint_composition.Example_3_10.FrenchZipCode.List;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Composition is done by annotating the composed constraint
 */
public class Example_3_10 {

  @Pattern(regexp = "[0-9]*")
  @Size(min = 5, max = 5)
  @Constraint(validatedBy = FrenchZipCodeValidator.class)
  @Documented
  @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
  @Retention(RUNTIME)
  @Repeatable(List.class)
  public @interface FrenchZipCode {

    String message() default "Wrong zip code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {

      FrenchZipCode[] value();
    }
  }

  private static class FrenchZipCodeValidator implements
      ConstraintValidator<FrenchZipCode, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      return false;
    }
  }
}
