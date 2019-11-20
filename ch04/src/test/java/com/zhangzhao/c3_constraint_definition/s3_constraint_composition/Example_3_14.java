package com.zhangzhao.c3_constraint_definition.s3_constraint_composition;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.zhangzhao.c3_constraint_definition.s3_constraint_composition.Example_3_14.EmmanuelsEmail.List;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/**
 * Use of constraintIndex in @OverridesAttribute
 */
public class Example_3_14 {

  @Documented
  @Constraint(validatedBy = {})
  @Pattern(regexp = "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}") // email
  @Pattern(regexp = ".*?emmanuel.*?") // emmanuel
  @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
  @Retention(RUNTIME)
  @Repeatable(List.class)
  public @interface EmmanuelsEmail {

    String message() default "Not emmanuel's email";

    @OverridesAttribute(constraint = Pattern.class, name = "message", constraintIndex = 0)
    String emailMessage() default "Not an email";

    @OverridesAttribute(constraint = Pattern.class, name = "message", constraintIndex = 1)
    String emmanuelMessage() default "Not Emmanuel";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {

      EmmanuelsEmail[] value();
    }
  }

}
