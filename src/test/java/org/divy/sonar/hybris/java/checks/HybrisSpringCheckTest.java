package org.divy.sonar.hybris.java.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class HybrisSpringCheckTest {

  @Test
  public void checkAutowiredUsage() {
    JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisSpringCheck());
  }
}
