void setup()
{
 
  size(500,500);
  strokeWeight(50);
}
void draw()
{
  line(100,100,100,400);
  line(400,100,400,400);
 
}
void keyPressed()
{
  background(255);
 if((keyCode=='M'))
  {
    line(100,100,250,250);
    line(250,250,400,100);
  }
 else if((keyCode=='A'))
  {
    line(100,100,400,100);
    line(100,250,400,250);
  }
 else if((keyCode=='O'))
  {
    line(100,100,400,100);
    line(100,400,400,400);
  }
}
