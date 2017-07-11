
package org.divy.sonar.hybris.java.samples.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class AvoidBrandInMethodNamesCheckTest {

  @Test
  public void detected() {
    // Verifies that the check will raise the adequate issues with the expected message.
    // In the test file, lines which should raise an issue have been commented out
    // by using the following syntax: "// Noncompliant {{EXPECTED_MESSAGE}}"
    JavaCheckVerifier.verify("src/test/files/AvoidBrandInMethodNamesCheck.java", new AvoidBrandInMethodNamesRule());
  }
}
