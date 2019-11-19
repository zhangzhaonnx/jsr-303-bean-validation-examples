package com.zhangzhao.ch03.s1_constraint_annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.ConstraintTarget;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

/**
 * Constraint that is both generic and cross parameter
 */
public class Example_3_4 {

  @ELAssert(
      message = "Please check that your passwords match and try again.",
      expression = "param[1]==param[2]",
      validationAppliesTo = ConstraintTarget.PARAMETERS
  )
  public User createUser(String email, String password, String repeatPassword) {
    return null;
  }


  /**
   * EL expression to be validated. This constraint accepts any type and can validate both the
   * annotated type or apply restrictions across parameters.
   */
  @Documented
  @Constraint(validatedBy = ELAssertValidator.class)
  @Target({METHOD, FIELD, TYPE, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
  @Retention(RUNTIME)
  private @interface ELAssert {

    String message() default "{com.acme.constraint.ELAssert.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    ConstraintTarget validationAppliesTo() default ConstraintTarget.IMPLICIT;

    String expression();
  }

  private static class ELAssertValidator implements ConstraintValidator<ELAssert, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
      return false;
    }
  }

  private static class User {

  }
}
