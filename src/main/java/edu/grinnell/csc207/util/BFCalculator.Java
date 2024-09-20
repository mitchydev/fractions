package edu.grinnell.csc207.util;
/**
 * The primary workhorse. This class has a field that stores the last value 
 * calculated and provides the several functional methods.
 */
public class BFcalculator {
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  // The last BigFraction value that we computed.
  private BigFraction lastval;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  public BFcalculator (BigFraction lastval) {
    this.lastval = lastval;
  
  } // BFcalculator

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
  * Gets the last computed value
  *
  * @return The last computed Value
  */
  public BigFraction get() {
    if (this.lastval == null) {
      this.lastval = new BigFraction(0, 1);
    }
    return this.lastval;
  }

  /**
  * adds the last computed value to a bigfraction
  *
  * @return void
  */
  public void add(BigFraction val) {
    this.lastval = this.lastval.add(val);
  }

  /**
  * subtracts the last computed value to a bigfraction
  *
  * @return void
  */
  public void subtract(BigFraction val) {
    this.lastval = this.lastval.subtract(val);
  }

  /**
  * multiplies the last computed value to a bigfraction
  *
  * @return void
  */
  public void multiply(BigFraction val){
    this.lastval = this.lastval.multiply(val);
  }

  /**
  * divide the last computed value to a bigfraction
  *
  * @return void
  */
  public void divide(BigFraction val) {
    this.lastval = this.lastval.divide(val);
  }

  /**
  * Clears the lastvalue to zero
  *
  * @return void
  */
  public void clear(){
    this.lastval = new BigFraction(0, 1);
  }