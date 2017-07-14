package org.divy.sonar.hybris.java.checks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.*;

import java.util.List;

public abstract class AbstractLayerUsageCheck extends BaseTreeVisitor implements JavaFileScanner {
    private static final Logger LOGGER = LoggerFactory.getLogger(HybrisControllerModelUsageCheck.class);
    private JavaFileScannerContext context;

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;

        scan(context.getTree());
    }

    @Override
    public void visitImport(ImportTree importTree) {

        if(isTargetedCompilationUnit(importTree.parent()) && isRestricted(importTree.qualifiedIdentifier())) {
            context.reportIssue(this, importTree.qualifiedIdentifier(), getMessage(importTree));
        }
        super.visitImport(importTree);
    }

    private boolean isTargetedCompilationUnit(Tree parent) {
        return parent.is(Tree.Kind.COMPILATION_UNIT) && containsTargetedType(((CompilationUnitTree)parent).types() );
    }

    private boolean containsTargetedType(List<Tree> types) {
        for (Tree type : types) {
            if(type.is(Tree.Kind.CLASS) && isTargetedType((ClassTree)type)) {
                return true;
            }
        }
        return false;
    }

    protected boolean isAnnotatedWith(ClassTree it, String fullyQualifiedName) {
        return it.symbol().metadata().isAnnotatedWith(fullyQualifiedName);
    }

    @Override
    public void visitVariable(VariableTree tree) {
        if(isTargetedChild(tree) && isRestricted(tree.type())) {
            context.reportIssue(this, tree, getMessage(tree));
        }
        super.visitVariable(tree);
    }

    private boolean isTargetedChild(Tree tree) {
        Tree possibleClass = tree;
        while (possibleClass.parent()!=null) {
            possibleClass = possibleClass.parent();
            if(possibleClass.is(Tree.Kind.CLASS)) {
                break;
            }
        }

        ClassTree classTree = (ClassTree) possibleClass;

        return isTargetedType(classTree);
    }

    abstract protected boolean isTargetedType(ClassTree classType);
    abstract protected boolean isRestricted(Tree tree);
    abstract protected String getMessage(Tree tree);
}
