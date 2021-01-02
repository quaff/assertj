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
package org.assertj.core.api.classes;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.ClassAssert;
import org.assertj.core.api.ClassAssertBaseTest;
import org.junit.jupiter.api.DisplayName;

/**
 * Tests for <code>{@link ClassAssert#hasPackage(Package)}</code>.
 *
 * @author Matteo Mirk
 */
@DisplayName("ClassAssert hasPackage(Package)")
class ClassAssert_hasPackage_with_Package_Test extends ClassAssertBaseTest {

  private static final Package PACKAGE = mock(Package.class);

  @Override
  protected ClassAssert invoke_api_method() {
    return assertions.hasPackage(PACKAGE);
  }

  @Override
  protected void verify_internal_effects() {
    verify(classes).assertHasPackage(getInfo(assertions), getActual(assertions), PACKAGE);
  }

}
