package com.zhangzhao.ch04.s4_bootstrapping;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import com.zhangzhao.ch04.s4_bootstrapping.core.ContainerMessageInterpolator;
import com.zhangzhao.ch04.s4_bootstrapping.core.JPAAwareTraversableResolver;
import com.zhangzhao.ch04.s4_bootstrapping.core.acme.ACMEConfigurationImpl;
import javax.validation.Configuration;
import javax.validation.ValidatorFactory;
import org.junit.Test;

/**
 * Use Configuration
 */
public class Example_4_17 {

  @Test
  public void name() {
    Configuration<?> configuration = new ACMEConfigurationImpl(null);
    ValidatorFactory factory = configuration
        .messageInterpolator(new ContainerMessageInterpolator())
        .traversableResolver(new JPAAwareTraversableResolver())
        .buildValidatorFactory();

    assertThat(factory, notNullValue());
  }
}
