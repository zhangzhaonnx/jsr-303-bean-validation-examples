package com.zhangzhao.c3_constraint_definition.s4_constraint_validation_implementation;

import java.util.Map;
import javax.validation.ConstraintValidatorContext;

/**
 * Using the fluent API to build custom constraint violations
 */
public class Example_3_18 {

  /**
   * From a property-level constraint on User.addresses Build a constraint violation on the default
   * path - i.e. the "addresses" property
   */
  public void use1(ConstraintValidatorContext context) {
    context.buildConstraintViolationWithTemplate("this detail is wrong")
        .addConstraintViolation();
  }

  /**
   * From a class level constraint on Address Build a constraint violation on the default path +
   * "street" i.e. the street property of Address
   */
  public void use2(ConstraintValidatorContext context) {
    context.buildConstraintViolationWithTemplate("this detail is wrong")
        .addPropertyNode("street")
        .addConstraintViolation();
  }

  /**
   * From a property-level constraint on  User.addresses Build a constraint violation on the default
   * path + the bean stored under the "home" key in the map
   */
  public void use3(ConstraintValidatorContext context) {
    context.buildConstraintViolationWithTemplate("Incorrect home address")
        .addBeanNode()
        .inContainer(Map.class, 1)
        .inIterable().atKey("home")
        .addConstraintViolation();
  }

  /**
   * From a class level constraint on User Build a constraint violation on the default path +
   * addresses["home"].country.name i.e. property "country.name" on the object stored under "home"
   * in the map
   */
  public void use4(ConstraintValidatorContext context) {
    context.buildConstraintViolationWithTemplate("this detail is wrong")
        .addPropertyNode("addresses")
        .addPropertyNode("country")
        .inContainer(Map.class, 1)
        .inIterable().atKey("home")
        .addPropertyNode("name")
        .addConstraintViolation();
  }

  /**
   * From a class level constraint on User Build a constraint violation on the default path +
   * addresses["home"].<map key> i.e. a container element constraint violation for the map key
   */
  public void use5(ConstraintValidatorContext context) {
    context.buildConstraintViolationWithTemplate("the map key is invalid")
        .addPropertyNode("addresses")
        .addContainerElementNode("<map key>", Map.class, 0)
        .inIterable().atKey("home")
        .addConstraintViolation();
  }

  /**
   * Cross-parameter constraint on method createUser(String password, String passwordRepeat) Build a
   * constraint violation on the default path + "passwordRepeat"
   */
  public void use6(ConstraintValidatorContext context) {
    context.buildConstraintViolationWithTemplate("Passwords do not match")
        .addParameterNode(1)
        .addConstraintViolation();
  }

  /**
   * Cross-parameter constraint on a method mergeAddresses(Map<String,Address> addresses,
   * Map<String,Address> otherAddresses) Build a constraint violation on the default path +
   * "otherAddresses["home"] i.e. the Address bean hosted in the "home" key of the "otherAddresses"
   * map parameter
   */
  public void use7(ConstraintValidatorContext context) {
    context.buildConstraintViolationWithTemplate(
        "Map entry home present in both and does not match")
        .addParameterNode(1)
        .addBeanNode()
        .inContainer(Map.class, 1)
        .inIterable().atKey("home")
        .addConstraintViolation();
  }

  /**
   * Cross-parameter constraint on a method mergeAddresses(Map<String,Address> addresses,
   * Map<String,Address> otherAddresses) Build a constraint violation on the default path +
   * "otherAddresses["home"].city i.e. on the "city" property of the Address bean hosted in the
   * "home" key of the "otherAddresses" map
   */
  public void use8(ConstraintValidatorContext context) {
    context.buildConstraintViolationWithTemplate(
        "Map entry home present in both but city does not match")
        .addParameterNode(1)
        .addPropertyNode("city")
        .inContainer(Map.class, 1)
        .inIterable().atKey("home")
        .addConstraintViolation();
  }

  /**
   * assuming the following domain model
   */
  private static class User {

    public Map<String, Address> getAddresses() {
      return null;
    }
  }

  private static class Address {

    public String getStreet() {
      return null;
    }

    public Country getCountry() {
      return null;
    }
  }

  private static class Country {

    public String getName() {
      return null;
    }
  }

}
