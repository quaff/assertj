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
package org.assertj.core.navigation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.assertj.core.api.ClassBasedNavigableIterableAssert;
import org.assertj.core.test.IllegalVehicleAssert;
import org.assertj.core.test.Vehicle;
import org.assertj.core.test.VehicleAssert;
import org.assertj.core.test.VehicleFactory;
import org.junit.jupiter.api.Test;

class ClassBasedNavigableIterable_Test extends BaseNavigableIterableAssert_Test {

  @Override
  protected ClassBasedNavigableIterableAssert<?, Iterable<Vehicle>, Vehicle, VehicleAssert> buildNavigableAssert() {
    return assertThat(expectedVehicles, VehicleAssert.class);
  }

  @Test
  void do_not_swallow_reflection_problem() {
    assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> assertThat(expectedVehicles,
                                                                                  IllegalVehicleAssert.class)
                                                                                                             .toAssert(new VehicleFactory.Car("car"),
                                                                                                                       "unused"))
                                                     .withMessageContaining("not access a member of class org.assertj.core.test.IllegalVehicleAssert");
  }

}
