package org.divy.sonar.hybris.java.checks;

import org.sonar.java.checks.verifier.JavaCheckVerifier;
import de.hybris.platform.servicelayer.user.UserService;

public class HybrisControllerServiceUsage {

    void nonComplientMethod() {
        UserService userService;
    }

    void complientMethod() {
    }
}
