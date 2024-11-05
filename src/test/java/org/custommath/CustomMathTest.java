package org.custommath;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomMathTest {

  /**
   * Testing the sum of two values bigger than 0
   */
  @Test
  void testSum1() {
    System.out.println("Sum of two values test");
    Integer sum = CustomMath.sum(2, 3);
    assertEquals(5, sum, "The result is not equal to the expected value");
  }

  /**
   * Testing the sum of zero values
   */
  @Test
  void testSum2() {
    System.out.println("Sum of O's test");
    Integer sum = CustomMath.sum(0, 0);
    assertEquals(0, sum, "The result is not equal to the expected value");
  }

  /**
   * Test of division method, of class CustomMath.
   * Testing division by 0, expecting exception IllegalArgumentException
   */
  @Test
  public void testDivisionByZero() {
    System.out.println("Division by O test");
    IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> CustomMath.division(0, 0));
    assertTrue(thrown.getMessage().contains("Division by 0"));
  }

  /**
   * Test of division method, of class CustomMath.
   * Testing division of two values.
   */
  @Test
  public void testDivision() {
    System.out.println("Division of two values");
    assertEquals(2d, CustomMath.division(4, 2), "The result is not equal to the expected value");
  }

  /**
   * Test of division method, of class CustomMath.
   * Testing division by 0 and other values, expecting exception IllegalArgumentException
   */
  @ParameterizedTest
  @CsvSource({"6, 3, 2.0", "10, 2, 5.0", "10, 0,", "0, 2, 0.0"}) // six numbers
  public void testDivision2(Integer x, Integer y, Double expResult) {

    System.out.println("Division " + x + " by " + y + ", expecting " + expResult);
    try {
      assertEquals(expResult, CustomMath.division(x, y));
    } catch (IllegalArgumentException e) {
      System.out.println("Exception: " + e.getMessage());
    }
  }

  /**
   * Test of division method, of class CustomMath.
   * Testing division by 0 and other values, expecting exception IllegalArgumentException
   */
  @ParameterizedTest
  @CsvSource({"6, 3, 2.0", "10, 2, 5.0", "10, 0,", "10, 0, 0", "0, 2, 0.0"}) // six numbers
  public void testDivision3(Integer x, Integer y, Double expResult) {
    assertNotNull(x, "The value 'x' should be defined!");
    assertNotNull(y, "The value 'y' should be defined!");
    assertNotNull(expResult, "The value 'expResult' should be defined!");

    assertNotEquals(y, 0, "The divider must be bigger or smaller than zero! ");

    System.out.println("Division " + x + " by " + y + ", expecting " + expResult);

    assertEquals(expResult, CustomMath.division(x, y));
  }
}
