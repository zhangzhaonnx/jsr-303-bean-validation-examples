package com.zhangzhao.c3_constraint_definition.s2_applying_multiple_constraints;

import com.zhangzhao.c3_constraint_definition.s2_applying_multiple_constraints.Example_3_7.ZipCode;
import javax.validation.groups.Default;

/**
 * Multi-valued constraint declaration using explicit @List annotation (discouraged)
 */
public class Example_3_9 {

  public class Address {

    @ZipCode.List({
        @ZipCode(countryCode = "fr", groups = Default.class,
            message = "zip code is not valid"),
        @ZipCode(countryCode = "fr", groups = SuperUser.class,
            message = "zip code invalid. Requires overriding before saving.")
    })
    private String zipCode;
  }

  private interface SuperUser {

  }
}
