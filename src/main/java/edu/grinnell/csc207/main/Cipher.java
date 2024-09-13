package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;


/**
 *  This class is the main method for the cipher system, taking in command line
 * arguments and performing operations to get the desired output.
 */
public class Cipher {
  /**
   * ** The size of the alphabet.
   */
  private static final int ARGUMENTLIMIT = 4;
  /**
    *  This class is the main method for the cipher system, taking in command line
    * arguments and performing operations to get the desired output.
    * @param args The command line arguments.
    */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != ARGUMENTLIMIT) {
      System.err.println("Error: Expected 4 parameters recieved " + args.length + ".");
      pen.close();
      return;
    } // if statement
    String action = null;
    String ciphertype = null;
    String message = null;
    String key = null;
    boolean afound = false;
    boolean cfound = false;
    int numberofargs = 0;
    for (String arg : args) {
      if (arg.startsWith("-")) {
        if (arg.equals("-encode")) {
          action = "encode";
          afound = true;
          numberofargs += 1;
        } else if (arg.equals("-decode")) {
          action = "decode";
          afound = true;
          numberofargs += 1;
        } else if (arg.equals("-caesar")) {
          ciphertype = "caesar";
          cfound = true;
          numberofargs += 1;
        } else if (arg.equals("-vigenere")) {
          ciphertype = "vigenere";
          cfound = true;
          numberofargs += 1;
        } else if (arg.startsWith("-")) {
          System.err.println("Error: No valid action specified."
              + " Legal values are '-encode' and '-decode'");
          pen.close();
          return;
        } // else if statement
      } else if (message == null) {
        message = arg;
        numberofargs += 1;
      } else if (key == null) {
        key = arg;
        numberofargs += 1;
      } else {
        System.err.println("Error: Expected 4 parameters recieved " + numberofargs);
        pen.close();
        return;
      } // else statement
    } // for loop
    if (key == null) {
      System.err.println("Error: Key not found.");
      return;
    } // if statement
    for (char ch: message.toCharArray()) {
      if (Character.isUpperCase(ch) || ch == ' ') {
        System.err.println("Error: Strings must be only lowercase letters.");
        return;
      } // if statement
    } // for loop
    for (char ch: key.toCharArray()) {
      if (Character.isUpperCase(ch) || ch == ' ') {
        System.err.println("Error: Strings must be only lowercase letters.");
        return;
      } // if statement
    } // for loop
    if ((ciphertype.equals("caesar")) && (key.length() != 1)) {
      System.err.println("Error: Caesar ciphers require a one-character key.");
      return;
    } // if statement
    if ((ciphertype.equals("vigenere")) && (key.isEmpty())) {
      System.err.println("Error: Empty keys are not permitted.");
      return;
    } // if statement
    if (ciphertype.equals("caesar")) {
      if (action.equals("encode")) {
        String encryptedMessage = CipherUtils.caesarEncrypt(message, key.charAt(0));
        pen.printf("%s\n", encryptedMessage);
        return;
      } // if statement
      if (action.equals("decode")) {
        String decryptedMessage = CipherUtils.caesarDecrypt(message, key.charAt(0));
        pen.printf("%s\n", decryptedMessage);
        return;
      } // if statement
    } // if statement
    if (ciphertype.equals("vigenere")) {
      if (action.equals("encode")) {
        String encryptedMessage = CipherUtils.vigenereEncrypt(message, key);
        pen.printf("%s\n", encryptedMessage);
      } // if statement
      if (action.equals("decode")) {
        String decryptedMessage = CipherUtils.vigenereDecrypt(message, key);
        pen.printf("%s\n", decryptedMessage);
      } // if statement
    } else {
      System.err.println("Error: Incorrect number of parameters.");
      return;
    } // else statement
    pen.close();
  } // main class
} // class Cipher
