package com.zhangzhao.c3_constraint_definition.s4_constraint_validation_implementation;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * ConstraintValidator implementation
 */
public class Example_3_19 {

  /**
   * Check that a String begins with one of the given prefixes.
   */
  private class BeginsWithValidator implements ConstraintValidator<BeginsWith, String> {

    private Set<String> allowedPrefixes;

    /**
     * Configure the constraint validator based on the elements specified at the time it was
     * defined.
     *
     * @param constraint the constraint definition
     */
    @Override
    public void initialize(BeginsWith constraint) {
      allowedPrefixes = Arrays.stream(constraint.value())
          .collect(collectingAndThen(toSet(), Collections::unmodifiableSet));
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
      return allowedPrefixes.stream().anyMatch(value::startsWith);
    }
  }

  public @interface BeginsWith {

    String[] value();
  }
}
