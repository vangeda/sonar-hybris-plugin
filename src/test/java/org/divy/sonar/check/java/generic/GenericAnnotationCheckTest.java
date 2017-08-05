package org.divy.sonar.check.java.generic;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;


public class GenericAnnotationCheckTest {
    @Test
    public void checkNoIssue() {
    	GenericAnnotationCheck check = new GenericAnnotationCheck();

        check.setRestrictedAnnotation("org.springframework.beans.factory.annotation.Autowired");;
        check.setMessage("The annotation 'Autowired' should not be used. Use XML bean wiring instead");;

        JavaCheckVerifier.verifyNoIssue("src/test/files/annotation/AnnotationCheckNoUsageIssue.java" , check);
    }

    @Test
    public void checkAutowiredUsage() {
    	GenericAnnotationCheck check = new GenericAnnotationCheck();

        check.setRestrictedAnnotation("org.springframework.beans.factory.annotation.Autowired");;
        check.setMessage("The annotation Autowired should not be used. Use XML bean wiring instead");;

        JavaCheckVerifier.verify("src/test/files/annotation/AutowiredUsageTestSampleBean.java", check);
    }
    
    @Test
    public void checkResourceUsage() {
    	GenericAnnotationCheck check = new GenericAnnotationCheck();

        check.setRestrictedAnnotation("javax.annotation.Resource");;
        check.setMessage("The annotation Resource should not be used. Use XML bean wiring instead");;

        JavaCheckVerifier.verify("src/test/files/annotation/ResourceUsageTestSampleBean.java", check);
    }
    
}