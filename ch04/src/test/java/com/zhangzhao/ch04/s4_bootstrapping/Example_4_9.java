package com.zhangzhao.ch04.s4_bootstrapping;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import com.zhangzhao.ch04.s4_bootstrapping.core.LocaleSpecificMessageInterpolator;
import java.util.Locale;
import javax.validation.MessageInterpolator;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;

/**
 * Use a specific MessageInterpolator instance for a given Validator
 */
public class Example_4_9 {

  @Test
  public void name() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Locale locale = Locale.getDefault();
    MessageInterpolator customInterpolator = new LocaleSpecificMessageInterpolator(
        factory.getMessageInterpolator(),
        locale
    );
    Validator validator = factory.usingContext()
        .messageInterpolator(customInterpolator)
        .getValidator();

    assertThat(validator, notNullValue());
  }
}
