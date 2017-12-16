package ru.itpark.lambda;

public class Caller {
  public void myCall(CallX callX) {
    System.out.println("X called");
    callX.call();
  }
  public void myCall(CallY callY) {
    System.out.println("Y called");
    callY.call();
  }
}
