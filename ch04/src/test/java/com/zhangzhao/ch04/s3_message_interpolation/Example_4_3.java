package com.zhangzhao.ch04.s3_message_interpolation;

import com.zhangzhao.ch04.s4_bootstrapping.core.LocaleSpecificMessageInterpolator;
import java.util.Locale;
import javax.validation.Configuration;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;

/**
 * Use MessageInterpolator to use a specific Locale value
 */
public class Example_4_3 {


  @Test
  public void name() {
    Configuration<?> configuration = Validation.byDefaultProvider().configure();

    ValidatorFactory factory = configuration
        .messageInterpolator(
            new LocaleSpecificMessageInterpolator(
                configuration.getDefaultMessageInterpolator(),
                Locale.CHINA)
        )
        .buildValidatorFactory();

    Validator validator = factory.getValidator();
  }
}
