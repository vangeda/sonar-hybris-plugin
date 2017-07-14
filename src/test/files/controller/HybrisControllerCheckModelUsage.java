package org.divy.sonar.hybris.java.checks;

import org.sonar.java.checks.verifier.JavaCheckVerifier; // Compliant
import de.hybris.platform.catalog.model.CatalogModel; // Noncompliant {{Refactor Controller to use DTO from request or a facade instead of using models}}
import org.springframework.stereotype.Controller;

@Controller
public class HybrisControllerCheckModelUsage {

    CatalogModel unInitializedclassMemberModel; // Noncompliant {{Refactor Controller to use DTO from request or a facade instead of using models}}
    CatalogModel initializedClassMemberModel = new CatalogModel(); // Noncompliant {{Refactor Controller to use DTO from request or a facade instead of using models}}

    JavaCheckVerifier javaCheckVerifier; // Compliant

    void nonCompliantMethod() {
        CatalogModel localModel1; // Noncompliant {{Refactor Controller to use DTO from request or a facade instead of using models}}
        CatalogModel localModel2 = new CatalogModel(); // Noncompliant {{Refactor Controller to use DTO from request or a facade instead of using models}}
    }

    void compliantMethod() {
        JavaCheckVerifier localJavaCheckVerifier; // Compliant
    }
}
