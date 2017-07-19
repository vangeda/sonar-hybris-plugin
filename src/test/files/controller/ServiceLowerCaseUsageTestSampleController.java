package org.divy.sonar.hybris.java.checks;

import org.sonar.java.checks.verifier.JavaCheckVerifier; // Compliant
import de.hybris.platform.servicelayer.user.userservice; // Noncompliant {{Refactor Controller to use facade instead of service directly}}

public class ServiceLowerCaseUsageTestSampleController {

	userservice classMemberService; // Noncompliant {{Refactor Controller to use facade instead of service directly}}

    void nonCompliantMethod() {
    	userservice userService; // Noncompliant {{Refactor Controller to use facade instead of service directly}}
    }

    void compliantMethod() {
    	JavaCheckVerifier localJavaCheckVerifier; // Compliant
    }
}
