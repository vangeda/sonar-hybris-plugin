package org.divy.sonar.hybris.java.checks;

public class HtmlUsageTestSampleController {


    String nonCompliantMethod() {
        return "<html><body></body></html>"; // Noncompliant {{Refactor Controller to nor use html tags directly and let view template define the tags}}
    }

    String compliantMethod() {
        return "index.jsp";
    }
}
