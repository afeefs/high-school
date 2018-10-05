import java.util.*;
import java.lang.StringBuilder;
import java.lang.String;
import java.util.Arrays;
class Palindrome 
{ 
 public static boolean isPalindrome(String value) {
	// Scan towards the middle, adjusting the start and end indexes.
	int min = 0;
	int max = value.length() - 1;

	while (true) {
	    if (min > max) {
		return true;
	    }

	    while (!Character.isLetter(value.charAt(min))) {
		min++;
	    }
       //Determinds if the first character is a letter

	    while (!Character.isLetter(value.charAt(max))) {
		max--;
	    }
       //Determinds if last character is a letter

	    char a = Character.toLowerCase(value.charAt(min));
	    char b = Character.toLowerCase(value.charAt(max));
       //Finds the first and last letters of the strings 

	    if (a != b) {
		return false;
	    }
       //If the letters aren't the same
       
	    min++;
	    max--;
	}
    }

  public static String Reverse(String [] lines,String b)
  {
   for( int i = 0; i < lines.length; i++)
   System.out.print(lines[i]+" ");
   
   System.out.println();
   
   StringBuilder a = new StringBuilder();
   StringBuilder a1 = new StringBuilder();
   StringBuilder a2 = new StringBuilder();
   StringBuilder a3 = new StringBuilder();
   StringBuilder a4 = new StringBuilder();
   
   a.append(lines[0]);
   a.reverse();
   a1.append(lines[1]);
   a1.reverse();
   a2.append(lines[2]);
   a2.reverse();
   a3.append(lines[3]);
   a3.reverse();
   a4.append(lines[4]);
   a4.reverse();
    
   System.out.print(a+" ");
   System.out.print(a1+" ");
   System.out.print(a2+" ");
   System.out.print(a3+" ");
   System.out.print(a4+" ");
   
   System.out.println();
     return b;
   }
    public static void main(String[] args) 
    {
    String[] lines = {"radar", "warts", "evil", "racecar", "toot"};
    //String

    System.out.print(Reverse(lines,"The following lines are..."));
    System.out.println();
    //Prints String in reverse
         
	for (String line : lines) {
	    if (isPalindrome(line)) {
		System.out.println("Palindrome:     " + line);
	    } else {
		System.out.println("Not palindrome: " + line);
	    }
     //Palindrome method
	
    }
    }
        
}