import java.util.Scanner;
public class ArrayMethodSum
{
 public static void main(String [] args)
 {
  Scanner key = new Scanner(System.in);
   
  System.out.println("How many numbers do you plan to enter?");
  int arrlength;
  arrlength = key.nextInt();
  //User enters Array length
  
  int [] array = new int[arrlength];  
  System.out.println("Please enter the "+arrlength+" integers:");
  for(int i = 0; i < array.length; i++)
  {
   array[i]=key.nextInt();
  }
  //User enters Array 
  
  System.out.println("The sum of your numbers is " +Sum(array));
  Statistics(array,arrlength,Sum(array));
  
 }
 public static int Sum(int [] array)
 {
  int sum = 0;
  for(int k = 0; k < array.length; k++)
  {
   sum+= array[k];
  } 
  return sum;
 }
 public static void Statistics(int [] array,int arrlength,int sum)
 {
  System.out.println("Statistics:");
  double [] arr= new double[arrlength];
  for(int d = 0; d < arrlength; d++)
  {
   arr[d]= array[d]; 
   System.out.println(arr[d]+ " is " +(arr[d]/sum)*100+ "% of the sum.");
  }
    
} 
}                       