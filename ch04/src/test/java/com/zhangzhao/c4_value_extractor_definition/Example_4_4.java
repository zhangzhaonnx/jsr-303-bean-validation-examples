package com.zhangzhao.c4_value_extractor_definition;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import javax.validation.valueextraction.ExtractedValue;
import javax.validation.valueextraction.UnwrapByDefault;
import javax.validation.valueextraction.ValueExtractor;


public class Example_4_4 {

  /**
   * A value extractor for the elements of java.util.List
   */
  public class ListValueExtractor implements ValueExtractor<List<@ExtractedValue ?>> {

    @Override
    public void extractValues(List<?> originalValue, ValueReceiver receiver) {
      for (int i = 0; i < originalValue.size(); i++) {
        receiver.indexedValue("<list element>", i, originalValue.get(i));
      }
    }
  }

  /**
   * A value extractor for java.util.Optional
   */
  public class OptionalValueExtractor implements ValueExtractor<Optional<@ExtractedValue ?>> {

    @Override
    public void extractValues(Optional<?> originalValue, ValueReceiver receiver) {
      receiver.value(null, originalValue.orElse(null));
    }
  }

  /**
   * A value extractor for java.util.OptionalInt
   */
  @UnwrapByDefault
  public class OptionalIntValueExtractor implements
      ValueExtractor<@ExtractedValue(type = Integer.class) OptionalInt> {

    @Override
    public void extractValues(OptionalInt originalValue, ValueReceiver receiver) {
      receiver.value(null, originalValue.isPresent() ? originalValue.getAsInt() : null);
    }
  }

  /**
   * Illegal, as it specifies @ExtractedValue more than once
   */
  public class IllegalMapExtractor implements ValueExtractor<Map<@ExtractedValue ?,
      @ExtractedValue ?>> {

    @Override
    public void extractValues(Map<?, ?> originalValue, ValueReceiver receiver) {

    }
  }

  /**
   * Illegal, as it specifies @ExtractedValue on a non-wildcard type argument
   */
  public class StringListValueExtractor implements ValueExtractor<List<@ExtractedValue String>> {

    @Override
    public void extractValues(List<@ExtractedValue String> originalValue, ValueReceiver receiver) {

    }
  }
}
