package org.divy.sonar.hybris.java.checks;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.sonar.java.checks.verifier.JavaCheckVerifier; 
import de.hybris.platform.servicelayer.product.ProductHelper; 
import de.hybris.platform.servicelayer.product.ProductValue;
import de.hybris.platform.servicelayer.product.ProductEntity; 

public class AutowiredUsageTestSampleBean {

	@Autowired // Noncompliant {{The annotation Autowired should not be used. Use XML bean wiring instead}}
    ProductHelper productHelper; 

	@Value  // Compliant
	ProductValue productValue;
	
	@Resource // Compliant
	ProductEntity productEntity;
}
