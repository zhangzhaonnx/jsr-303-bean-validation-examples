package com.zhangzhao.ch04.mock;

import java.util.Locale;
import javax.validation.MessageInterpolator;

public class LocaleSpecificMessageInterpolator implements MessageInterpolator {

  public LocaleSpecificMessageInterpolator(
      Locale locale, MessageInterpolator messageInterpolator) {
  }

  @Override
  public String interpolate(String messageTemplate, Context context) {
    return null;
  }

  @Override
  public String interpolate(String messageTemplate, Context context, Locale locale) {
    return null;
  }
}
