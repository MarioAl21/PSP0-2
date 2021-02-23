public class List
{
  // First in the List
  Node head;
  // Methods
  Node getHead()
  { return head; }
  boolean emptyList()
  {
    if(head == null)
      return true;
    return false;
  }
  void insertEnd(float data)
  {
    Node last = new Node();
    last.item = data;
    if(emptyList())
      head = last;
    else
    {
      Node runner = head;
      while(runner.next != null)
        runner = runner.next;
      runner.next = last;
    }
  }
  void printItems()
  {
    Node runner = head;
    while(runner != null)
    {
      System.out.print(runner.item + " ");
      runner = runner.next;
    }  
  }
 
}