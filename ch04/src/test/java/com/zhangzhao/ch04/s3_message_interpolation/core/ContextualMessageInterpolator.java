package com.zhangzhao.ch04.s3_message_interpolation.core;

import java.util.Locale;
import javax.validation.MessageInterpolator;

public class ContextualMessageInterpolator implements MessageInterpolator {

  private final MessageInterpolator delegate;

  public ContextualMessageInterpolator(MessageInterpolator delegate) {
    this.delegate = delegate;
  }

  public String interpolate(String message, Context context) {
    Locale locale = Container.getManager().getUserLocale();
    return this.delegate.interpolate(
        message, context, locale);
  }

  public String interpolate(String message, Context context, Locale locale) {
    return this.delegate.interpolate(message, context, locale);
  }

  public static class Container {

    private Container() {
    }

    public static ContainerManager getManager() {
      return new ContainerManager();
    }
  }

  public static class ContainerManager {

    public Locale getUserLocale() {
      return Locale.CHINA;
    }
  }
}
