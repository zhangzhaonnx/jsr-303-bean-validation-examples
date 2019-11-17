package com.zhangzhao.ch05;

import com.zhangzhao.ch04.s2_constraint_violation.core.NotEmpty;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import javax.validation.metadata.BeanDescriptor;
import javax.validation.metadata.ConstraintDescriptor;
import javax.validation.metadata.PropertyDescriptor;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

public class Example_5_6_1 {

  @Test
  public void name() {
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    BeanDescriptor bookDescriptor = validator.getConstraintsForClass(Book.class);
    assert !bookDescriptor.hasConstraints();
    assert bookDescriptor.isBeanConstrained();
    assert bookDescriptor.getConstraintDescriptors().size() == 0; //no bean-level constraint
    //more specifically "author" and "title"
    assert bookDescriptor.getConstrainedProperties().size() == 2;
    //not a property
    assert bookDescriptor.getConstraintsForProperty("doesNotExist") == null;
    //property with no constraint
    assert bookDescriptor.getConstraintsForProperty("description") == null;

    PropertyDescriptor propertyDescriptor = bookDescriptor.getConstraintsForProperty("title");
    assert propertyDescriptor.getConstraintDescriptors().size() == 2;
    assert "title".equals(propertyDescriptor.getPropertyName());
    //assuming the implementation returns the @NotEmpty constraint first

    Set<ConstraintDescriptor<?>> constraintDescriptors = propertyDescriptor
        .getConstraintDescriptors();
    ConstraintDescriptor<?> constraintDescriptor = constraintDescriptors.stream()
        .filter(cd -> cd.getAnnotation() instanceof NotEmpty)
        .findFirst().orElse(null);
    ConstraintDescriptor<NotEmpty> notEmptyConstraintDescriptor = (ConstraintDescriptor<NotEmpty>) constraintDescriptor;
    assert notEmptyConstraintDescriptor.getAnnotation().annotationType().equals(NotEmpty.class);
    assert notEmptyConstraintDescriptor.getGroups().size() == 2; //FirstLevelCheck and Default
    assert notEmptyConstraintDescriptor.getComposingConstraints().size() == 2;
    assert notEmptyConstraintDescriptor.isReportAsSingleViolation();
    //@NotEmpty cannot be null
    boolean notNullPresence = false;
    for (ConstraintDescriptor<?> composingDescriptor : constraintDescriptor
        .getComposingConstraints()) {
      if (composingDescriptor.getAnnotation() instanceof NotNull) {
        notNullPresence = true;
      }
      assert notNullPresence;

      //assuming the implementation returns the Size constraint second
      constraintDescriptor = constraintDescriptors.stream()
          .filter(cd -> cd.getAnnotation() instanceof Size)
          .findFirst().orElse(null);
      ConstraintDescriptor<Size> sizeConstraintDescriptor = (ConstraintDescriptor<Size>) constraintDescriptor;
      assert sizeConstraintDescriptor.getAnnotation().annotationType().equals(Size.class);
      assert sizeConstraintDescriptor.getAnnotation().max() == 30;
      assert (int) sizeConstraintDescriptor.getAttributes().get("max") == 30;
      assert sizeConstraintDescriptor.getGroups().size() == 1;

      propertyDescriptor = bookDescriptor.getConstraintsForProperty("author");
      assert propertyDescriptor.getConstraintDescriptors().size() == 1;
      assert propertyDescriptor.isCascaded();
    }
  }

  @Setter
  @Getter
  public static class Author {

    private String firstName;

    @NotEmpty(message = "lastname must not be null")
    private String lastName;

    @Size(max = 30)
    private String company;
  }

  @Setter
  @Getter
  public static class Book {

    private String title;

    private String description;

    @Valid
    @NotNull
    private Author author;

    @NotEmpty(groups = {FirstLevelCheck.class, Default.class})
    @Size(max = 30)
    public String getTitle() {
      return title;
    }
  }

  public interface FirstLevelCheck {

  }
}
