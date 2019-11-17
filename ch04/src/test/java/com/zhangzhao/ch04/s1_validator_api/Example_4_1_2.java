package com.zhangzhao.ch04.s1_validator_api;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

/**
 * groups
 */
public class Example_4_1_2 {

  @Test
  public void name() {
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    Address address = new Address();

    assertThat(validator.validate(address).size(), is(2));
    assertThat(validator.validate(address, Minimal.class).size(), is(2));
    assertThat(validator.validate(address, Minimal.class, Default.class).size(), is(3));
  }

  @Setter
  @Getter
  private static class Address {

    @NotEmpty(groups = Minimal.class)
    @Size(max = 50)
    private String street1;

    @NotEmpty
    private String city;

    @NotEmpty(groups = {Minimal.class, Default.class})
    private String zipCode;
  }

  private interface Minimal {

  }
}
