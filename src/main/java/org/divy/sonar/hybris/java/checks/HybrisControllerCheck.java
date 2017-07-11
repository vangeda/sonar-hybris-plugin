package org.divy.sonar.hybris.java.checks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ImportTree;

@Rule(key = "HybrisControllerCheck")
public class HybrisControllerCheck extends BaseTreeVisitor implements JavaFileScanner {
    private static final Logger LOGGER = LoggerFactory.getLogger(HybrisControllerCheck.class);

    private JavaFileScannerContext context;

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;

        scan(context.getTree());
    }

    @Override
    public void visitImport(ImportTree importTree) {
        if(isModelImport(importTree)) {
            context.reportIssue(this, importTree.qualifiedIdentifier(), "Avoid using Models in Controller");
        }
        super.visitImport(importTree);
    }

    private boolean isModelImport(ImportTree importTree) {
        return importTree.qualifiedIdentifier().lastToken().text().contains("Model");
    }
}
