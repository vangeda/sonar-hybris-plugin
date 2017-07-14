package org.divy.sonar.hybris.java.checks;

import org.sonar.java.checks.verifier.JavaCheckVerifier; // Compliant
import de.hybris.platform.servicelayer.user.UserService; // Noncompliant {{Refactor Controller to use facade instead of service directly}}

public class HybrisControllerServiceUsage {

    UserService classMemberModel; // Noncompliant {{Refactor Controller to use facade instead of service directly}}

    void nonComplientMethod() {
        UserService userService; // Noncompliant {{Refactor Controller to use facade instead of service directly}}
    }

    void complientMethod() {
    }
}
