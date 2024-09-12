package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
  
    if(args.length == 0){
      System.err.println("Error: Incorrect number of parameters.");
      return;
    }
    
    if(args.length > 2 || args.length < 2){
      if (args[0].equals(""))
    {
      for (char ch = 'a'; ch <= 'z'; ch++) 
      {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt("", ch));
      }
      return;
    }
      System.err.println("Error: Incorrect number of parameters.");
      return;
    }
    String str = args[1];
    String de = args[0];
    if ((!de.equals("decode")) && (!de.equals("encode"))) 
    {
      System.err.println("Invalid option: " + de + ". Valid options are \"encode\" or \"decode\"");
      return;
    }
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
      pen.close();
  }
}
