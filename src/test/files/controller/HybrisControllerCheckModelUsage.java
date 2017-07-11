package org.divy.sonar.hybris.java.checks;

import org.sonar.java.checks.verifier.JavaCheckVerifier;
import de.hybris.platform.catalog.model.CatalogModel;

public class HybrisControllerCheckModelUsage {

    void nonComplientMethod() {
        CatalogModel catalogModel;
    }

    void complientMethod() {
    }
}
