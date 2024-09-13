package edu.grinnell.csc207.util;
/**
 * Utility class for encryption/decryption of Caesar/Vigenere cipher.
 */
public class CipherUtils {
  /**
   * ** The ASCII value of 'a'.
   */
  private static final int LOWERCASE_A = 97;
  /**
   * ** The size of the alphabet.
   */
  private static final int ALPHABET_SIZE = 26;

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
  } // class letter2int
  /**
  * Converts a integer to an letter.
  *
  * @param i The integer to convert.
  * @return The char or the int
  */
  private static char int2letter(int i) {
    char letter = (char) (i +  LOWERCASE_A);
    return letter;
  } // class int2letter

  /**
  * Encrypts a string using a Caesar cypher.
  *
  * @param str The string to encrypt
  * @param letter The char key used to encrypt
  * @return The encrypted string.
  */
  public static String caesarEncrypt(String str, char letter) {
    char[] name = new char[str.length()];
    for (int i = 0; i < str.length(); i++) {
      int base = letter2int(str.charAt(i));
      int intfinalized = base + letter2int(letter);
      intfinalized = intfinalized % ALPHABET_SIZE;
      char charfinal = int2letter(intfinalized);
      name[i] = charfinal;
    } // for loop
    return new String(name);
  } // class caesarEncrypt

  /**
  * Decrypts a string using a Caesar cypher.
  *
  * @param str The string to decrypt
  * @param letter The char key used to decrypt
  * @return The encrypted string.
  */
  public static String caesarDecrypt(String str, char letter) {
    char[] name = new char[str.length()];
    for (int i = 0; i < str.length(); i++) {
      int base = letter2int(str.charAt(i));
      int intfinalized = base - letter2int(letter);
      if (intfinalized < 0) {
        intfinalized += ALPHABET_SIZE;
      } //if statement
      intfinalized = intfinalized % ALPHABET_SIZE;
      char charfinal = int2letter(intfinalized);
      name[i] = charfinal;
    } // for loop
    return new String(name);
  } // class caesarDecrypt

  /**
  * Encrypts a string using a Vigenere cypher.
  *
  * @param str The string to encrypt
  * @param key The string key used to encrypt
  * @return The encrypted string.
  */
  public static String vigenereEncrypt(String str, String key) {
    char[] name = new char[str.length()];
    for (int i = 0; i < str.length(); i++) {
      int base1 = letter2int(str.charAt(i));
      int base2 = letter2int(key.charAt((i % key.length())));
      int intfinished = base1 + base2;
      intfinished = intfinished % ALPHABET_SIZE;
      char newletter = int2letter(intfinished);
      name[i] = newletter;
    } // for loop
    return new String(name);
  } // class vigenereEncrypt

  /**
  * Decrypts a string using a Vigenere cypher.
  *
  * @param str The string to decrypt
  * @param key The string key used to decrypt
  * @return The Decrypted string.
  */
  public static String vigenereDecrypt(String str, String key) {
    char[] name = new char[str.length()];
    for (int i = 0; i < str.length(); i++) {
      int base1 = letter2int(str.charAt(i));
      int base2 = letter2int(key.charAt((i % key.length())));
      int intfinished = base1 - base2;
      if (intfinished < 0) {
        intfinished += ALPHABET_SIZE;
      } // if statement
      intfinished = intfinished % ALPHABET_SIZE;
      char newletter = int2letter(intfinished);
      name[i] = newletter;
    } // for loop
    return new String(name);
  } // class vingereDecrypt
} // class CipherUtils
