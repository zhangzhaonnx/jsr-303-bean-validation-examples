package com.zhangzhao.ch04.s4_bootstrapping.core;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;

public class ContainerComponentConstraintValidatorFactory implements ConstraintValidatorFactory {

  @Override
  public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
    return null;
  }

  @Override
  public void releaseInstance(ConstraintValidator<?, ?> instance) {

  }
}
