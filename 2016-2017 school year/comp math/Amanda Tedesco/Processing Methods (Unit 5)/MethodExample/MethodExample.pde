int csize = 10;

void setup()
{
  size(500,500);
  background(100);
}
void draw()
{
  int val = drawACircle(random(0,100),random(0,100));
  println(val);
}
int drawACircle(float xsize,float ysize)
{
 float xrad = random(0,width);
 float yrad = random(0,height);
  fill(random(0,255),random(0,255),random(0,255));
  ellipseMode(CENTER);
  ellipse(xrad,yrad,xsize,ysize);
  return (int)ysize;
}
