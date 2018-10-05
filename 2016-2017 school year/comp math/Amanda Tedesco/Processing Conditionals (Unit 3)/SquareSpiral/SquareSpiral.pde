float direction = 1;
float x = 250; 
float px = 250; 
float py = 250;
float y = 245;
float z = 10;
float distance = 1;

void setup()
{
  size(500,500);
  background(#B219DE);
  x = width/2;
  y = height/2;
  px = x;
  py = y;
  x = x+ distance;
  strokeWeight(5);
}
void draw()
{
  px = x;
  py = y;
  distance = distance +5;
    
  if(direction == 1)
  {
   y = y-distance;
   direction = 2;
  }
  else if(direction == 2)
  {
   x = x - distance;
   direction = 3;
  }
  else if(direction == 3)
  {
    y = y + distance;
    direction = 4;
  }
  else if(direction == 4)
  {
    x = x + distance;
    direction = 1;
  }
 
    line(x,y,px,py);
    //beginner line
}
