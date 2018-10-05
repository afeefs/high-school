import java.util.Arrays;
import java.util.Scanner;
public class SortSearch1
{
   public static void main(String [] args)
   {
    int c, n, findval, array[];
 
    Scanner key = new Scanner(System.in);
    System.out.println("Enter number of elements");
    n = key.nextInt(); 
    array = new int[n];
 
    System.out.println("Enter " + n + " integers");
 
    for (c = 0; c < n; c++)
      array[c] = key.nextInt();
 
    System.out.println("Enter value to find");
    findval = key.nextInt();
 
    for (c = 0; c < n; c++)
    {
      if (array[c] == findval)     /* Searching element is present */
      {
         System.out.println(findval + " is present at location " + (c + 1) + ".");
          break;
      }
   }
   if (c == n)  /* Searching element is absent */
      System.out.println(-1);
  }
}   