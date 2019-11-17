package com.zhangzhao.ch04.mock.acme;

import javax.validation.ClockProvider;
import javax.validation.ConstraintValidatorFactory;
import javax.validation.MessageInterpolator;
import javax.validation.ParameterNameProvider;
import javax.validation.TraversableResolver;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.ValidatorContext;
import javax.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidatorFactory;

public class ACMEValidatorFactory implements ValidatorFactory {

  @Override
  public Validator getValidator() {
    return new ACMEValidator();
  }

  @Override
  public ValidatorContext usingContext() {
    return null;
  }

  @Override
  public MessageInterpolator getMessageInterpolator() {
    return null;
  }

  @Override
  public TraversableResolver getTraversableResolver() {
    return null;
  }

  @Override
  public ConstraintValidatorFactory getConstraintValidatorFactory() {
    return null;
  }

  @Override
  public ParameterNameProvider getParameterNameProvider() {
    return null;
  }

  @Override
  public ClockProvider getClockProvider() {
    return null;
  }

  @Override
  public <T> T unwrap(Class<T> type) {
    if (type.isAssignableFrom(ACMEValidatorFactory.class)) {
      return type.cast(this);
    }
    throw new ValidationException();
  }

  @Override
  public void close() {

  }

  public void setSpecificConfiguration() {

  }
}
