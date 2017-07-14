package org.divy.sonar.check.java.hybris;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class HybrisControllerDaoUsageCheckTest {

  @Test
  public void checkNoIssue() {
      JavaCheckVerifier.verifyNoIssue("src/test/files/controller/HybrisCheckNoUsageIssue.java"
              , new HybrisControllerDaoUsageCheck());
  }

  @Test
  public void checkDaoUsage() {
      JavaCheckVerifier.verify("src/test/files/controller/DaoUsageTestSampleController.java", new HybrisControllerDaoUsageCheck());
  }
}
