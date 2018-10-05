import java.util.Scanner;

public class ExitEarly
{
  public static void main(String[] args)
  {
    String puppy ="DipStick";
    int count = -1;
    while(count <7)
    {
      count++;
      if (puppy.charAt(count) =="c")
      break;
      System.out.println();
    }
   System.out.println("isn't this puppy a cutie!!");
