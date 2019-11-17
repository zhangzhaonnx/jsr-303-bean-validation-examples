package com.zhangzhao.ch04;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import com.zhangzhao.ch04.mock.Address;
import com.zhangzhao.ch04.mock.ContainerMessageInterpolator;
import com.zhangzhao.ch04.mock.acme.ACMEConstraintDescriptor;
import com.zhangzhao.ch04.mock.acme.ACMEProvider;
import com.zhangzhao.ch04.mock.acme.ACMEValidator;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;

/**
 * Use a specific provider and add specific configuration
 */
public class Example_4_8 {

  @Test
  public void name() {
    ValidatorFactory factory = Validation
        .byProvider(ACMEProvider.class)  //chose a specific provider
        .configure()
        .messageInterpolator(new ContainerMessageInterpolator()) //default configuration option
        .addConstraint(Address.class, new ACMEConstraintDescriptor()) //ACME specific method
        .buildValidatorFactory();

    //cache the factory somewhere
    Validator validator = factory.getValidator();

    assertThat(validator, instanceOf(ACMEValidator.class));
  }
}
