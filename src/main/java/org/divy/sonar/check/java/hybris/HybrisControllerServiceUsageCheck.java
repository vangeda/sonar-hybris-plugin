package org.divy.sonar.check.java.hybris;

import org.divy.sonar.check.java.generic.AbstractLayerUsageCheck;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.regex.Pattern;

@Rule(
        key = "HybrisControllerServiceUsageCheck",
        priority = Priority.MINOR,
        name = "Controller should not use server classes directly",
        tags = {"hybris"},
        description = "Use facade classes in controller instead of using service classes directly"
)
public class HybrisControllerServiceUsageCheck extends AbstractLayerUsageCheck {

    private static final String SPRING_CONTROLLER_ANNOTATION = "org.springframework.stereotype.Controller";
    private static final String MESSAGE = "Refactor Controller to use facade instead of service directly";

    private static final Pattern TARGET_TYPE_NAME_MATCH = Pattern.compile("(.)*Controller$");
    private static final Pattern RESTRICTED_TYPE_NAME_MATCH = Pattern.compile("(.)*(Service)$");

    @Override
    protected boolean isTargetedType(ClassTree type) {
        return isAnnotatedWith(type, SPRING_CONTROLLER_ANNOTATION)
                || hasTargetedTypeName(type);
    }

    @Override
    protected boolean hasTargetedTypeName(ClassTree type) {
        return TARGET_TYPE_NAME_MATCH.matcher(type.simpleName().name()).matches();
    }

    @Override
    protected boolean isRestricted(Tree tree) {
        String typeName = tree.lastToken().text();
        return RESTRICTED_TYPE_NAME_MATCH.matcher(typeName).matches();
    }

    @Override
    protected String getMessage(Tree tree) {
        return MESSAGE;
    }

}
