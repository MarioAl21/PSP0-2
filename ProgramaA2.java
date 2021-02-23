import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ProgramaA2
{
  static int options()
  {
    int option = 0;

    while(option != 1 && option != 2 && option != 3)
    {
      try
      {
        option = Integer.parseInt
                 (
    	           JOptionPane.showInputDialog
                   ( 
		     null,
		     "1. Read File\n" +
		     "2. Write File\n" +
                     "3. Exit\n",
		     "File's tasks",
		     JOptionPane.PLAIN_MESSAGE	 
	  	   )                   
                 );

        if(option != 1 && option != 2 && option != 3)
          JOptionPane.showMessageDialog
          (
            null,
            "Option 1 or 2 expected instead of " + option,
            "File's problem",
            JOptionPane.WARNING_MESSAGE 
          );
      }
      catch(NumberFormatException e)
      {
        JOptionPane.showMessageDialog
        (
          null,
          "Option 1 or 2 expected instead of " + option,
          "Invalid option",
          JOptionPane.WARNING_MESSAGE 
        );  
      }
      catch(NullPointerException e)
      {
        JOptionPane.showMessageDialog
        (
          null,
          "No file provided",
          "No file provided",
          JOptionPane.WARNING_MESSAGE 
        );  
      }
       
    }
    

    return option;
    	
  }
  static void menu()
  { 
    String file = "";
    int option = 0;
    String yes_no_option = "y";
    
    do
    {
      file = WorkFile.getFileName();
      option = options();

      switch(option)
      {
        case 1:
          WorkFile.readFile(file);
        break;
	case 2: 
          WorkFile.writeFile(file);
	break;
        case 3:
          yes_no_option = JOptionPane.showInputDialog
          (
            null,
            "Are you sure you want to exit (y)yes (n)no",
            "Exit",
            JOptionPane.WARNING_MESSAGE 
          );
          yes_no_option = yes_no_option.toLowerCase();
          if(yes_no_option.equals("y"))
            JOptionPane.showMessageDialog
            (
              null,
              "Bye ;)",
              "Exit successful",
              JOptionPane.INFORMATION_MESSAGE 
            );
          else if(!yes_no_option.equals("n"))
          {
            JOptionPane.showMessageDialog
            (
              null,
              "Default option (no)",
              "Exit successful",
              JOptionPane.INFORMATION_MESSAGE 
            );
            yes_no_option = "n";  
            option = 1;
          }
          else
            option = 1;               
        break;
      } 
      
    }while((option == 1 || option == 2) && yes_no_option.equals("n"));
  }

  public static void main(String[] args)
  {
     menu();
  }        
}