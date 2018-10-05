/**
Mariam Ansari
Due Date: 11/05/2016
Course/Section: IT 106.009
Assignment: Programming Assignment 6
Description: This java program will allow the user to purchase up to 29 houses. The user will first be asked 
how many houses they would like to purchase. Then they will be allowed to pick what houses they would like
would to buy and it can either be a cottage, victorian, tudor revival or a mansion. If anything other than those
home type options are entered the user will be given an error message and will be reprompted to enter the correct 
house type option that is offered by IT Estates. Each house type that is selected will be incremented and will be added to the total costs.
After the user has chose the amount of houses they want and what type of houses they want a message will appear showing
the type of homes that were chosen and the costs of each of the homes. The total costs of the homes will also be displayed
and the average costs of all the homes, this will be done by dividing the total costs by the amount houses that 
were purchased.*/
//Inputs: The user will input the amount of houses they want as well as the type of home(s) they would like to purchase.
//**Outputs: The receipt(message), displaying the type of homes, the costs of the homes, the total costs of all the homes and the average costs of all the homes combined.*/
import javax.swing.JOptionPane;

public class ITEstates {
	public static void main (String[] args) {
      //array for the 4 types of home
      String[] homeTypeArray = new String []{"Cottage", "Victorian", "Tudor Revival", "Mansion"};
      
      //array for the costs of the homes
      double[] homeCostsArray = new double []{99955, 423699, 777399, 1025999};
      //cottage counter
      int cottage = 0;
      //victorian counter
      int victorian = 0;
      //tudor revival counter
      int tudorRevival = 0;
      //mansion counter
      int mansion = 0;
      int houseNum;
      //total costs of all the houses
      double totalCosts = 0.00;
      //types of houses
      //array values
            //price of cottage    
      
      //price of victorian
   
      //sets how many houses you want to build
      //try catch used to make sure that the value that is entered is numeric.
      try {
         houseNum = Integer.parseInt(JOptionPane.showInputDialog ("How many  houses do you want to build?"));
      }
      catch (NumberFormatException e) {
         houseNum = -1;
         JOptionPane.showMessageDialog(null, "ERROR! You cannot enter a letter");
      }
      while (houseNum < 0 || houseNum >= 29) {
         try {
         houseNum = Integer.parseInt(JOptionPane.showInputDialog ("How many  houses do you want to build?"));
            if (houseNum < 0 || houseNum >= 29) {
               JOptionPane.showMessageDialog(null, "ERROR! Enter valid number of houses. No more than 29");
            }
      }
      catch (NumberFormatException e) {
         houseNum = -1;
         JOptionPane.showMessageDialog(null, "ERROR! You cannot enter a letter");
         }
      }
     
      //houses must be more than zero or less than 30
      if ((houseNum < 0 || 
      houseNum > 29))
         //Display error message
         JOptionPane.showMessageDialog(null, "ERROR! Enter valid number of houses. No more than 29");
      //sets the array to 29 houses you can build
      String[] houseInputArray = new String [29];
      //value for the while loop
      int houseNum1 = houseNum;
      //incrementing value for the value in houseInputArray
      int houseNum2 = 0;
      //loops for each house
      while(houseNum1 > 0) 
      {        
         //asking the user what type of house they want can be either cottage, victorian, tudor revival, or mansion
         String houseType = JOptionPane.showInputDialog("What type of house do you want? Cottage, Victorian, Tudor Revival, or Mansion.");
         //if anything other than these options are entered an error will occur
         ////user can enter "cottage" with capital or lower case letters
          if ((!(houseType.equalsIgnoreCase("cottage"))) &&
          //user can enter "victorian" with capital or lower case letters
          (!(houseType.equalsIgnoreCase("victorian"))) &&
          //user can enter "tudor revival" with capital or lower case letters
          (!(houseType.equalsIgnoreCase("tudor revival"))) &&
          //user can enter "mansion" with capital or lower case letters
          (!(houseType.equalsIgnoreCase("mansion"))))
                 
         {  
            //displays error message if not the correct house type
            JOptionPane.showMessageDialog(null, "ERROR! Enter valid house type");
         }
         
         else {   
                  //loop to set each array value and find the total costs
                  for(int y=0; y < 1; y++)
                  {
                  //decrements the value
                  houseNum1 --;
                  //if the house is a cottage the actions below will occur
                  if(houseType.equalsIgnoreCase("cottage"))
                  {
                     //incrementing cottage houses
                     cottage ++;
                     //adding the home costs to the total costs
                     totalCosts += homeCostsArray[0];
                     //sets array for value in the houses sold
                     houseInputArray[houseNum2] = "Cottage";
                  }
                  //if the house is a victorian the actions below will occur
                  else if(houseType.equalsIgnoreCase("victorian"))
                  {  
                     //incrementing victorian houses
                     victorian ++;
                     //adding the home costs to the total costs
                     totalCosts += homeCostsArray[1];
                     //sets array for value in the houses sold
                     houseInputArray[houseNum2] = "Victorian";
                  }
                  //if the house is a tudor revival the actions below will occur
                  else if(houseType.equalsIgnoreCase("tudor revival"))
                  {
                     //incrementing tudor revival houses
                     tudorRevival ++;
                     //adding the home costs to the total costs
                     totalCosts += homeCostsArray[2];
                     //sets array for value in the houses sold
                     houseInputArray[houseNum2] = "Tudor Revival";
                  }
                  //if the house is a mansion the actions below will occur
                  else if(houseType.equalsIgnoreCase("mansion"))
                  {
                     //incrementing mansion houses
                     mansion ++;
                     //adding the home costs to the total costs
                     totalCosts += homeCostsArray[3];
                     //sets array for value in the houses sold
                     houseInputArray[houseNum2] = "Mansion";
                  }
                  //incrementing the value in the array
                  houseNum2++;
                } 
            }
      }
        
        double avgHomeCost = totalCosts/houseNum;
        
        String message = "IT Estates Summary \n" +
            homeTypeArray[0] +" $" + String.format("%.2f",homeCostsArray[0]) + "\n" +
            homeTypeArray[1] +" $" + String.format("%.2f",homeCostsArray[1]) + "\n" +
   	      homeTypeArray[2] +" $" + String.format("%.2f",homeCostsArray[2]) + "\n" +
      		homeTypeArray[3] +" $" + String.format("%.2f",homeCostsArray[3]) + "\n" +
            "Cottages Sold: " + cottage + "\n" +
		      "Victorian Sold: " + victorian + "\n" +
		      "Tudor Revival Sold: " + tudorRevival + "\n" +
		      "Mansions Sold: " + mansion + "\n" +
		      "Total Cost: $" + String.format("%.2f",totalCosts) + "\n" +
		      "Average Cost: $" + String.format("%.2f",avgHomeCost);
       JOptionPane.showMessageDialog(null, message);
   }      
 }
 
 