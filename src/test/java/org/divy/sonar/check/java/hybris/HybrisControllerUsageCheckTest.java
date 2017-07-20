package org.divy.sonar.check.java.hybris;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class HybrisControllerUsageCheckTest {

  @Test
  public void checkNoIssue() {
      JavaCheckVerifier.verifyNoIssue("src/test/files/controller/HybrisCheckNoUsageIssue.java", new HybrisControllerUsageCheck());
  }

  @Test
  public void checkControllerDaoUsage() {
      JavaCheckVerifier.verify("src/test/files/controller/DaoUsageTestSampleController.java", new HybrisControllerUsageCheck());
  }

  @Test
  public void checkControllerDaoUpperCaseUsage() {
      JavaCheckVerifier.verify("src/test/files/controller/DaoUpperCaseUsageTestSampleController.java", new HybrisControllerUsageCheck());
  }

  @Test
  public void checkControllerModelUsage() {
      JavaCheckVerifier.verify("src/test/files/controller/ModelUsageTestSampleController.java", new HybrisControllerUsageCheck());
  }

  @Test
  public void checkControllerServiceUsage() {
    JavaCheckVerifier.verify("src/test/files/controller/ServiceUsageTestSampleController.java", new HybrisControllerUsageCheck());
  }

  @Test
  public void checkControllerServiceLowerCaseUsage() {
    JavaCheckVerifier.verify("src/test/files/controller/ServiceLowerCaseUsageTestSampleController.java", new HybrisControllerUsageCheck());
  }

  @Test
  public void checkRestControllerDaoUsage() {
      JavaCheckVerifier.verify("src/test/files/controller/DaoUsageTestSampleRestController.java", new HybrisControllerUsageCheck());
  }

  @Test
  public void checkRestControllerDaoUpperCaseUsage() {
      JavaCheckVerifier.verify("src/test/files/controller/DaoUpperCaseUsageTestSampleRestController.java", new HybrisControllerUsageCheck());
  }

  @Test
  public void checkRestControllerModelUsage() {
      JavaCheckVerifier.verify("src/test/files/controller/ModelUsageTestSampleRestController.java", new HybrisControllerUsageCheck());
  }

  @Test
  public void checkRestControllerServiceUsage() {
    JavaCheckVerifier.verify("src/test/files/controller/ServiceUsageTestSampleRestController.java", new HybrisControllerUsageCheck());
  }

  @Test
  public void checkRestControllerServiceLowerCaseUsage() {
    JavaCheckVerifier.verify("src/test/files/controller/ServiceLowerCaseUsageTestSampleRestController.java", new HybrisControllerUsageCheck());
  }
}
