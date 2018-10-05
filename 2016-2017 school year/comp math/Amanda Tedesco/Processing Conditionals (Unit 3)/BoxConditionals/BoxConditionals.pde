
void setup()
{
  background(0);
  size(500,500);
}
void draw()
{
  float l = random(1,100);
  float w = random(1,100);
  float x = random(0,500);
  float y = random(0,500);
 
    if((l<5)||(w<5))
   { 
     rect(x,y,l,w);
     fill(#0DFF88);
   }
    else if((l<10)||(w<10))
   {
     rect(x,y,l,w);
     fill(#DAFF0D);
   } 
    else
    {
      rect(x,y,l,w);
      fill(255);
    }
}
