package org.divy.sonar.hybris.java.checks;

import org.springframework.stereotype.Controller;
import org.sonar.java.checks.verifier.JavaCheckVerifier; // Compliant
import de.hybris.platform.servicelayer.product.ProductDAO; // Noncompliant {{Refactor Controller to use facade instead of dao directly}}

@Controller
public class DaoUsageTestSampleController {

	ProductDAO classMemberDAO; // Noncompliant {{Refactor Controller to use facade instead of dao directly}}

    void nonCompliantMethod() {
    	ProductDAO localDAO; // Noncompliant {{Refactor Controller to use facade instead of dao directly}}
    }

    void compliantMethod() {
    }
}
