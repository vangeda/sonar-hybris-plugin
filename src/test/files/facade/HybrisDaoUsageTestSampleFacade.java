//NO-SONAR
package org.divy.sonar.hybris.java.checks;

import org.sonar.java.checks.verifier.JavaCheckVerifier; // Compliant
import de.hybris.platform.dao.user.UserDao; // Noncompliant {{Refactor Facade to not use Dao directly}}

public class HybrisDaoUsageTestSampleFacade {

    UserDao classMemberModel; // Noncompliant {{Refactor Facade to not use Dao directly}}

    void nonCompliantMethod() {
        UserDao userService; // Noncompliant {{Refactor Facade to not use Dao directly}}
    }

    void compliantMethod() {
    }
}
