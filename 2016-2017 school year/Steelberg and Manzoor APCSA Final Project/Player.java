/**
Charles Steelberg
Morgan Petrie
Afeeah Manzoor 

APCSA Final Project
*/
public abstract class Player implements Movement{
   public abstract void move(int dir, boolean isJumping);
   public abstract boolean jump();
   public abstract boolean getTeam(); 
}