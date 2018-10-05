public class TestMethodsAndArrays
{
public static void main(String[] args)
{
int [] array = {4,5,7,3,8,9};
 System.out.println( find_sum(array) );
 String [] food = {"banana", "pizza", "orange", "crackers", "orange", "chip", "soda"};
 System.out.println( find_orange( food));
 System.out.print(food.length);
 
 
}
public static int find_orange(String[] items)
{
int key = 0;
for(int i = 0; i < items.length;i++)
 if(items[i].equals("orange"))
  key++;
  
  return key;
 }

public static int find_sum(int [] values)
{
 int total = 0;
 for(int i = 0; i <values.length; i++)
    total+= values[i];
    
   return total;
 }
}