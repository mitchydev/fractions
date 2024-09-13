package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

/**
 *  This class drives the AllCaesar program, which encrypts/decrypts using
 * the Caesar cypher.
 */
public class AllCaesar {
  /**
   * ** The size of the alphabet.
   */
  private static final int CALPHABET_SIZE = 25;

  /**
    *  This class is the main method for the Caesar cipher system, taking in command line
    * arguments and performing operations to get the desired output.
    * @param args The command line arguments.
    */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length == 0) {
      System.err.println("Error: Incorrect number of parameters.");
      return;
    } //if statement
    if (args.length > 2 || args.length < 2) {
      if (args[0].equals("")) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt("", ch));
        } //if statement
        return;
      }  //if statement
      System.err.println("Error: Incorrect number of parameters.");
      return;
    } //if statement
    String str = args[1];
    String de = args[0];
    if ((!de.equals("decode")) && (!de.equals("encode"))) {
      System.err.println("Error: Invalid option: " + de
          + ".Valid options are \"encode\" or \"decode\"");
      return;
    } //if statement
    for (int i = 0; i < str.length(); i++) {
      char check = str.charAt(i);
      int integer = (int) check - (int) 'a';
      if ((integer > CALPHABET_SIZE) || (integer < 0)) {
        System.err.println("Error: String contains characters other than lowercase letters.");
        return;
      } else {
        break;
      } // else statement
    } // for loop
    if (de.equals("encode")) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
      } // for loop
    } // if statement
    if (de.equals("decode")) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
      } // for loop
    } // if statement
    pen.close();
  } // main class
} // class AllCaesar
