/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2021 the original author or authors.
 */
package org.assertj.core.internal;

import static java.lang.String.format;
import static java.util.Collections.EMPTY_MAP;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RecursiveFieldByFieldComparator_toString_Test {

  @Test
  void should_return_description_of_RecursiveFieldByFieldComparator() {
    // GIVEN
    RecursiveFieldByFieldComparator actual = new RecursiveFieldByFieldComparator(EMPTY_MAP, new TypeComparators());
    // THEN
    assertThat(actual).hasToString(format("recursive field/property by field/property comparator on all fields/properties%n"
                                          + "Comparators used:%n"
                                          + "- for elements fields (by type): {Double -> DoubleComparator[precision=1.0E-15], Float -> FloatComparator[precision=1.0E-6]}"));
  }
}
