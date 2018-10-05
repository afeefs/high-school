
import java.util.Arrays;
import java.util.Scanner;
public class ReverseArray
{
 public static void main(String [] args)
 {
  Scanner keyboard = new Scanner (System.in);
  System.out.println("Enter an interger.");
  
  
  int arrLength = keyboard.nextInt();
  //Allows user to enter array length  
  
  int [] Reverse = new int[arrLength];
  System.out.println("Enter "+arrLength+" values.");
  for(int i = 0; i < Reverse.length; i++)
  {
   Reverse[i]=keyboard.nextInt();
  }
  //Allows user to enter values
  System.out.print("The Array is ");
  for(int a = 0; a<Reverse.length;a++)
  {
  System.out.print(Reverse[a]+" ");
  }
  //Prints Array 
  
  System.out.println();
  
  System.out.print("The Reverse Array is ");
  for(int b = arrLength-1; b>=0; b--)
  {
  System.out.print(Reverse[b]+" ");
  }
  //Prints Array in Reverse Order
  System.out.println();
  
  System.out.print("The Array in Order is ");
  Arrays.sort(Reverse);
  for(int elem:Reverse)
  {
   System.out.print(elem+" ");
  }
  //Prints Array in order
 }
}