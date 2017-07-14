package org.divy.sonar.hybris.java.checks;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.Tree;

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

    @Override
    protected boolean isTargetedType(ClassTree type) {
        return isAnnotatedWith(type, SPRING_CONTROLLER_ANNOTATION)
                || (type).simpleName().name().contains("Controller");
    }

    @Override
    protected boolean isRestricted(Tree tree) {
        String typeName = tree.lastToken().text();
        return typeName.contains("Service") || typeName.contains("Service");
    }

    @Override
    protected String getMessage(Tree tree) {
        return MESSAGE;
    }

}
