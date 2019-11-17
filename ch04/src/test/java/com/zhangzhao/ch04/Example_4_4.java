package com.zhangzhao.ch04;

import com.zhangzhao.ch04.mock.ContextualMessageInterpolator;
import javax.validation.Configuration;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;

/**
 * Contextual container possible MessageInterpolator implementation
 */
public class Example_4_4 {

  @Test
  public void name() {
    Configuration<?> configuration = Validation.byDefaultProvider().configure();

    ValidatorFactory factory = configuration
        .messageInterpolator(
            new ContextualMessageInterpolator(configuration.getDefaultMessageInterpolator()))
        .buildValidatorFactory();

    Validator validator = factory.getValidator();
  }
}
