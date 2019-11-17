package com.zhangzhao.ch04.mock.acme;

import java.io.InputStream;
import javax.validation.BootstrapConfiguration;
import javax.validation.ClockProvider;
import javax.validation.ConstraintValidatorFactory;
import javax.validation.MessageInterpolator;
import javax.validation.ParameterNameProvider;
import javax.validation.TraversableResolver;
import javax.validation.ValidatorFactory;
import javax.validation.spi.BootstrapState;
import javax.validation.valueextraction.ValueExtractor;

/**
 * ACME specific validator configuration and configuration options
 */
public class ACMEConfigurationImpl implements ACMEConfiguration {

  public ACMEConfigurationImpl(BootstrapState state) {

  }

  @Override
  public ACMEConfiguration addConstraint(Class<?> entity,
      ACMEConstraintDescriptor constraintDescriptor) {
    return this;
  }

  @Override
  public ACMEConfiguration enableDynamicReloading(boolean b) {
    return this;
  }


  @Override
  public ACMEConfigurationImpl ignoreXmlConfiguration() {
    return null;
  }

  @Override
  public ACMEConfigurationImpl messageInterpolator(MessageInterpolator interpolator) {
    return this;
  }

  @Override
  public ACMEConfigurationImpl traversableResolver(TraversableResolver resolver) {
    return this;
  }

  @Override
  public ACMEConfigurationImpl constraintValidatorFactory(
      ConstraintValidatorFactory constraintValidatorFactory) {
    return this;
  }

  @Override
  public ACMEConfigurationImpl parameterNameProvider(ParameterNameProvider parameterNameProvider) {
    return null;
  }

  @Override
  public ACMEConfigurationImpl clockProvider(ClockProvider clockProvider) {
    return null;
  }

  @Override
  public ACMEConfigurationImpl addValueExtractor(ValueExtractor<?> extractor) {
    return null;
  }

  @Override
  public ACMEConfigurationImpl addMapping(InputStream stream) {
    return null;
  }

  @Override
  public ACMEConfigurationImpl addProperty(String name, String value) {
    return null;
  }

  @Override
  public MessageInterpolator getDefaultMessageInterpolator() {
    return null;
  }

  @Override
  public TraversableResolver getDefaultTraversableResolver() {
    return null;
  }

  @Override
  public ConstraintValidatorFactory getDefaultConstraintValidatorFactory() {
    return null;
  }

  @Override
  public ParameterNameProvider getDefaultParameterNameProvider() {
    return null;
  }

  @Override
  public ClockProvider getDefaultClockProvider() {
    return null;
  }

  @Override
  public BootstrapConfiguration getBootstrapConfiguration() {
    return null;
  }

  @Override
  public ValidatorFactory buildValidatorFactory() {
    return new ACMEValidatorFactory();
  }
}
