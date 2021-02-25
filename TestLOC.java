import org.junit.Test;
import static org.junit.Assert.*;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class TestLOC
{
  @Test
  public static void testCountingPhysicalLines() throws IOException
  {
    FileReader fr = new FileReader("ProgramaA1.java");
    int pl = LOC.toCountPhysicalLines(fr);
    assertEquals(302, pl); 
    JOptionPane.showMessageDialog
    (
      null, "TEST PASSED!\nExpected value: 302\n" +
      "Result received: " + pl,
      "Counting Physcal Lines Result",
      JOptionPane.INFORMATION_MESSAGE
    );
  }
  @Test
  public static void testCountingLogicalLines() throws IOException
  {
    int pl = LOC.toCountLogicalLines();
    assertEquals(98, pl); 
    JOptionPane.showMessageDialog
    (
      null, "TEST PASSED!\nExpected value: 98\n" +
      "Result received: " + pl,
      "Counting Logical Lines Result",
      JOptionPane.INFORMATION_MESSAGE
    );
  }
  public static void main(String[] args) throws IOException
  {
    testCountingPhysicalLines();
    testCountingLogicalLines();
  }
}