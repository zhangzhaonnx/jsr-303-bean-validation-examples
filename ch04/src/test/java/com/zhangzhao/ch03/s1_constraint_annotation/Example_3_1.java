package com.zhangzhao.ch03.s1_constraint_annotation;

import javax.validation.Payload;
import javax.validation.constraints.NotNull;

/**
 * Use of payload to associate severity to a constraint
 */
public class Example_3_1 {

  private static class Severity {

    public static class Info implements Payload {

    }

    public static class Error implements Payload {

    }
  }

  private static class Address {

    @NotNull(message = "would be nice if we had one", payload = Severity.Info.class)
    public String getZipCode() {
      return null;
    }

    @NotNull(message = "the city is mandatory", payload = Severity.Error.class)
    String getCity() {
      return null;
    }
  }
}
