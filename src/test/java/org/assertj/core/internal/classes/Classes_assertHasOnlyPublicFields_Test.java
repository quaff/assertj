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
package org.assertj.core.internal.classes;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.error.ShouldHaveNoFields.shouldHaveNoPublicFields;
import static org.assertj.core.error.ShouldOnlyHaveFields.shouldOnlyHaveFields;
import static org.assertj.core.test.TestData.someInfo;
import static org.assertj.core.util.FailureMessages.actualIsNull;
import static org.assertj.core.util.Sets.newLinkedHashSet;

import java.util.LinkedHashSet;

import org.assertj.core.internal.ClassesBaseTest;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for
 * <code
 * >{@link org.assertj.core.internal.Classes#assertHasOnlyPublicFields(org.assertj.core.api.AssertionInfo, Class, String...)}</code>
 * .
 *
 * @author Filip Hrisafov
 */
class Classes_assertHasOnlyPublicFields_Test extends ClassesBaseTest {

  private static final LinkedHashSet<String> EMPTY_STRING_SET = Sets.newLinkedHashSet();

  @BeforeEach
  void setupActual() {
    actual = AnnotatedClass.class;
  }

  @Test
  void should_pass_if_class_has_all_the_expected_public_fields() {
    classes.assertHasOnlyPublicFields(someInfo(), actual, "publicField", "publicField2");
  }

  @Test
  void should_pass_if_class_has_all_the_expected_public_fields_whatever_the_order_is() {
    classes.assertHasOnlyPublicFields(someInfo(), actual, "publicField2", "publicField");
  }

  @Test
  void should_pass_if_class_has_no_public_fields_and_none_are_expected() {
    classes.assertHasOnlyPublicFields(someInfo(), NoField.class);
  }

  @Test
  void should_fail_if_actual_is_null() {
    actual = null;
    assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> classes.assertHasOnlyPublicFields(someInfo(), actual))
                                                   .withMessage(actualIsNull());
  }

  @Test
  void should_fail_if_some_public_fields_are_not_present_in_the_expected_fields() {
    assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> classes.assertHasOnlyPublicFields(someInfo(),
                                                                                                       actual,
                                                                                                       "publicField"))
                                                   .withMessage(shouldOnlyHaveFields(actual,
                                                                                     newLinkedHashSet("publicField"),
                                                                                     EMPTY_STRING_SET,
                                                                                     newLinkedHashSet("publicField2")).create());
  }

  @Test
  void should_fail_if_some_public_fields_are_missing() {
    String[] expected = new String[] { "missingField", "publicField", "publicField2" };
    assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> classes.assertHasOnlyPublicFields(someInfo(),
                                                                                                       actual,
                                                                                                       expected))
                                                   .withMessage(shouldOnlyHaveFields(actual,
                                                                                     newLinkedHashSet(expected),
                                                                                     newLinkedHashSet("missingField"),
                                                                                     EMPTY_STRING_SET).create());
  }

  @Test
  void should_fail_if_fields_are_protected_or_private() {
    String[] expected = new String[] { "publicField", "publicField2", "protectedField", "privateField" };
    assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> classes.assertHasOnlyPublicFields(someInfo(),
                                                                                                       actual,
                                                                                                       expected))
                                                   .withMessage(shouldOnlyHaveFields(actual,
                                                                                     newLinkedHashSet(expected),
                                                                                     newLinkedHashSet("protectedField",
                                                                                                      "privateField"),
                                                                                     EMPTY_STRING_SET).create());
  }

  @Test
  void should_fail_if_fields_are_not_found_and_not_expected() {
    String[] expected = new String[] { "publicField", "protectedField", "privateField" };
    assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> classes.assertHasOnlyPublicFields(someInfo(),
                                                                                                       actual,
                                                                                                       expected))
                                                   .withMessage(shouldOnlyHaveFields(actual,
                                                                                     newLinkedHashSet(expected),
                                                                                     newLinkedHashSet("protectedField",
                                                                                                      "privateField"),
                                                                                     newLinkedHashSet("publicField2")).create());
  }

  @Test
  void should_fail_if_no_public_fields_are_expected_and_class_has_some() {
    assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> classes.assertHasOnlyPublicFields(someInfo(), actual))
                                                   .withMessage(shouldHaveNoPublicFields(actual,
                                                                                         newLinkedHashSet("publicField",
                                                                                                          "publicField2")).create());
  }

}
