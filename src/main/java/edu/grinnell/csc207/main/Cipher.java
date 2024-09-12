package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

public class Cipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != 4){
      System.err.println("Error: Incorrect number of parameters.");
      pen.close();
      return;
    }

    String action = null;
    String ciphertype = null;
    String message = null;
    String key = null;
    boolean afound = false;
    boolean cfound = false;
    for (String arg : args){
      if(arg.startsWith("-"))
      {
      
      if(arg.equals("-encode"))
      {
          action = "encode";
          afound = true;
      }
      else if(arg.equals( "-decode"))
      {
          action = "decode";
          afound = true;
      }
      else if(arg.equals("-caesar"))
      {
          ciphertype = "caesar";
          cfound = true;
      }
      else if(arg.equals("-vigenere"))
      {
          ciphertype = "vigenere";
          cfound = true;
      }
    }

      else if (message == null) 
      {
        message = arg;
      } 
      else if (key == null) 
      {
        key = arg;
      }
      else{
        System.err.println("Error: Incorrect number of parameters.");
        pen.close();
        return;
      }
    }

    if (!afound|| !cfound || message == null || key == null){
      System.err.println("Missing parameters");
    }
  
    if (ciphertype.equals("caesar"))
    {
        if (action.equals("encode"))
        {
          String encryptedMessage = CipherUtils.caesarEncrypt(message, key.charAt(0));
          pen.printf("%s\n", encryptedMessage);
          return;
        }
        if (action.equals("decode"))
        {
        String decryptedMessage = CipherUtils.caesarDecrypt(message, key.charAt(0));
        pen.printf("%s\n", decryptedMessage);
        return;
        }
    }

    if (ciphertype.equals("vigenere"))
    {
        if (action.equals("encode"))
      {
        
          String encryptedMessage = CipherUtils.vigenereEncrypt(message, key);
          pen.printf("%s\n", encryptedMessage);
        
      }
      if (action.equals("decode"))
      {
        
          String decryptedMessage = CipherUtils.vigenereDecrypt(message, key);
        pen.printf("%s\n", decryptedMessage);
      
      }
  }
    else 
    {
      System.err.println("Error: Incorrect number of parameters.");
    }

    pen.close();
  }


}

  
