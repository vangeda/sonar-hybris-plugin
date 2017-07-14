package org.divy.sonar.check.java.hybris;

import org.sonar.plugins.java.api.tree.Tree;

import java.util.List;

public interface UsageCheckVisitor {
    List<UsageCheckVisitResult> visit(Tree tree);
}
