package com.zhangzhao.ch04.s3_message_interpolation.core;

import java.util.Locale;
import javax.validation.MessageInterpolator;

/**
 * delegates to a MessageInterpolator implementation but enforce a given Locale
 */
public class LocaleSpecificMessageInterpolator implements MessageInterpolator {

  private final MessageInterpolator defaultInterpolator;
  private final Locale defaultLocale;

  public LocaleSpecificMessageInterpolator(MessageInterpolator defaultInterpolator,
      Locale defaultLocale) {
    this.defaultInterpolator = defaultInterpolator;
    this.defaultLocale = defaultLocale;
  }


  /**
   * enforece the locale passed to the interpolator
   */
  @Override
  public String interpolate(String messageTemplate, Context context) {
    return defaultInterpolator.interpolate(messageTemplate, context, defaultLocale);
  }

  /**
   * no real use, implemented for completeness
   */
  @Override
  public String interpolate(String messageTemplate, Context context, Locale locale) {
    return defaultInterpolator.interpolate(messageTemplate, context, locale);
  }
}
