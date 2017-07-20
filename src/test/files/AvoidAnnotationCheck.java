/**
 *This file is the sample code against we run our unit test.
 *It is placed src/test/files in order to not be part of the maven compilation.
 **/
class AvoidAnnotationCheck {

  int aField;

  @MyAnnotation // Noncompliant {{Avoid using annotation @MyAnnotation}}
  public void aMethod() {

  }

  @Zuper 
  public void aMethod() {

  }

}
