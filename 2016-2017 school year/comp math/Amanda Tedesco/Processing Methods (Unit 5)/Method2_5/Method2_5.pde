void setup()
{
  println(five(10));
  println(four(2));
}
float five(float x)
{
  x = x*x;
  return x;
}
float four(float y)
{
  y = y*y*y;
  return y;
}  
