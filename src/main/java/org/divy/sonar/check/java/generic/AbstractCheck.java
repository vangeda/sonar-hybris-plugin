package org.divy.sonar.check.java.generic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.CompilationUnitTree;
import org.sonar.plugins.java.api.tree.ImportClauseTree;
import org.sonar.plugins.java.api.tree.ImportTree;
import org.sonar.plugins.java.api.tree.MemberSelectExpressionTree;
import org.sonar.plugins.java.api.tree.VariableTree;

public abstract class AbstractCheck extends BaseTreeVisitor implements JavaFileScanner {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected JavaFileScannerContext context;

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }
    
    protected boolean isAnnotatedWith(ClassTree classTree, String fullyQualifiedName) {
        return classTree.symbol().metadata().isAnnotatedWith(fullyQualifiedName);
    }
    
    protected boolean isAnnotatedWith(VariableTree variableTree, String fullyQualifiedName) {
    	String annotation = variableTree.modifiers().annotations().iterator().next().annotationType().toString();
    	boolean isAnnotated = false;
    	if (fullyQualifiedName.equals(annotation)) {
    		isAnnotated =  true;
    	} else if (fullyQualifiedName.endsWith("." + annotation)) {
    		List<ImportClauseTree> importsList = ((CompilationUnitTree)((ClassTree)variableTree.parent()).parent()).imports();
    		for (ImportClauseTree importTree : importsList) {
    			if (fullyQualifiedName.endsWith("." + ((MemberSelectExpressionTree)((ImportTree)importTree).qualifiedIdentifier()).identifier())) {
    				isAnnotated =  true;
    				break;
    			}
    		}
    	}
    	return isAnnotated;
    }

}
