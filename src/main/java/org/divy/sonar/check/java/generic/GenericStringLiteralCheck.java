package org.divy.sonar.check.java.generic;

import org.apache.commons.lang.StringUtils;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.LiteralTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.squidbridge.annotations.RuleTemplate;

import java.util.regex.Pattern;

@Rule(
        key = "GenericStringLiteralCheck",
        priority = Priority.MINOR,
        name = "String Literal with certain pattern not allowed",
        tags = {"hybris"},
        description = "Not use String Literal with certain pattern"
)
@RuleTemplate
public class GenericStringLiteralCheck extends AbstractTargetedCheck {

    private static final String HTML_PATTERN = "\"(</?(\\s*\"[^\"]*\"|'[^']*'|[^'\">])*>)+\"";

    @RuleProperty(description = "Human readable name of Architecture layer where the check needs to be performed")
    String targetTypeName;

    @RuleProperty(description = "Pattern to match the Architecture layer where the check needs to be performed")
    String targetTypeNameMatch;

    private Pattern targetTypeNameMatchPattern;

    @RuleProperty(description = "Pattern to match the String literal", defaultValue = HTML_PATTERN)
    String restrictedPattern;

    private Pattern restrictedCompiledPattern;

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    @Override
    public void visitLiteral(LiteralTree tree) {
        if (tree.is(Tree.Kind.STRING_LITERAL) && isTag(tree)) {
            context.reportIssue(this, tree, String.format("Refactor %1s to nor use html tags directly and let view template define the tags", targetTypeName));
        }
    }

    private boolean isTag(LiteralTree tree) {
        return resolveRestrictedCompiledPattern().matcher(tree.value()).matches();
    }

    private Pattern resolveRestrictedCompiledPattern() {
        if(restrictedCompiledPattern == null) {
            if(StringUtils.isEmpty(restrictedPattern)) {
                restrictedPattern = HTML_PATTERN;
            }
            restrictedCompiledPattern = Pattern.compile(restrictedPattern);
        }
        return restrictedCompiledPattern;
    }

    @Override
    protected boolean hasTargetedTypeName(ClassTree type) {
        return resolveTargetTypeNameMatchPattern().matcher(type.simpleName().name()).matches();
    }

    private Pattern resolveTargetTypeNameMatchPattern() {
        if (targetTypeNameMatchPattern == null) {
            targetTypeNameMatchPattern = Pattern.compile(targetTypeNameMatch);
        }
        return targetTypeNameMatchPattern;
    }

    public void setTargetTypeNameMatch(String targetTypeNameMatch) {
        this.targetTypeNameMatch = targetTypeNameMatch;
    }

    public void setTargetTypeName(String targetTypeName) {
        this.targetTypeName = targetTypeName;
    }
}
