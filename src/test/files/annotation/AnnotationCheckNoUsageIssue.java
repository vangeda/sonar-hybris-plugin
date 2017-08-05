package org.divy.sonar.hybris.java.checks;

import org.springframework.beans.factory.annotation.Value; 
import org.sonar.java.checks.verifier.JavaCheckVerifier; 
import de.hybris.platform.servicelayer.product.ProductHelper; 

public class AnnotationCheckNoUsageIssue {

	@Value
    ProductHelper productHelper; // Compliant

}
