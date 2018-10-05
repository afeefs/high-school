float z;
void setup()
{
  println(mean(1,2));
 
}
float mean(float x,float y)
{
  x = 1/x;
  y = 1/y;
  z = (x+y)/2;
  z = 1/z;
  return z;
}
