/*  This lab is to teach you about writing and using methods, 
 *  especially methods that return values.
 *  You will need to complete the code for the distance, slope and midpoint
 *  methods. Pay attention to the values passed to the methods and what 
 *  should be returned
 *
 *  Your Name
 *  Date
 */
 

float x1 = -150;
float y1 = 214;

float x2 = 200.0;
float y2 = 200.0;

int graphStep = 10;
int winSize; 


void setup() {
  winSize = (int) largestNum(x1, y1, x2, y2);
  winSize /= 10;
  winSize++;
  winSize *= 10;
  winSize *= 2;

  size(winSize + 400, winSize);  // add some extra room on the right to fit the dist,mid,slope info
}

void draw() {
  background(255);
  stroke(0);

  x2 = mouseX - winSize/2;         // Unlike (x1, y1), you DON'T want to translate x2 from mouseX
  y2 = -1 * (mouseY - winSize/2);  // Don't translate y2, but you still need to invert it, since the signs of the y-axis are still flipped.      
  
  pushMatrix();

  translate(winSize/2, winSize/2);    // translate so that the point (0,0) is in the center

  strokeWeight(3);
  stroke(0);
  line(-winSize/2, 0, winSize/2, 0);    // draws x-axis
  line(0, -winSize/2, 0, winSize/2);    // draws y-axis

  strokeWeight(.1);
  stroke(0);

  for (int i = -winSize/2; i <= winSize/2; i+= graphStep )
  {
    line(-winSize/2, i, winSize/2, i);
    line(i, -winSize/2, i, winSize/2);
  }

  strokeWeight(1);
  line(x1, -y1, x2, -y2);  // draws the line from position x1, y1 to the mouse position
  
  fill(0);        // Black colored text
  textSize(20);   // Size of font is 20
  text("Points: (" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + ")", (int) (winSize/2 + 5), -winSize/2 + 50);
  //text("Distance: " + distance(x1, y1, x2, y2), (int) (winSize/2 + 5), -winSize/2 + 100 );
  text("Slope: " + slope(x1, y1, x2, y2), (int) (winSize/2 + 5), -winSize/2 + 150 );
 //  text("Midpoint: " + midpoint(x1, y1, x2, y2), (int) (winSize/2 + 5), -winSize/2 + 200 );

  popMatrix();
}

float largestNum (float a, float b, float c, float d)
{
  // find the largest number a, b, c, or d
  //  and return that number
  float largest = abs(a);
  if (largest < abs(b)) largest = abs(b);
  if (largest < abs(c)) largest = abs(c);
  if (largest < abs(d)) largest = abs(d);
  return largest;
}

/* Write the distance method. Look at the call to the distance method 
 * which is defined in the draw method
 * @param x1: x value of the first point
 * @param y1: y value of the first point
 * @param x2: x value of the second point
 * @param y2: y value of the second point
 * @return dist - the distance between (x1, y1) and (x2, y2)
 */
 
 float distance(float x1,float x2, float y1, float y2)
 {
   float d = sqrt(pow(x2-x1))-(pow(y2-y1));
   return d;
 }
  // Code goes here: calculate the distance between (x1, y1) and (x2, y2)
  // return the distance value



/* Write the slope method. Look at the call to the slope method 
 * which is defined in the draw method
 * @param x1: x value of the first point
 * @param y1: y value of the first point
 * @param x2: x value of the second point
 * @param y2: y value of the second point
 * @return slp - the slope between (x1, y1) and (x2, y2)
 */
 
 float slope(float x1,float y1,float x2, float y2)
 {
   float z = (y2-y1)/(x2-x1);
   return z;
 }
  // Code goes here: calculate the slope of the line that goes
  //    through the points: (x1, y1) and (x2, y2)
  // return the slope value


/* Write the midpoint method. Look at the call to the midpoint method 
 * which is defined in the draw method
 * @param x1: x value of the first point
 * @param y1: y value of the first point
 * @param x2: x value of the second point
 * @param y2: y value of the second point
 * @return stringMidpoint - the midpoint between (x1, y1) and (x2, y2)
 */

  // Code goes here: calculate the average of x1 and x2, which 
  //   is the x-value of your midpoint. Then calculate the average
  //   of y1 and y2 which is the y-value of your midpoint.
  //   concatenate and build a string for each value and
  //   return a string. Ex:  ( 45.6, -56.2)  
  //   See Unit 2 for String concatenation hints

