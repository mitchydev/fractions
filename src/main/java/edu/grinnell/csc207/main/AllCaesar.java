package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String str = args[1];
    String de = args[0];
    for (int i = 0; i < str.length() ; i++) {
      char check = str.charAt(i);
      int integer = (int) check - (int) 'a';
      if ((integer > 25) || (integer < 0))
      {
        
        System.err.println("Error: String contains characters other than lowercase letters.");
        return;
      }
      else
      {
        break;
      }

      
    }
    if (de.equals("encode"))
    {
      for (char ch = 'a'; ch <= 'z'; ch++) 
      {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
      }
    }
    if (de.equals("decode"))
    {
    for (char ch = 'a'; ch <= 'z'; ch++) 
    {
      pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
    }
  }
    if ((!de.equals("decode")) && (!de.equals("encode"))) 
    {
      System.err.println("Error: Invalid parameters");
      return;
    }
      pen.close();
  }
}
