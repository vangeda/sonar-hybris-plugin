
package org.divy.sonar.hybris.java.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class HybrisControllerHtmlUsageCheckTest {

    @Test
    public void checkNoIssue() {
        JavaCheckVerifier.verifyNoIssue("src/test/files/controller/HybrisCheckNoUsageIssue.java"
                , new HybrisControllerModelUsageCheck());
    }

    @Test
    public void checkHtmlUsage() {
        JavaCheckVerifier.verify("src/test/files/controller/HtmlUsageTestSampleController.java", new HybrisControllerHtmlUsageCheck());
    }
}
