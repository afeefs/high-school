import java.util.Scanner;
public class FavoriteNumber
{
 public static void main(String [] args)
 {
  Scanner key = new Scanner(System.in);
  
  System.out.println("Enter ten intergers.");
  
  int [] num = new int[10];
  for(int a = 0; a < num.length; a++)
  {
   num[a] = key.nextInt();
  }
  //declares and initializes array num
  
  System.out.println("Enter your favorite interger.");
 
  int favorite = key.nextInt();
  
  //allows user to enter favorite interger

  System.out.print("You entered your favorite number "+Favorite(num,favorite)+" times.");
 }
  public static int Favorite(int [] num,int favorite)
  {
   int fav = 0;
   for(int b = 0;b < num.length; b++)
   {
    if(num[b] == favorite)
    fav++;
   }
   return fav;
  }
 
}