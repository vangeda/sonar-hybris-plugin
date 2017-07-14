package org.divy.sonar.check.java.hybris;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class HybrisControllerServiceUsageCheckTest {

  @Test
  public void checkNoIssue() {
      JavaCheckVerifier.verifyNoIssue("src/test/files/controller/HybrisCheckNoUsageIssue.java"
              , new HybrisControllerServiceUsageCheck());
  }

  @Test
  public void checkServiceUsage() {
    JavaCheckVerifier.verify("src/test/files/controller/ServiceUsageTestSampleController.java", new HybrisControllerServiceUsageCheck());
  }
}
