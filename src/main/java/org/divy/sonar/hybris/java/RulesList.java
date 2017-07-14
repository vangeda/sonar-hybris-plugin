
package org.divy.sonar.hybris.java;

import com.google.common.collect.ImmutableList;
import org.divy.sonar.hybris.java.checks.HybrisControllerDaoUsageCheck;
import org.divy.sonar.hybris.java.checks.HybrisControllerModelUsageCheck;
import org.divy.sonar.hybris.java.checks.HybrisControllerServiceUsageCheck;
import org.sonar.plugins.java.api.JavaCheck;

import java.util.List;

public final class RulesList {

  private RulesList() {
  }

  public static List<Class> getChecks() {
    return ImmutableList.<Class>builder().addAll(getJavaChecks()).addAll(getJavaTestChecks()).build();
  }

  public static List<Class<? extends JavaCheck>> getJavaChecks() {
    return ImmutableList.<Class<? extends JavaCheck>>builder()
      .add(HybrisControllerDaoUsageCheck.class)
      .add(HybrisControllerServiceUsageCheck.class)
      .add(HybrisControllerModelUsageCheck.class)
      .build();
  }

  public static List<Class<? extends JavaCheck>> getJavaTestChecks() {
    return ImmutableList.<Class<? extends JavaCheck>>builder()
      .build();
  }
}
