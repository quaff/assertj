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
package org.assertj.core.internal.doubles;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.error.ShouldBeLess.shouldBeLess;
import static org.assertj.core.test.TestData.someInfo;
import static org.assertj.core.util.AssertionsUtil.expectAssertionError;

import org.assertj.core.api.AssertionInfo;
import org.assertj.core.internal.Doubles;
import org.assertj.core.internal.DoublesBaseTest;
import org.junit.jupiter.api.Test;

/**
 * Tests for <code>{@link Doubles#assertIsNegative(AssertionInfo, Double)}</code>.
 *
 * @author Alex Ruiz
 * @author Joel Costigliola
 */
class Doubles_assertIsNegative_Test extends DoublesBaseTest {

  @Test
  void should_succeed_since_actual_is_negative() {
    doubles.assertIsNegative(someInfo(), -6.0);
  }

  @Test
  void should_fail_since_actual_is_not_negative() {
    // WHEN
    AssertionError assertionError = expectAssertionError(() -> doubles.assertIsNegative(someInfo(), 6.0));
    // THEN
    then(assertionError).hasMessage(shouldBeLess(6.0, 0.0).create());
  }

  @Test
  void should_fail_since_actual_is_zero() {
    // WHEN
    AssertionError assertionError = expectAssertionError(() -> doubles.assertIsNegative(someInfo(), 0.0));
    // THEN
    then(assertionError).hasMessage(shouldBeLess(0.0, 0.0).create());
  }

  @Test
  void should_fail_since_actual_can_not_be_negative_according_to_custom_comparison_strategy() {
    // WHEN
    AssertionError error = expectAssertionError(() -> doublesWithAbsValueComparisonStrategy.assertIsNegative(someInfo(), 6.0));
    // THEN
    then(error).hasMessage(shouldBeLess(6.0, 0.0, absValueComparisonStrategy).create());
  }

  @Test
  void should_fail_since_actual_is_not_negative_according_to_custom_comparison_strategy() {
    // WHEN
    AssertionError error = expectAssertionError(() -> doublesWithAbsValueComparisonStrategy.assertIsNegative(someInfo(), -1.0));
    // THEN
    then(error).hasMessage(shouldBeLess(-1.0, 0.0, absValueComparisonStrategy).create());
  }

}
