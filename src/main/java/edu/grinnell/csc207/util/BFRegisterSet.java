package edu.grinnell.csc207.util;

/**
 * A set of registers corresponding to the letters 'a' through 'z'. 
 */
public class BFRegisterSet {

  private static final int LOWERCASE_A = 97;
  private static final int REGISTERSIZE = 26;
  
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  private final BigFraction[] stores;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  public BFRegisterSet() {
    this.stores = new BigFraction[REGISTERSIZE];
  }

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+
  /**
  * Converts a letter to an integer.
  *
  * @param letter The letter to convert
  * @return The integer value of the letter.
  */
  private static int letter2int(char letter) {
    int integer = (int) letter;
    int newletter = integer - LOWERCASE_A;
    return newletter;
  } // class letter2int (char letter)

  /**
  * Stores a BigFraction for an integer.
  *
  * @param letter The letter to convert
  * @return void
  */
  public void store(char register, BigFraction val) {
    int i = letter2int(register);
    stores[i] = val;
  } // store(char register, BigFraciton val)

  public BigFraction get(char register){
    int i = letter2int(register);
    if (stores[i] == null) {
      return new BigFraction(0,1);
    }
    return stores[i];
    }
    
}
  
