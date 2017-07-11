package org.divy.sonar.hybris.java.checks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;

@Rule(key = "HybrisLoggingCheck")
public class HybrisLoggingCheck  extends BaseTreeVisitor implements JavaFileScanner  {
    private static final Logger LOGGER = LoggerFactory.getLogger(HybrisLoggingCheck.class);

    private JavaFileScannerContext context;

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;

        scan(context.getTree());
    }
}
