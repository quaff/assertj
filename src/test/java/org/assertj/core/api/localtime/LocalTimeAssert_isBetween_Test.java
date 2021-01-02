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
package org.assertj.core.api.localtime;

import static org.mockito.Mockito.verify;

import java.time.LocalTime;

import org.assertj.core.api.LocalTimeAssert;

class LocalTimeAssert_isBetween_Test extends org.assertj.core.api.LocalTimeAssertBaseTest {

  private LocalTime before = now.minusSeconds(1);
  private LocalTime after = now.plusSeconds(1);

  @Override
  protected LocalTimeAssert invoke_api_method() {
    return assertions.isBetween(before, after);
  }

  @Override
  protected void verify_internal_effects() {
    verify(comparables).assertIsBetween(getInfo(assertions), getActual(assertions), before, after, true, true);
  }

}
