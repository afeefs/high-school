import java.util.Scanner;
public class WorkWithNumsOne
{
 public static void main(String [] args)
 {
  Scanner Key = new Scanner(System.in);  
  double [] arrNum = new double[10];
  
  for(int i = 0; i < arrNum.length; i++)
  {
   arrNum[i]=Key.nextDouble();
  }
  int x = 0;
  int y = 9;
  System.out.println(arrNum[x]);
  //Answer to number 2
  
  System.out.println(arrNum[y]);
  //Answer to number 3
  
  Print_It(arrNum);
 System.out.println("The average of arrNum is "+Average(arrNum));
  

 }
 public static void Print_It(double [] values)
 {
  double b = 0;
  for(int i = 0; i<=9;i++)
  { 
    b++;
    System.out.println("Array number in position number " +b+ " is " +values[i]);
  }
 }
 public static double Average(double [] values)
 {
  double c = 0;
  for(int k = 0; k<=9; k++)
  {
   c += values[k];
  }
  double f = c/10;
  return f;
 }
}
 

