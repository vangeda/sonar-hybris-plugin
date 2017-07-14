package org.divy.sonar.check.java.generic;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;


public class GenericLayerUsageCheckTest {

    @Test
    public void detected() {

        GenericLayerUsageCheck check = new GenericLayerUsageCheck();

        check.restrictedTypeName = "Dao";
        check.restrictedTypeNameMatch = "(.)*(Dao|dao)$";
        check.targetTypeName = "Facade";
        check.targetTypeNameMatch = "(.)*(Facade)$";

        JavaCheckVerifier.verify("src/test/files/facade/HybrisDaoUsageTestSampleFacade.java", check);
    }
}