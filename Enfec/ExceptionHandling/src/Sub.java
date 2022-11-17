import java.io.FileNotFoundException;

class Super
{
  void show()throws ArithmeticException  { 
    System.out.println("parent class"); 
  }
}

public class Sub extends Super
{
  void show() throws FileNotFoundException
  { 
    System.out.println("child class"); 
  }

  public static void main(String[] args)
  {
    Super s = new Sub();
    s.show();
  }
}
