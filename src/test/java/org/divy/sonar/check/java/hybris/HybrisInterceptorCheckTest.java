package org.divy.sonar.check.java.hybris;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class HybrisInterceptorCheckTest {

  @Test
  public void checkSessionUsage() {
    JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisInterceptorCheck());
  }

  @Test
  public void checkServiceUsage() {
    JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisInterceptorCheck());
  }
}
