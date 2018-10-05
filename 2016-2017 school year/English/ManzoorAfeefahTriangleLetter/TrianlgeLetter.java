import javax.swing.JOptionPane;
/*
Afeefah Manzoor
Period: 6
Triangle Letter 4
*/
public class TrianlgeLetter
{
   public static void main(String[] args)
   {
       //asks for rows
       int numOfLet = Integer.parseInt(JOptionPane.showInputDialog("How many rows do you want?"));
       //asks for letter
       String letter = JOptionPane.showInputDialog("What letter would you like to use?");
       //loop for rows
       for (int i = 0; i < numOfLet; i++)
       {   //loop for space
          for (int x = 0; x < i; x++)     
              System.out.print(" ");
           //loop for letter
          for (int x = i; x < numOfLet; x++)     
              System.out.print(letter);
          //moves to next line
         System.out.println();
      }
   }
}