package org.divy.sonar.hybris.java.checks;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.tree.*;

@Rule(
        key = "HybrisControllerModelUsageCheck",
        priority = Priority.MINOR,
        name = "Controller should not use model classes directly",
        tags = {"hybris"},
        description = "Use DTO classes in controller instead of using model classes directly"
)
public class HybrisControllerModelUsageCheck extends AbstractLayerUsageCheck {

    private static final String SPRING_CONTROLLER_ANNOTATION = "org.springframework.stereotype.Controller";
    private static final String MESSAGE = "Refactor Controller to use DTO from request or a facade instead of using models";

    @Override
    protected boolean isTargetedType(ClassTree type) {
        return isAnnotatedWith(type, SPRING_CONTROLLER_ANNOTATION)
                || (type).simpleName().name().contains("Controller");
    }

    @Override
    protected boolean isRestricted(Tree tree) {
        String typeName = tree.lastToken().text();
        return typeName.contains("Model");
    }

    @Override
    protected String getMessage(Tree tree) {
        return MESSAGE;
    }

}
