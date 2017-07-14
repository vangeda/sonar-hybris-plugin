package org.divy.sonar.hybris.java.checks;

import org.sonar.java.checks.verifier.JavaCheckVerifier; // Compliant
import de.hybris.platform.servicelayer.user.UserService; // Compliant
import de.hybris.platform.servicelayer.product.ProductDao; // Compliant

/**
 * Class which is not a Controller, Facade nor Service
 */
public class HybrisCheckModelUsage {

    private CatalogModel classMemberModel = null; // Compliant
    UserService classMemberService; // Compliant
    ProductDao classMemberDao; // Compliant

    void compliantMethod() {
        CatalogModel localModel = new CatalogModel(); // Compliant
        UserService localService; // Compliant
        ProductDao localMemberDao; // Compliant
    }
}
