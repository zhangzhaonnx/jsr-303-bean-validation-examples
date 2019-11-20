package com.zhangzhao.c3_constraint_definition.s3_constraint_composition;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.zhangzhao.c3_constraint_definition.s3_constraint_composition.Example_3_13.FrenchZipCode.List;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Attributes from composing annotations can be overridden by attributes from the composed
 * annotation
 */
public class Example_3_13 {

  @Pattern(regexp = "[0-9]*")
  @Size
  @Constraint(validatedBy = FrenchZipCodeValidator.class)
  @Documented
  @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
  @Retention(RUNTIME)
  @Repeatable(List.class)
  public @interface FrenchZipCode {

    String message() default "Wrong zip code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @OverridesAttribute(constraint = Size.class, name = "min")
    @OverridesAttribute(constraint = Size.class, name = "max")
    int size() default 5;

    @OverridesAttribute(constraint = Size.class, name = "message")
    String sizeMessage() default "{com.acme.constraint.FrenchZipCode.zipCode.size}";

    @OverridesAttribute(constraint = Pattern.class, name = "message")
    String numberMessage() default "{com.acme.constraint.FrenchZipCode.number.size}";

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
