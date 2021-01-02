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
package org.assertj.core.internal.doublearrays;

import org.assertj.core.api.AssertionInfo;
import org.assertj.core.internal.DoubleArrays;
import org.assertj.core.internal.DoubleArraysBaseTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.error.ShouldHaveSize.shouldHaveSize;
import static org.assertj.core.test.TestData.someInfo;
import static org.assertj.core.util.FailureMessages.actualIsNull;


/**
 * Tests for <code>{@link DoubleArrays#assertHasSize(AssertionInfo, double[], int)}</code>.
 * 
 * @author Alex Ruiz
 * @author Joel Costigliola
 */
class DoubleArrays_assertHasSize_Test extends DoubleArraysBaseTest {

  @Test
  void should_fail_if_actual_is_null() {
    assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> arrays.assertHasSize(someInfo(), null, 3))
                                                   .withMessage(actualIsNull());
  }

  @Test
  void should_fail_if_size_of_actual_is_not_equal_to_expected_size() {
    assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> arrays.assertHasSize(someInfo(), actual, 2))
                                                   .withMessage(shouldHaveSize(actual, actual.length, 2).create());
  }

  @Test
  void should_pass_if_size_of_actual_is_equal_to_expected_size() {
    arrays.assertHasSize(someInfo(), actual, 3);
  }
}
