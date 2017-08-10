package org.divy.sonar.check.java.generic;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.plugins.java.api.tree.VariableTree;
import org.sonar.squidbridge.annotations.RuleTemplate;

@Rule(
        key = "GenericAnnotationCheck",
        priority = Priority.MINOR,
        name = "Annotation should not be used. Use XML bean wiring instead.",
        tags = {"hybris"},
        description = "Use XML bean wiring instead of using annotations in classes directly."
)
@RuleTemplate
public class GenericAnnotationCheck extends AbstractCheck {

    @RuleProperty(description = "Fully qualified Class Name along with package for the restricted annotation.")
    String restrictedAnnotation;

    @RuleProperty(description = "Message to be shown in case of Non-Compliance")
    String message;

    @Override
    public void visitVariable(VariableTree tree) {
    	if (restrictedAnnotation != null && !restrictedAnnotation.isEmpty() && isAnnotatedWith(tree, restrictedAnnotation)) {
    		context.reportIssue(this, tree, message);
    	}
        super.visitVariable(tree);
    }


	public void setRestrictedAnnotation(String restrictedAnnotation) {
		this.restrictedAnnotation = restrictedAnnotation;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
