package org.divy.sonar.hybris.java.checks;

import org.springframework.web.bind.annotation.RestController;
import org.sonar.java.checks.verifier.JavaCheckVerifier; // Compliant
import de.hybris.platform.servicelayer.product.ProductDao; // Noncompliant {{Refactor Controller to use facade instead of dao directly}}

@RestController
public class DaoUsageTestSampleRestController {

    ProductDao classMemberDao; // Noncompliant {{Refactor Controller to use facade instead of dao directly}}

    void nonCompliantMethod() {
        ProductDao localDao; // Noncompliant {{Refactor Controller to use facade instead of dao directly}}
    }

    void compliantMethod() {
    	JavaCheckVerifier localJavaCheckVerifier; // Compliant
    }
}
