package org.custommath;

public class CustomMath {
  public static int sum(int x, int y) {
    return x + y;
  }

  public static double division(int x, int y) {
    if (y == 0) {
      throw new IllegalArgumentException("Division by 0");
    }
    return (x / y);
  }
}