package com.zhangzhao.ch04.s4_bootstrapping.core;

import static java.util.Collections.singletonList;

import com.zhangzhao.ch04.s4_bootstrapping.core.acme.ACMEProvider;
import java.util.List;
import javax.validation.ValidationProviderResolver;
import javax.validation.spi.ValidationProvider;

public class OSGiServiceDiscoverer implements ValidationProviderResolver {

    @Override
    public List<ValidationProvider<?>> getValidationProviders() {
      return singletonList(new ACMEProvider());
    }
  }
