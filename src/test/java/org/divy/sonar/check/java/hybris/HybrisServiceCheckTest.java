package org.divy.sonar.check.java.hybris;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class HybrisServiceCheckTest {

  @Test
  public void checkHtmlUsage() {
    JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisServiceCheck());
  }

  @Test
  public void checkPublicDaoGetter() {
    JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisServiceCheck());
  }

  @Test
  public void checkModelInstantiation() {
    JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisServiceCheck());
  }

  @Test
  public void checkSessionUsage() {
    JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisServiceCheck());
  }

  @Test
  public void checkFlexibleSearchUsage() {
    JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisServiceCheck());
  }
}
