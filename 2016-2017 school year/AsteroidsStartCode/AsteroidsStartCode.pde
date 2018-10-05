/* Name: Ms. Carlson
 * Date: September 12, 2015
 * Description: This is the asteroids game */
 
 // variables here
 
 public void setup()
 {
   size(1000, 600);
   
 }
 
 public void draw()
 {
   
 }
 
 
 public class SpaceShip // extends Floater
 {
   
 }
 
 // do NOT modify the Floater class! Make changes in the SpaceShip class
 public abstract class Floater
 {
   protected int corners; // the # of corners, a triangular floater has 3
   protected int[] xCorners;
   protected int[] yCorners;
   protected int myColor;
   protected double myCenterX, myCenterY; // holds center coordinates
   protected double myDirectionX, myDirectionY; // holds x and y coordinates of the vector for direction
   // of travel
   protected double myPointDirection; // holds current direction the ship is pointing in degrees
   
   public void setX(int x) {  myCenterX = x; }
   public int getX() { return (int) myCenterX; }
   public void setY(int y) { myCenterY = y; }
   public int getY() { return (int)myCenterY; }
   public void setDirectionX(double x) { myDirectionX = x; }
   public double getDirectionX() { return myDirectionX; }
   public void setDirectionY(double y) { myDirectionY = y; }
   public double getDirectionY() { return myDirectionY; }
   public void setPointDirection(int pdir) {myPointDirection = pdir; }
   public double getPointDirection() { return myPointDirection; }
   public void setColor(color c) { myColor = c; }
   public color getColor() { return myColor; }
   public void setCornerX(int [] corX) { xCorners = corX; }
   public int[] getCornerX() { return xCorners; }
   public void setCornerY(int [] corY) { yCorners = corY; }
   public int[] getCornerY() { return yCorners; }
   public void setCorners(int corn) { corners = corn; }
   public int getCorners() { return corners; }
   
   // Accelerates the floater in the direction it is pointing (myPointDirection)
   public void accelerate(double dAmount)
   {
     // converts the current direction the floater is pointing to radians
     double dRadians = myPointDirection*(Math.PI/180);
     
     // change coordinates of direction of travel
     myDirectionX += ((dAmount)*Math.cos(dRadians));
   }

   public void rotate(int nDegreesOfRotation)
   {
     // rotates the floater by a given number of degrees
     myPointDirection += nDegreesOfRotation;
   }

   public void move()  // move the floater in the current direction of travel
   {
     // change the x and y coordinates by myDirectionX and myDirectionY
     myCenterX += myDirectionX;
     myCenterY += myDirectionY;
     
     // wrap around the screen
     if (myCenterX > width)
     {
       myCenterX = 0;
     }
     else if (myCenterX < 0)
     {
       myCenterX = width;
     }
     
     if (myCenterY > height)
     {
       myCenterY = 0;
     }
     else if (myCenterY < 0)
     {
       myCenterY = height;
     }
   }
   
   public abstract void show();  // Draws the floater at the current position
   
   /* below is code that might help you for the show method in subclasses...
      You canNOT place this code in this abstract class
     fill(myColor);
     stroke(myColor);
     
     // convert degrees to radians for sin and cos
     double dRadians = myPointDirection*(Math.PI/180);
     int xRotatedTranslated, yRotatedTranslated;
     
     beginShape();
     for (int nl = 0; nl < corners; nl++)
     {
       // rotate and translate the coordinates of the floater using current direction
       xRotatedTranslated = (int)((xCorners[nl]*Math.cos(dRadians)) - (yCorners[nl] * Math.sin(dRadians)) + myCenterX);
       yRotatedTranslated = (int)((xCorners[nl]*Math.sin(dRadians)) + (yCorners[nl] * Math.cos(dRadians)) + myCenterY);
       vertex(xRotatedTranslated, yRotatedTranslated);
     }
     endShape(CLOSE);
  */
  
 }
     
   
