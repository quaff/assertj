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
package org.assertj.core.api.path;

import static org.mockito.Mockito.verify;

import java.nio.file.Path;
import java.util.function.Predicate;

import org.assertj.core.api.PathAssert;
import org.assertj.core.api.PathAssertBaseTest;

/**
 * Tests for <code>{@link PathAssert#isDirectoryRecursivelyContaining(Predicate)}</code>
 *
 * @author David Haccoun
 */
class PathAssert_isDirectoryRecursivelyContaining_Predicate_Test extends PathAssertBaseTest {

  private final Predicate<Path> anyFilter = path -> true;

  @Override
  protected PathAssert invoke_api_method() {
    return assertions.isDirectoryRecursivelyContaining(anyFilter);
  }

  @Override
  protected void verify_internal_effects() {
    verify(paths).assertIsDirectoryRecursivelyContaining(getInfo(assertions), getActual(assertions), anyFilter);
  }
}
