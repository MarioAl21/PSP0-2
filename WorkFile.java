import java.io.File;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class WorkFile
{
  static String getFileName() 
  { 
    String file_name = JOptionPane.showInputDialog
	       	       (
                 	 null, 
		 	 "Enter the file name to work with\n" + 
			 "Remember add the extension (recommended): .txt, .java, .cpp for example", 
			 "Enter file name", 
			 JOptionPane.QUESTION_MESSAGE
	     	       );  
    return file_name; 
  }
  static void readFile(String fn)
  {
    try
    {
      File f = new File(fn);
      Scanner scan = new Scanner(f);
      float numf = 0.0f;
      int numi = 0;
      String file_content = ""; 

      while(scan.hasNext())
        file_content += scan.next() + "\n";  
         
      JOptionPane.showMessageDialog
      (
        null,
        file_content,
        "File's content",
        JOptionPane.INFORMATION_MESSAGE 
      );   
    }
    catch(FileNotFoundException e)
    {
      if(fn != null)
      JOptionPane.showMessageDialog
      (
        null,
        e.getMessage(),
        "File not founded",
        JOptionPane.WARNING_MESSAGE
      );
      else
      {
        e = new FileNotFoundException("Null"); 
        JOptionPane.showMessageDialog
        (
          null,
          e.getMessage(),
          "File not founded",
          JOptionPane.WARNING_MESSAGE
        );
      } 
    }
    catch(NullPointerException e)
    {
      JOptionPane.showMessageDialog
      (
        null,
        e.getMessage(),
        "File not founded",
        JOptionPane.WARNING_MESSAGE
      ); 
    }
  } 
  static void writeFile(String fn) 
  {
    try
    {
      float number = 0.0f;
      String op = "";
      int n = 0; 
      int size = 0;

      File f = new File(fn);
      FileWriter fw = null; 

      if(f.exists())
      {
        op = JOptionPane.showInputDialog
             (
               null,
               "A file with this name already exists\n" +
               "Do you want to update it(u) o rewrite it(r)",
               "Check File Existence", 
               JOptionPane.WARNING_MESSAGE 
             );
        op = op.toLowerCase(); 
       
        if(op.equals("u"))
          fw = new FileWriter(f, true);
        else if(op.equals("r"))
          fw = new FileWriter(f);
        else
        {
          JOptionPane.showMessageDialog
          (
            null,
            "Default option choosen (update)",
            "Default option",
            JOptionPane.PLAIN_MESSAGE 
          );
          fw = new FileWriter(f, true);
        } 
      } 
      else
        fw = new FileWriter(f);

      PrintWriter pw = new PrintWriter(fw);

      size = Integer.parseInt
	         (
                   JOptionPane.showInputDialog
                   (
                     null, 
	   	     "How many numbers do you want to insert?",
		     "Insert size",
		     JOptionPane.QUESTION_MESSAGE	 
                   )
                 );
           
      while(size > 0)
      {
        number = Float.parseFloat
	         (
                   JOptionPane.showInputDialog
                   (
                     null, 
	   	     "Insert the " + (size - (size - 1)) + "th number",
		     "Insert number",
		     JOptionPane.INFORMATION_MESSAGE	 
                   )
                 );

        pw.print(number);
        if((size / 5) == 0)
          pw.print("\r\n");

        size --;
      }
    
      pw.close();
      fw.close(); 
    }
    catch(NumberFormatException e)
    {
      JOptionPane.showMessageDialog
      (
        null,
        "Error " + e.getMessage() + "\nNumber was expected",
        "Number expected",
        JOptionPane.ERROR_MESSAGE 
      ); 
    }
    catch(IOException e)
    { 
      JOptionPane.showMessageDialog
      (
        null,
        "Invalid File\n" +
	"skip blanks (recommended)",
        "File's problem",
        JOptionPane.WARNING_MESSAGE 
      );  
    }
     
  }   

}