void setup()
{
size(500,500);
}
void draw()
{

if(mouseX < width/3)

  background(#FA7F03);

else if (mouseX < 2*width/3)

  background(#36E2FF);

else 

  background(#36FF55);
  
  line( width/3 , 0 , width/3 , height );
  line(2*width/3,0,2*width/3,height);
}
