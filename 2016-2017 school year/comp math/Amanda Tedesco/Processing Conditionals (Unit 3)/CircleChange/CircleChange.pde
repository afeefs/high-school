float red = 237;
float blue = 250;
float green = 240;

void setup()
{
  size(500,500);
}
void draw()
{
  background(red,blue,green);
  ellipse(250,250,dist(250,250,mouseX,mouseY),dist(250,250,mouseX,mouseY));
  
  if(dist(250,250,mouseX,mouseY)/2 > width/4)
  {
   green-=40;
   red-=35;
  }
  else
  {  
   red+=35;
   green+=40;
  }
}

