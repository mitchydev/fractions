package edu.grinnell.csc207.main;
import java.io.PrintWriter;
import java.util.Scanner;
import edu.grinnell.csc207.util.BigFraction;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BFparse;

/**
 * Prompts the user to input commands that the calculator will take and pass to
 * BFparse.java for evaluation and calculation.
 */
public class InteractiveCalculator {
  /**
  * Takes in user arguments and passes it to the BFparse class.
  *
  * @param args user arugments.
  */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner eyes = new Scanner(System.in);
    BigFraction lastvalue = new BigFraction(0, 1);
    BFRegisterSet registers = new BFRegisterSet();
    BFparse parser = new BFparse(registers);

    while (true) {
      pen.print("> ");
      pen.flush();
      String stuff = eyes.nextLine().trim();

      if (stuff.equals("QUIT") || stuff.equals("quit")) {
        break;
      } // If statement

      if (stuff.startsWith("STORE") || stuff.startsWith("store")) {
        String[] storedvars = stuff.split(" ");
        char storedvalue = storedvars[1].charAt(0);
        registers.store(storedvalue, lastvalue);
        continue;
      } // if statement

      if (!stuff.isEmpty()) {
        BigFraction result = parser.parseAndeval(stuff);
        if (result != null) {
          lastvalue = result;
          pen.println(lastvalue);
        } else {
          pen.println("error: invalid");
        } // else statement
      } else {
        pen.println("error: no input");
      } // else statement
    } // while loop
    eyes.close();
  } // main(String args)
} // class InteractiveCalculator
