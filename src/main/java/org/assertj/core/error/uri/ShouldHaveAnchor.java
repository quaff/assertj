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
package org.assertj.core.error.uri;

import java.net.URL;

import org.assertj.core.error.BasicErrorMessageFactory;
import org.assertj.core.error.ErrorMessageFactory;

public class ShouldHaveAnchor extends BasicErrorMessageFactory {

  private static final String SHOULD_HAVE_ANCHOR = "%nExpecting anchor of%n  <%s>%nto be:%n  <%s>%nbut was:%n  <%s>";
  private static final String SHOULD_NOT_HAVE_ANCHOR = "%nExpecting:%n  <%s>%nnot to have an anchor but had:%n  <%s>";

  public static ErrorMessageFactory shouldHaveAnchor(URL actual, String expectedAnchor) {
    return expectedAnchor == null ? new ShouldHaveAnchor(actual) : new ShouldHaveAnchor(actual, expectedAnchor);
  }

  private ShouldHaveAnchor(URL actual, String expectedAnchor) {
    super(SHOULD_HAVE_ANCHOR, actual, expectedAnchor, actual.getRef());
  }

  private ShouldHaveAnchor(URL actual) {
    super(SHOULD_NOT_HAVE_ANCHOR, actual, actual.getRef());
  }

}
