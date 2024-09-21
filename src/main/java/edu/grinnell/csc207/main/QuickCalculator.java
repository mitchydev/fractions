package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.BigFraction;
import edu.grinnell.csc207.util.BFRegisterSet;

/**
 * Words words words words
 */
public class QuickCalculator {
  public static void main(String[] args) {
    BigFraction lastvalue = new BigFraction(0, 1);
    BFRegisterSet registers = new BFRegisterSet();

    for (String arg: args) {
      String[] storedvars = arg.split(" ");

      if (storedvars[0].startsWith("STORE") || storedvars[0].startsWith("store")) {
        char register = storedvars[1].charAt(0);
        registers.store(storedvalue, lastvalue);  
      }
  
    }
  }
  
  
}
