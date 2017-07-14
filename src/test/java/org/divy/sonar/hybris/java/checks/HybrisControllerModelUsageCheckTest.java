package org.divy.sonar.hybris.java.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class HybrisControllerModelUsageCheckTest {

  @Test
  public void checkModelUsage() {
      JavaCheckVerifier.verify("src/test/files/controller/ModelUsageTestSampleController.java"
            , new HybrisControllerModelUsageCheck());
  }

  @Test
  public void checkNoIssue() {
      JavaCheckVerifier.verifyNoIssue("src/test/files/controller/HybrisCheckNoUsageIssue.java"
            , new HybrisControllerModelUsageCheck());
  }
}
