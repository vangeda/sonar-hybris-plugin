
package org.divy.sonar.hybris.java;

import org.sonar.api.Plugin;

/**
 * Entry point of your plugin containing your custom rules
 */
public class HybrisRulesPlugin implements Plugin {

  @Override
  public void define(Context context) {

    // server extensions -> objects are instantiated during server startup
    context.addExtension(HybrisRulesDefinition.class);

    // batch extensions -> objects are instantiated during code analysis
    context.addExtension(HybrisFileCheckRegistrar.class);

  }

}
