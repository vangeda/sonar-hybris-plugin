package org.divy.sonar.hybris.java.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class HybrisLoggingCheckTest {

  @Test
  public void check() {
    JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisLoggingCheck());
  }

  @Test
  public void checkSystemOutPrintln() {
    JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisLoggingCheck());
  }

  @Test
  public void checkLoggingLibrary() {
    JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisLoggingCheck());
  }

  @Test
  public void checkMissingLoggerInstance() {
    JavaCheckVerifier.verify("src/test/files/MyCustomRule.java", new HybrisLoggingCheck());
  }
}
