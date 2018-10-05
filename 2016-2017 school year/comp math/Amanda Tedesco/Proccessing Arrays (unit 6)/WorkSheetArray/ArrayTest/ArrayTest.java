public class ArrayTest
{
 public static void main(String [] args)
 {
  int [] arrA; //declares an array
  int arrB[]; //option Two to declare an array
  double [] arrC;
  //declares three different arrays
 
  double arrD[] = {3.0,4.5,4.2,7.5}; //declares and initiates 4 values for D
  //initializing...
  
  arrA = new int[10];
  arrB = new int[10];
  arrC = new double[10];
  
  for(int i = 0; i<10; i++)
  {
    arrA[i] = 0;
    arrB[i] = i;
    arrC[i] = i*2.0;
  }
  
  for(int i = 0; i < arrA.length; i++)
  System.out.print(" " +arrC[i]);
  
  /**************************************/
  //this is problem #2 on worksheet-Arrays
  
  System.out.println();
  double [] finalGrade = {85.8, 93.7, 76, 88.5, 100, 91.3};
  double sum = 0.0;
  double total = 0.0;
  for (int i = 0; i < finalGrade.length; i++)
  {
    sum += finalGrade[i];
    total += 1.0;
  }
  System.out.println("The average is " +sum/total);
  }
 }