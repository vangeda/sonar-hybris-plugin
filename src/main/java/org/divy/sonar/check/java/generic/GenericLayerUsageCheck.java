package org.divy.sonar.check.java.generic;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.regex.Pattern;

@Rule(
        key = "GenericLayerUsageCheck",
        priority = Priority.MINOR,
        name = "Architectural layer should not be skipped",
        tags = {"hybris"},
        description = "Use objects from immediate layer instead of skipping layers"
)
public class GenericLayerUsageCheck extends AbstractLayerUsageCheck {

    private static final String MESSAGE = "Refactor %1$s to not use %2$s directly";
    @RuleProperty(
            description = "Name of the annotation to avoid, without the prefix @, for instance 'Override'")
    protected String targetTypeNameMatch;
    @RuleProperty(description = "Name of the annotation to avoid, without the prefix @, for instance 'Override'")
    protected String restrictedTypeNameMatch;
    @RuleProperty(
            description = "Name of the annotation to avoid, without the prefix @, for instance 'Override'")
    protected String targetTypeName;
    @RuleProperty(description = "Name of the annotation to avoid, without the prefix @, for instance 'Override'")
    protected String restrictedTypeName;
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
            restrictedTypeNameMatchPattern = Pattern.compile(restrictedTypeNameMatch);
        }
        return restrictedTypeNameMatchPattern;
    }

    private Pattern resolveTargetTypeNameMatchPattern() {
        if (targetTypeNameMatchPattern == null) {
            targetTypeNameMatchPattern = Pattern.compile(targetTypeNameMatch);
        }
        return targetTypeNameMatchPattern;
    }
}
