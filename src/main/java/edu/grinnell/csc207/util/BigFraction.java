package edu.grinnell.csc207.util;

import java.math.BigInteger;

/**
 * A simple implementation of arbitrary-precision Fractions.
 *
 * @author Samuel A. Rebelsky
 * @author Mitch Paiva Sam Schmidt
 */
public final class BigFraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+

  /*
   * (1) Denominators are always positive. Therefore, negative fractions
   * are represented with a negative numerator. Similarly, if a fraction
   * has a negative numerator, it is negative.
   *
   * (2) Fractions are not necessarily stored in simplified form. To
   * obtain a fraction in simplified form, one must call the `simplify`
   * method.
   */

  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /** The default numerator when creating fractions. */
  private static final BigInteger DEFAULT_NUMERATOR = BigInteger.valueOf(2);

  /** The default denominator when creating fractions. */
  private static final BigInteger DEFAULT_DENOMINATOR = BigInteger.valueOf(7);

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  private BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  private BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   *
   * Warning! Not yet stable.
   *
   * @param numerator
   *   The numerator of the fraction.
   * @param denominator
   *   The denominator of the fraction.
   */
  public BigFraction(BigInteger numerator, BigInteger denominator) {
    this.num = numerator;
    this.denom = denominator;
  } // BigFraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   *
   * Warning! Not yet stable.
   *
   * @param numerator
   *   The numerator of the fraction.
   * @param denominator
   *   The denominator of the fraction.
   */
  public BigFraction(int numerator, int denominator) {
    if (denominator < 0) {
      this.num = BigInteger.valueOf(-numerator);
      this.denom = BigInteger.valueOf(-denominator);
    } else {
      this.num = BigInteger.valueOf(numerator);
      this.denom = BigInteger.valueOf(denominator);
    } //else
    BigFraction simplified = this.simplify();
    this.num = simplified.num;
    this.denom = simplified.denom;

  } // BigFraction(int, int)

  /**
   * Build a new fraction by parsing ax string.
   *
   * Warning! Not yet implemented.
   *
   * @param str
   *   The fraction in string form
   */
  public BigFraction(String str) {
    String[] parts = str.split("/");

    if (parts.length == 1) {
      this.num = new BigInteger(parts[0]);
      this.denom = new BigInteger("1");
    } // if statement

    if (parts.length == 2) {
      this.num = new BigInteger(parts[0]);
      this.denom = new BigInteger(parts[1]);
    } // if statement

    BigFraction simplified = this.simplify();
    this.num = simplified.num;
    this.denom = simplified.denom;

  } // BigFraction

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Express this fraction as a double.
   *
   * @return the fraction approxiamted as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add another faction to this fraction.
   *
   * @param addend
   *   The fraction to add.
   *
   * @return the result of the addition.
   */
  public BigFraction add(BigFraction addend) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the product of this object's
    // denominator and addend's denominator
    resultDenominator = this.denom.multiply(addend.denom);
    // The numerator is more complicated
    resultNumerator =
      (this.num.multiply(addend.denom)).add(addend.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator).simplify();
  } // add(BigFraction)

  /**
   * Subract another faction to this fraction.
   *
   * @param subtractend The fraction to subtract
   *
   * @return the result of the subtraction.
   */
  public BigFraction subtract(BigFraction subtractend) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the product of this object's
    // denominator and addend's denominator
    resultDenominator = this.denom.multiply(subtractend.denom);
    // The numerator is more complicated
    resultNumerator =
      (this.num.multiply(subtractend.denom)).subtract(subtractend.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator).simplify();
  } // subtract(BigFraction)

  /**
   * Multiply two fractions together.
   *
   * @param multiplier The fraction to multiply.
   *
   * @return the result of the multiplication.
   */
  public BigFraction multiply(BigFraction multiplier) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the product of this object's
    // denominator and addend's denominator
    resultDenominator = this.denom.multiply(multiplier.denom);
    // The numerator is more complicated
    resultNumerator = this.num.multiply(multiplier.num);

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator).simplify();
  } // multiply (BigFraction)

  /**
   * Divide two fractions.
   *
   * @param dividend The fraction to divide.
   *
   * @return the result of the division.
   */
  public BigFraction divide(BigFraction dividend) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the product of this object's
    // denominator and addend's denominator
    resultNumerator = this.num.multiply(dividend.denom);
    resultDenominator = this.denom.multiply(dividend.num);

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator).simplify();
  } // divide (BigFraction)

  /**
  * identifies and returns the simplified fraction.
  *
  * @return the simplified fraction
  */
  public BigFraction simplify() {
    BigInteger common = this.num.gcd(this.denom);
    BigInteger resultNumerator = this.num.divide(common);
    BigInteger resultDenominator = this.denom.divide(common);
    return new BigFraction(resultNumerator, resultDenominator);
  } // simplify()

  /**
   * Get the denominator of this fraction.
   *
   * @return the denominator
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()

  /**
   * Get the numerator of this fraction.
   *
   * @return the numerator.
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()

  /**
   * Convert this fraction to a string for ease of printing.
   *
   * @return a string that represents the fraction.
   */
  public String toString() {
    BigFraction simplified = this.simplify();
    BigInteger numerator = simplified.num;
    BigInteger denominator = simplified.denom;
    if (num.equals(BigInteger.ZERO)) {
      return "0";
    } // if statement
    if (denominator.compareTo(BigInteger.ZERO) < 0) {
      numerator = numerator.negate();
      denominator = denominator.negate();
    } // if statement
    if (denominator.equals(BigInteger.ONE)) {
      return numerator.toString();
    } //if statement
    if (numerator.mod(denominator).equals(BigInteger.ZERO)) {
      return numerator.divide(denominator).toString();
    } // if statement
    return numerator + "/" + denominator;
  } // toString()
} // class BigFraction
