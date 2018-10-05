float a = 0;


void setup()
{
  size(500,500);
  ellipseMode(CENTER);
 frameRate(500);
}
void draw()
{
  background(0);
  
  a = a+ .01;
  
  translate(width/2,height/2);
  scale(a);
  fill(255);
  ellipse(0,0,50,50);
  println("radius");
}

