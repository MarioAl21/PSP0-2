import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.regex.*; 

public class LOC
{
  public static int toCountPhysicalLines(FileReader fr) throws IOException
  {
    int physical_lines = 0;
    BufferedReader br = new BufferedReader(fr);
    String line = br.readLine();
    PrintStream ps = new PrintStream("PhysicalLines.txt");      
    Scanner scan = null;

    while(line != null)
    { 
      scan = new Scanner(line);
      if(scan.hasNext())
      {
        ps.println(line);
	physical_lines ++;
      }
      line = br.readLine();
    }
 	
    ps.println("-----Lines#: " + physical_lines + " -----");

    ps.close();   
    scan.close();
    br.close();

    return physical_lines; 
  }
  public static int toCountLogicalLines() throws IOException
  {
    int logical_lines = 0;
    FileReader to_fr = new FileReader("PhysicalLines.txt"); 
    BufferedReader br = new BufferedReader(to_fr);
    Scanner scan = null;
    int last_character = 0; 
    boolean b = false;
    String line = br.readLine(), last_segment = "";  
    
    FileWriter fw = new FileWriter("logical_lines.txt"); 
    PrintWriter ps = new PrintWriter(fw);


    while(line != null)
    {   
      scan = new Scanner(line); 
      
      while(scan.hasNext())
        last_segment = scan.next();
          

      last_character = last_segment.length() - 1; 

      if(last_segment.charAt(last_character) == ';')
      { 
        logical_lines ++;
        ps.println(line);
        ps.println("-----" + logical_lines + "-------");
      }

      line = br.readLine();      
    }

    ps.println("\r\n-----Lines#: " + logical_lines + " -----");

    ps.close(); 
    fw.close(); 
    to_fr.close(); 
    
    return logical_lines;  
  }
  public static Object fileExtension()
  {
    Object[] possibleValues = { 
		                ".txt", ".java", ".cpp", ".c", ".py", 
                                ".js", ".html", ".css", ".tcl", ".lg",
                                "" 
                              };
    Object selected_value = JOptionPane.showInputDialog
			    (
			      null,
    			      "Choose an extension", "Input",
    			      JOptionPane.INFORMATION_MESSAGE, null,
    			      possibleValues, possibleValues[0]
			    );

    return selected_value;
  }
  public static void openFile()
  {
    int nums_of_linesl = 0, nums_of_linesp = 0; 
    String file_name = "", regex = "[.][a-zA-Z]{2,20}";
    FileReader filer = null;
    Pattern pattern = Pattern.compile(regex);
    Matcher match = null;
    boolean format = true;

    try
    {
      file_name = JOptionPane.showInputDialog
      		  (
        	    null,
        	    "Enter the file to read",
        	    "Read File",
        	    JOptionPane.PLAIN_MESSAGE
      		  );

      match = pattern.matcher(file_name);  
      format = match.find();
 
      if(!format)
        file_name += fileExtension(); 

      filer = new FileReader(file_name);
      nums_of_linesp = toCountPhysicalLines(filer);
      nums_of_linesl = toCountLogicalLines();

      JOptionPane.showMessageDialog
      		  (
        	    null,
        	    "Logical lines: " + nums_of_linesl + 
                    "\nPhysical lines: " + nums_of_linesp,
        	    "Number of lines",
        	    JOptionPane.INFORMATION_MESSAGE
      		  );

    }
    catch(FileNotFoundException e) 
    {
      JOptionPane.showMessageDialog
      (
        null,
        e.getMessage(),
        "File not founded",
        JOptionPane.ERROR_MESSAGE 
      );
    }
    catch(IOException e) 
    {
      JOptionPane.showMessageDialog
      (
        null,
        e.getMessage(),
        "There a problem with the File",
        JOptionPane.ERROR_MESSAGE 
      );
    }
    catch(NullPointerException e) 
    {
      JOptionPane.showMessageDialog
      (
        null,
        e.getMessage(),
        "No File provided",
        JOptionPane.ERROR_MESSAGE 
      );
    }
    
  }

  public static void main(String[] args)
  {
    String op = "";

    while(true)
    {
      openFile();
      op = JOptionPane.showInputDialog
          (
            null,
            "Read another file (y)yes (n)no",
            "Repeat",
            JOptionPane.QUESTION_MESSAGE
          );
      op = op.toLowerCase();
      if(op.equals("n"))
      {
        JOptionPane.showMessageDialog
          (
            null,
            "See ya later ;)",
            "Exit successful",
            JOptionPane.INFORMATION_MESSAGE
          );
        break;
      }
      else if(!op.equals("n") && !op.equals("y"))
        JOptionPane.showMessageDialog
          (
            null,
            "Default option (y)",
            "Repeat",
            JOptionPane.INFORMATION_MESSAGE
          ); 
    }
  
  }
}