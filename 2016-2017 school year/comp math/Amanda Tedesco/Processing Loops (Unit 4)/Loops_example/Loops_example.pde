void setup()
{
   size(500,500);
  background(0);
  fill(200);

  for(int i =0;i < 500; i +=10)
     for(int j =8; j < 500;j+=18)
        ellipse(i,j,10,10);
}
