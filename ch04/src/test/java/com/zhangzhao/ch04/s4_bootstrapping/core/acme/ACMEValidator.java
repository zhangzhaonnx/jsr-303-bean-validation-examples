package com.zhangzhao.ch04.s4_bootstrapping.core.acme;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

public class ACMEValidator implements Validator {

  @Override
  public <T> Set<ConstraintViolation<T>> validate(T object, Class<?>... groups) {
    return null;
  }

  @Override
  public <T> Set<ConstraintViolation<T>> validateProperty(T object, String propertyName,
      Class<?>... groups) {
    return null;
  }

  @Override
  public <T> Set<ConstraintViolation<T>> validateValue(Class<T> beanType, String propertyName,
      Object value, Class<?>... groups) {
    return null;
  }

  @Override
  public BeanDescriptor getConstraintsForClass(Class<?> clazz) {
    return null;
  }

  @Override
  public <T> T unwrap(Class<T> type) {
    return null;
  }

  @Override
  public ExecutableValidator forExecutables() {
    return null;
  }
}
