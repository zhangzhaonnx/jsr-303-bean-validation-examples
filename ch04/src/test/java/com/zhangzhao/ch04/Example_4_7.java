package com.zhangzhao.ch04;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import com.zhangzhao.ch04.mock.OSGiServiceDiscoverer;
import com.zhangzhao.ch04.mock.acme.ACMEValidator;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;

/**
 * Customize the Bean Validation provider resolution mechanism
 */
public class Example_4_7 {

  @Test
  public void name() {
    //osgi environment
    ValidatorFactory factory = Validation
        .byDefaultProvider()
        .providerResolver(new OSGiServiceDiscoverer())
        .configure()
        .buildValidatorFactory();

    //cache the factory somewhere
    Validator validator = factory.getValidator();

    assertThat(validator, instanceOf(ACMEValidator.class));
  }
}
