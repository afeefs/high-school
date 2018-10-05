
public class BinarySearch 
{
  public static void main(String args[])
  {
    int [] Bin = {11,16,22,23,34,46,48,50,75,78};
    System.out.println(Search(Bin, 0,9,46));
   
  }
public static int Search(int [] Bin, int low, int high, int key)
{
 int comparisonCount = 1;
 int middle = (low + high)/2;
  while((Bin[middle] != key) && (low <= high))
     {
         comparisonCount++;
         if (Bin[middle] > key)             
         {                                              
              high = middle - 1;   
         }                                                             
              else                                                   
        {                                                        
              low = middle + 1;     
        }
       middle = (low + high) / 2;
     }
     if (low <= high)
     {
           System.out.println(key+" was found in array subscript " + middle);
           System.out.println("The binary search found the number after " + comparisonCount +
                 "comparisons.");
           // printing the number of comparisons
     }
     else
          System.out.println("Sorry, the number is not in this array.  The binary search made "
                 +comparisonCount  + " comparisons.");
                 
         System.out.print("The array length is ");
  return Bin.length;
}
 

}