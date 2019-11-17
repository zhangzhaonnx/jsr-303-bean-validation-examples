package com.zhangzhao.ch04;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.hibernate.validator.internal.engine.ValidatorImpl;
import org.junit.Test;

/**
 * Simple Bean Validation bootstrap sequence
 */
public class Example_4_5 {

  @Test
  public void name() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    //cache the factory somewhere
    Validator validator = factory.getValidator();

    assertThat(validator, instanceOf(ValidatorImpl.class));
  }
}
