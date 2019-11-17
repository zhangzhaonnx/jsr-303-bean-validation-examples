package com.zhangzhao.ch04.s4_bootstrapping;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import com.zhangzhao.ch04.s4_bootstrapping.core.ContainerComponentConstraintValidatorFactory;
import com.zhangzhao.ch04.s4_bootstrapping.core.ContainerMessageInterpolator;
import com.zhangzhao.ch04.s4_bootstrapping.core.JPAAwareTraversableResolver;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.hibernate.validator.internal.engine.ValidatorImpl;
import org.junit.Test;

/**
 * Customize message resolution, traversable resolver and constraint Validator factory
 * implementation
 */
public class Example_4_6 {


  @Test
  public void name() {
    //some customization from a container
    ValidatorFactory factory = Validation
        .byDefaultProvider().configure()
        .messageInterpolator(new ContainerMessageInterpolator())
        .constraintValidatorFactory(new ContainerComponentConstraintValidatorFactory())
        .traversableResolver(new JPAAwareTraversableResolver())
        .buildValidatorFactory();

    //cache the factory somewhere
    Validator validator = factory.getValidator();

    assertThat(factory.getMessageInterpolator(), instanceOf(ContainerMessageInterpolator.class));
    assertThat(factory.getConstraintValidatorFactory(), instanceOf(ContainerComponentConstraintValidatorFactory.class));
    assertThat(factory.getTraversableResolver(), instanceOf(JPAAwareTraversableResolver.class));
    assertThat(validator, instanceOf(ValidatorImpl.class));
  }
}
