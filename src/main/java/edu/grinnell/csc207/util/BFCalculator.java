package edu.grinnell.csc207.util;

/**
 * The primary workhorse. This class has a field that stores the last value
 * calculated and provides the several functional methods.
 */
public class BFCalculator {
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** Initializes the last val. */
  private BigFraction lastval;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
  * Initializes lastval.
  */
  public BFCalculator() {
    this.lastval = new BigFraction(0, 1);
  } // BFCalculator

  /**
  * Constructor for the util file. Sets the last value as the initial value.
  * @param initialvalue the initial value for the util file.
  */
  public BFCalculator(BigFraction initialvalue) {
    this.lastval = initialvalue;
  } // BFcalculator

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
  * Gets the last computed value.
  *
  * @return The last computed Value..
  */
  public BigFraction get() {
    if (this.lastval == null) {
      this.lastval = new BigFraction(0, 1);
    } // if statement
    return this.lastval;
  } // BigFraction get()

  /**
  * adds the last computed value to a bigfraction.
  *
  * @param val the last computed value
  *
  */
  public void add(BigFraction val) {
    this.lastval = this.lastval.add(val);
  } //BigFraction val

  /**
  * subtracts the last computed value to a bigfraction.
  *
  * @param val the value to be subtracted.
  */
  public void subtract(BigFraction val) {
    this.lastval = this.lastval.subtract(val);
  } // subtract(BigFraction val)

  /**
  * multiplies the last computed value to a bigfraction.
  *
  * @param val the value to be multiplied
  */
  public void multiply(BigFraction val) {
    this.lastval = this.lastval.multiply(val);
  } // multiply(BigFraction val)

  /**
  * divide the last computed value to a bigfraction.
  *
  * @param val the value to be divided
  */
  public void divide(BigFraction val) {
    this.lastval = this.lastval.divide(val);
  } //divide(BigFraction val)

  /**
  * Clears the lastvalue to zero.
  */
  public void clear() {
    this.lastval = new BigFraction(0, 1);
  } //clear()
} // BFcalculator

