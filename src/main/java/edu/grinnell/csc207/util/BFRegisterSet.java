package edu.grinnell.csc207.util;
/**
* A set of registers corresponding to the letters 'a' through 'z'.
*/
public class BFRegisterSet {
  /** Represents lowercase A. */
  private static final int LOWERCASE_A = 97;
  /** Keeps the size of the register. */
  private static final int REGISTERSIZE = 26;
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** Stores the value of fractions for corresponding register. */
  private final BigFraction[] stores;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /** Initializes the register set with the set register size (REGISTERSIZE). */
  public BFRegisterSet() {
    this.stores = new BigFraction[REGISTERSIZE];
  } // BFRegisterSet()

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
  * @param register The register where the value will be stored
  * @param val The value to store
  *
  */
  public void store(char register, BigFraction val) {
    int i = letter2int(register);
    stores[i] = val;
  } // store(char register, BigFraciton val)

  /**
  *  Retrieves the value from the given register.
  *
  * @param register The register to be searched
  * @return the value
  */
  public BigFraction get(char register) {
    int i = letter2int(register);
    if (stores[i] == null) {
      return new BigFraction(0, 1);
    } // if statement
    return stores[i];
  } // BigFraction get(char register)

} // BFRegisterSet ()
