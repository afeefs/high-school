void setup()
{
  size(400,200);
  smooth();
}
void draw()
{
  background(0);
  int y = height/2;
  for(int x = 80; x < width; x+=80)
  {
    drawZoog(x,100,60,60,16);
  }
}
void drawZoog(int x, int y, int w, int h, int eyesize)
{
  rect(x,y,w/6,h*2);
  ellipse(x,y-h/2,w,h);
  ellipse(x-w/3,y-h/2,eyesize,eyesize*2);
  ellipse(x+w/3,y-h/2,eyesize,eyesize*2);
  line(x-w/12,y+h,x-w/4,y+h+10);
  line(x+w/12,y+h,x-w/4,y+h+10);
}
