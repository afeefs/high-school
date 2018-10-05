public class WorkSheetArraysThree
{
 public static void main(String [] args)
 {  
  int[] Random = new int[10];
  Random[0] = (int)(Math.random()*10);
  Random[1] = (int)(Math.random()*10);
  Random[2] = (int)(Math.random()*10);
  Random[4] = (int)(Math.random()*10);
  Random[5] = (int)(Math.random()*10);
  Random[6] = (int)(Math.random()*10);
  Random[7] = (int)(Math.random()*10);
  Random[8] = (int)(Math.random()*10);
  Random[9] = (int)(Math.random()*10);
    
  for(int a = 0; a < Random.length; a++)
  {
   System.out.print(Random[a]);
  }
  
  System.out.println();
  
  for(int b = Random.length-1; b >=0; b--)
  {
   System.out.print(Random[b]);
  }
   
   System.out.println();
   System.out.println(Even(Random));
}
 public static int Even(int [] Random)
 {
  int even = 0;
  for(int c = 0; c < Random.length; c++)
  {
   if(Random[c]%2==0)
   even++;
  }
 return even;
 }
} 

  