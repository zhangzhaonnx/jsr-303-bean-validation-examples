package com.zhangzhao.ch04.s4_bootstrapping.core.acme;

import javax.validation.Configuration;
import javax.validation.ValidatorFactory;
import javax.validation.spi.BootstrapState;
import javax.validation.spi.ConfigurationState;
import javax.validation.spi.ValidationProvider;

/**
 * ACME validation provider Note how ACMEConfiguration and ACMEProvider are linked together via the
 * generic parameter.
 */
public class ACMEProvider implements ValidationProvider<ACMEConfigurationImpl> {

  public ACMEProvider() {
  }

  @Override
  public ACMEConfigurationImpl createSpecializedConfiguration(BootstrapState state) {
    return new ACMEConfigurationImpl(state);
  }

  @Override
  public Configuration<?> createGenericConfiguration(BootstrapState state) {
    return new ACMEConfigurationImpl(state);
  }

  @Override
  public ValidatorFactory buildValidatorFactory(ConfigurationState configurationState) {
    return null;
  }
}
