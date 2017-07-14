package org.divy.sonar.hybris.java.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class HybrisControllerDaoUsageCheckTest {

  @Test
  public void checkNoIssue() {
      JavaCheckVerifier.verifyNoIssue("src/test/files/controller/HybrisCheckNoUsageIssue.java"
            , new HybrisControllerModelUsageCheck());
  }

  @Test
  public void checkDaoUsage() {
      JavaCheckVerifier.verify("src/test/files/controller/DaoUsageTestSampleController.java", new HybrisControllerDaoUsageCheck());
  }
}
