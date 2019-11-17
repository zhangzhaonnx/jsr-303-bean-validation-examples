package com.zhangzhao.ch04.mock;

import java.lang.annotation.ElementType;
import javax.validation.Path;
import javax.validation.Path.Node;
import javax.validation.TraversableResolver;

public class JPAAwareTraversableResolver implements TraversableResolver {

  @Override
  public boolean isReachable(Object traversableObject, Node traversableProperty,
      Class<?> rootBeanType, Path pathToTraversableObject, ElementType elementType) {
    return false;
  }

  @Override
  public boolean isCascadable(Object traversableObject, Node traversableProperty,
      Class<?> rootBeanType, Path pathToTraversableObject, ElementType elementType) {
    return false;
  }
}
