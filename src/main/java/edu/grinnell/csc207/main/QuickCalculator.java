package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.BFparse;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BigFraction;

import java.io.PrintWriter;

/**
 * QuickCalculator processes command-line arguments to evaluate fractions and
 * store results in registers.
 *
 * @author Mitch Paiva
 */
public class QuickCalculator {
  /**
   * Reads user inputs and and passes it on to the BFparse util file for computation.
   *
   * @param args The command line arguments.
   */
  public static void main(String[] args) {
    BFRegisterSet registers = new BFRegisterSet();
    BFparse parser = new BFparse(registers);
    BigFraction lastValue = new BigFraction(0, 1);
    PrintWriter pen = new PrintWriter(System.out, true);

    for (String arg : args) {
      if (arg.startsWith("STORE") || arg.startsWith("store")) {
        String[] parts = arg.split(" ");
        char register = parts[1].charAt(0);
        registers.store(register, lastValue);
        pen.println(arg + " -> STORED");
      } else {
        BigFraction result = parser.parseAndeval(arg);
        if (result != null) {
          lastValue = result;
          pen.println(arg + " --> " + lastValue);
        } else {
          pen.println("Error: Invalid expression");
        } // else
      } // else
    } // for loop
  } // main(String[] args)
} // public class QuickCalculator
