/*
 * SonarQube Java Custom Rules Example
 * Copyright (C) 2016-2016 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.divy.sonar.hybris.java.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class HybrisFacadeCheckTest {

  @Test
  public void checkDaoUsage() {

    JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisFacadeCheck());
  }

  @Test
  public void checkHtmlUsage() {

    JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisFacadeCheck());
  }

    @Test
    public void checkPublicServiceGetter() {
        JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisFacadeCheck());
    }

    @Test
    public void checkModelInstantiation() {
        JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisFacadeCheck());
    }

    @Test
    public void checkSessionUsage() {
        JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisFacadeCheck());
    }

    @Test
    public void checkFlexibleSearchUsage() {
        JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisFacadeCheck());
    }

    @Test
    public void checkDTOPopulation() {
        JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisFacadeCheck());
    }

    @Test
    public void checkModelPopulation() {
        JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisFacadeCheck());
    }
}
