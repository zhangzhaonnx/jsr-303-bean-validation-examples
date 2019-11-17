package com.zhangzhao.ch05;

import com.zhangzhao.ch04.s2_constraint_violation.core.NotEmpty;
import java.lang.annotation.ElementType;
import java.util.Set;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import javax.validation.metadata.ConstraintDescriptor;
import javax.validation.metadata.PropertyDescriptor;
import javax.validation.metadata.Scope;
import org.junit.Test;

/**
 * Using the fluent API to restrict matching constraints
 */
public class Example_5_1 {

  @Test
  public void name() {
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    PropertyDescriptor pd =
        validator.getConstraintsForClass(Customer.class).getConstraintsForProperty("name");

    Set<ConstraintDescriptor<?>> constraints =
        pd.findConstraints()
            .declaredOn(ElementType.METHOD)
            .unorderedAndMatchingGroups(Default.class)
            .lookingAt(Scope.LOCAL_ELEMENT)
            .getConstraintDescriptors();

    assert 1 == constraints.size();
    constraints = pd.getConstraintDescriptors();
    assert 3 == constraints.size();
  }

  public static class User {

    @NotEmpty
    private String name;

    @Size(max = 50)
    String getName() {
      return name;
    }
  }

  public static class Customer extends User {

    @NotNull
    String getName() {
      return "customer";
    }
  }
}
