package com.zhangzhao.ch04.s1_validator_api;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.validation.GroupSequence;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.junit.Test;

/**
 * groups
 */
public class Example_4_1_3 {

  @Test
  public void name() {
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    Address address = new Address();

    assertThat(validator.validate(address, Minimal.class, Total.class).size(), is(3));
    assertThat(validator.validate(address, Total.class, SecondStep.class).size(), is(2));
  }

  private static class Address {

    @NotEmpty(groups = Minimal.class)
    @Size(max = 50, groups = FirstStep.class)
    private String street1;

    @NotEmpty(groups = SecondStep.class)
    private String city;
    @NotEmpty(groups = {Minimal.class, SecondStep.class})
    private String zipCode;
  }

  private interface Minimal {

  }

  private interface FirstStep {

  }

  private interface SecondStep {

  }

  @GroupSequence({FirstStep.class, SecondStep.class})
  private interface Total {

  }
}
