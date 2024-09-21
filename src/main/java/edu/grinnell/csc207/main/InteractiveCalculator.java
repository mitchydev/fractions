package edu.grinnell.csc207.main;
import java.io.PrintWriter;
import java.util.Scanner;
import edu.grinnell.csc207.util.BigFraction;
import edu.grinnell.csc207.util.BFRegisterSet;

/**
 * Words words words words
 */
public class InteractiveCalculator {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner eyes = new Scanner(System.in);
    BigFraction lastvalue = new BigFraction(0, 1);
    BFRegisterSet registers = new BFRegisterSet();

    while(true) {
      pen.print("> ");
      pen.flush();
      String stuff = eyes.nextLine().trim();

      if (stuff.equals("QUIT") || stuff.equals("quit")) {
        break;
      }

    if (stuff.startsWith("STORE") || stuff.startsWith("store")) {
      String[] storedvars = stuff.split(" ");
      char storedvalue = storedvars[1].charAt(0);
      registers.store(storedvalue, lastvalue);  
      continue;
    }

      String[ ] inputs = stuff.split(" ");
      BigFraction result;

      if (Character.isLetter(inputs[0].charAt(0))) {
        result = registers.get(inputs[0].charAt(0));
      } else {
        result = new BigFraction(inputs[0]);
      }

      for (int i = 1; i < inputs.length; i += 2) {
        String operator = inputs[i];
        BigFraction ontothenext;

        if (Character.isLetter(inputs[i + 1].charAt(0))) {
          ontothenext = registers.get(inputs[i + 1].charAt(0));
        }
        else {
          ontothenext = new BigFraction((inputs[i + 1]));
        }

        switch (operator) {
          case "+":
            result = result.add(ontothenext);
            break;
          case "-":
            result = result.subtract(ontothenext);
            break;
          case "*":
            result = result.multiply(ontothenext);
            break;
          case "/":
            result = result.divide(ontothenext);
            break;
          default:
            pen.println("Unknown symbol!");
            break;
        }
      }
      lastvalue = result;
      pen.println(result);
    }

    eyes.close();

  }

}
