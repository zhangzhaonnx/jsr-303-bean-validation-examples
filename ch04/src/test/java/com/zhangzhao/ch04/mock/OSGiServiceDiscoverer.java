package com.zhangzhao.ch04.mock;

import static java.util.Collections.singletonList;

import com.zhangzhao.ch04.mock.acme.ACMEProvider;
import java.util.List;
import javax.validation.ValidationProviderResolver;
import javax.validation.spi.ValidationProvider;

public class OSGiServiceDiscoverer implements ValidationProviderResolver {

    @Override
    public List<ValidationProvider<?>> getValidationProviders() {
      return singletonList(new ACMEProvider());
    }
  }
