import java.util.Scanner;
 
public class TestI0
{
   public static void main(String[] args)
   {
   
    Scanner keyboard = new Scanner(System.in);
    int value = 0;
    do 
    {
        System.out.print("Enter an integer: ");
        value = keyboard.nextInt();
        System.out.println(value + " ");
    }
    while(value != -1);
  }
}