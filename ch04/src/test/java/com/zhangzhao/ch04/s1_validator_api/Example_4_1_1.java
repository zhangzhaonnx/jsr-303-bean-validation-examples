package com.zhangzhao.ch04.s1_validator_api;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

/**
 * Validation methods
 */
public class Example_4_1_1 {

  @Test
  public void name() {
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    Address address = new Address();
    address.setAddressline1(null);
    address.setAddressline2(null);
    address.setCity("Llanfairpwllgwyngyllgogerychwyrndrobwyll-llantysiliogogogoch");

    assertThat(validator.validate(address).size(), is(2));
    assertThat(validator.validateProperty(address, "city").size(), is(1));
    assertThat(validator.validateValue(Address.class, "city", "Paris").size(), is(0));
  }

  @Setter
  @Getter
  private static class Address {

    @NotNull
    @Size(max = 30)
    private String addressline1;

    @Size(max = 30)
    private String addressline2;

    @Size(max = 30)
    @NotNull
    private String city;
  }
}
