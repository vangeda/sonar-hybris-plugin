package org.divy.sonar.check.java.generic;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.squidbridge.annotations.RuleTemplate;

import java.util.regex.Pattern;

@Rule(
        key = "GenericLayerUsageCheck",
        priority = Priority.MINOR,
        name = "Architectural layer should not be skipped",
        tags = {"hybris"},
        description = "Use objects from immediate layer instead of skipping layers"
)
@RuleTemplate
public class GenericLayerUsageCheck extends AbstractLayerUsageCheck {

    private static final String MESSAGE = "Refactor %1$s to not use %2$s directly";

    @RuleProperty(description = "Pattern to match the Architecture layer where the check needs to be performed")
    String targetTypeNameMatch;

    @RuleProperty(description = "Does Pattern of the Architecture layer where the check needs to be performed needs to be Case-Sensitive?")
    boolean isTargetTypeNameMatchCaseSensitive;

    @RuleProperty(description = "Human readable name of Architecture layer where the check needs to be performed")
    String targetTypeName;

    @RuleProperty(description = "Pattern to match restricted layer to be checked")
    String restrictedTypeNameMatch;

    @RuleProperty(description = "Does Pattern of restricted layer to be checked needs to be Case-Sensitive?")
    boolean isRestrictedTypeNameMatchCaseSensitve;

    @RuleProperty(description = "Human readable name of restricted layer")
    String restrictedTypeName;

    private Pattern targetTypeNameMatchPattern;
    private Pattern restrictedTypeNameMatchPattern;

    @Override
    protected boolean hasTargetedTypeName(ClassTree type) {
        return resolveTargetTypeNameMatchPattern().matcher(type.simpleName().name()).matches();
    }


    @Override
    protected boolean isRestricted(Tree tree) {
        String typeName = tree.lastToken().text();
        return resolveRestrictedTypeNameMatchPattern().matcher(typeName).matches();
    }

    @Override
    protected String getMessage(Tree tree) {
        return String.format(MESSAGE, targetTypeName, restrictedTypeName);
    }

    private Pattern resolveRestrictedTypeNameMatchPattern() {
        if (restrictedTypeNameMatchPattern == null) {
        	if (isRestrictedTypeNameMatchCaseSensitve) {
        		restrictedTypeNameMatchPattern = Pattern.compile(restrictedTypeNameMatch);
        	} else {
        		restrictedTypeNameMatchPattern = Pattern.compile(restrictedTypeNameMatch, Pattern.CASE_INSENSITIVE);
        	}
        }
        return restrictedTypeNameMatchPattern;
    }

    private Pattern resolveTargetTypeNameMatchPattern() {
        if (targetTypeNameMatchPattern == null) {
        	if (isTargetTypeNameMatchCaseSensitive) {
        		targetTypeNameMatchPattern = Pattern.compile(targetTypeNameMatch);
        	} else {
        		targetTypeNameMatchPattern = Pattern.compile(targetTypeNameMatch, Pattern.CASE_INSENSITIVE);
        	}
        }
        return targetTypeNameMatchPattern;
    }

    public void setTargetTypeNameMatch(String targetTypeNameMatch) {
        this.targetTypeNameMatch = targetTypeNameMatch;
    }

    public void setRestrictedTypeNameMatch(String restrictedTypeNameMatch) {
        this.restrictedTypeNameMatch = restrictedTypeNameMatch;
    }

    public void setTargetTypeName(String targetTypeName) {
        this.targetTypeName = targetTypeName;
    }

    public void setTargetTypeNameMatchCaseSensitive(boolean isTargetTypeNameMatchCaseSensitive) {
		this.isTargetTypeNameMatchCaseSensitive = isTargetTypeNameMatchCaseSensitive;
	}


	public void setRestrictedTypeNameMatchCaseSensitve(boolean isRestrictedTypeNameMatchCaseSensitve) {
		this.isRestrictedTypeNameMatchCaseSensitve = isRestrictedTypeNameMatchCaseSensitve;
	}


	public void setRestrictedTypeName(String restrictedTypeName) {
        this.restrictedTypeName = restrictedTypeName;
    }
}
