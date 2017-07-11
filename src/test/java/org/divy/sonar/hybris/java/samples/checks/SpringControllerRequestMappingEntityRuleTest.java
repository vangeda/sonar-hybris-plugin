
package org.divy.sonar.hybris.java.samples.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class SpringControllerRequestMappingEntityRuleTest {

  @Test
  public void check() {
    JavaCheckVerifier.verify("src/test/files/SpringControllerRequestMappingEntityRule.java", new SpringControllerRequestMappingEntityRule());
  }

}
