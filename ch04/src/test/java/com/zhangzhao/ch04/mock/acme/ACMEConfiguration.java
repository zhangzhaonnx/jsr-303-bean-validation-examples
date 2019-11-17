package com.zhangzhao.ch04.mock.acme;

import javax.validation.Configuration;

public interface ACMEConfiguration extends Configuration<ACMEConfigurationImpl> {

  /**
   * Programmatically add constraints. Specific to the ACME provider.
   */
  ACMEConfiguration addConstraint(Class<?> entity,
      ACMEConstraintDescriptor constraintDescriptor);


  /**
   * Enables constraints implementation dynamic reloading when using ACME default to false
   */
  ACMEConfiguration enableDynamicReloading(boolean b);
}
