int globalX = 250;
int globalY = 250;
int speed = 10;
void setup()
{
  size(500,500);
  smooth();
}
void draw()
{
  background(0);
  move();
  bounce();
  drawCar(globalX,globalY,50,color(#EA00DF));
}
void move()
{
  globalX +=speed;

}
void bounce()
{
  if ((globalX > width) || (globalX < 0))
  {
    speed = speed * -1;
  }
}
void drawCar(int x, int y, int thesize, color c)
{
  int offset = thesize/4;
  ellipseMode(CENTER);
  stroke(200);
  fill(c);
  ellipse(x,y,thesize,thesize);
}
  
