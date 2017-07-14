package org.divy.sonar.generic.java.check;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.*;

import java.util.List;

public abstract class AbstractLayerUsageCheck extends BaseTreeVisitor implements JavaFileScanner {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected JavaFileScannerContext context;

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    @Override
    public void visitImport(ImportTree importTree) {
        Tree importQualifier = importTree.qualifiedIdentifier();

        if(logger.isDebugEnabled()) {
            logger.debug("visiting import :", importQualifier.toString());
        }

        if(isTargetedCompilationUnit(importTree.parent()) && isRestricted(importQualifier)) {
            if(logger.isDebugEnabled()) {
                logger.debug("Found restricted import :", importQualifier.toString());
            }
            context.reportIssue(this, importQualifier, getMessage(importTree));
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

    protected abstract boolean isTargetedType(ClassTree classType);
    protected abstract boolean isRestricted(Tree tree);
    protected abstract String getMessage(Tree tree);
}
