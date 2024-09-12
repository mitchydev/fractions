package edu.grinnell.csc207.util;

public class CipherUtils {
  private static int letter2int(char letter) {
   int integer = (int) letter;
   int newletter = integer - 97;
   return newletter;
  }

  private static char int2letter(int i) {
    char letter = (char) (i + 97);
    return letter;
  }

  public static String caesarEncrypt(String str, char letter) {
    char[] name = new char[str.length()];
    for (int i = 0; i < str.length() ; i++) {
    
      int base = letter2int(str.charAt(i));
      int intfinalized = base + letter2int(letter);
      intfinalized = intfinalized % 26;
      char charfinal = int2letter(intfinalized);
      name[i] = charfinal;
    }
    return new String(name);
  }


  public static String caesarDecrypt(String str, char letter) {
    char[] name = new char[str.length()];
    for (int i = 0; i < str.length() ; i++) {
    
      int base = letter2int(str.charAt(i));
      int intfinalized = base - letter2int(letter);
      if (intfinalized < 0)
      {
        intfinalized = intfinalized += 26;
      }
      intfinalized = intfinalized % 26;
      char charfinal = int2letter(intfinalized);
      name[i] = charfinal;
    }
    return new String(name);
  }

  public static String vigenereEncrypt(String str, String key) {
    char[] name = new char[str.length()];
    for (int i = 0; i < str.length() ; i++) {
    
      int base1 = letter2int(str.charAt(i));
      int base2 = letter2int(key.charAt(i));
      int intfinished = base1 + base2;
      intfinished = intfinished % 26;
      char newletter = int2letter(intfinished);
      name[i] = newletter;
  }
  return new String(name);
}

  public static String vigenereDecrypt(String str, String key) {
    char[] name = new char[str.length()];
    for (int i = 0; i < str.length() ; i++) {
    
      int base1 = letter2int(str.charAt(i));
      int base2 = letter2int(key.charAt(i));
      int intfinished = base1 - base2;
      if (intfinished < 0)
      {
        intfinished = intfinished += 26;
      }
      intfinished = intfinished % 26;
      char newletter = int2letter(intfinished);
      name[i] = newletter;
  }
  return new String(name);
  }
}
