package com.zhangzhao.ch04;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.hibernate.validator.internal.engine.resolver.JPATraversableResolver;
import org.junit.Test;

/**
 * Use of ValidatorFactory
 */
public class Example_4_13 {

  @Test
  public void name() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validatorUsingDefaults = factory.getValidator();
    Validator validatorUsingCustomTraversable = factory.usingContext()
        .traversableResolver(new JPATraversableResolver())
        .getValidator();

    assertThat(validatorUsingDefaults, notNullValue());
    assertThat(validatorUsingCustomTraversable, notNullValue());
  }
}
