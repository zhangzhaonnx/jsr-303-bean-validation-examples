package com.zhangzhao.ch04;

import com.zhangzhao.ch04.mock.acme.ACMEProvider;
import com.zhangzhao.ch04.mock.acme.ACMEValidatorFactory;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import org.junit.Test;

public class Example_4_11 {

  /**
   * Using unwrap to access a provider specific contract
   */
  @Test
  public void name() {
    ValidatorFactory factory = Validation.byProvider(ACMEProvider.class)
        .configure()
        .buildValidatorFactory();
    ACMEValidatorFactory acmeFactory = factory.unwrap(ACMEValidatorFactory.class);
    acmeFactory.setSpecificConfiguration();
  }
}
