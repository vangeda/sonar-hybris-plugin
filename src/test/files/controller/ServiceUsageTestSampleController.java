package org.divy.sonar.hybris.java.checks;

import org.sonar.java.checks.verifier.JavaCheckVerifier; // Compliant
import de.hybris.platform.servicelayer.user.UserService; // Noncompliant {{Refactor Controller to use facade instead of service directly}}

public class ServiceUsageTestSampleController {

    UserService classMemberModel; // Noncompliant {{Refactor Controller to use facade instead of service directly}}

    void nonCompliantMethod() {
        UserService userService; // Noncompliant {{Refactor Controller to use facade instead of service directly}}
    }

    void compliantMethod() {
    }
}
