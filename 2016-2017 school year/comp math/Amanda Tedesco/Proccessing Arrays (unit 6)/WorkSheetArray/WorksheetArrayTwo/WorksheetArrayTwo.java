public class WorksheetArrayTwo
{
 public static void main(String [] args)
 {
 
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