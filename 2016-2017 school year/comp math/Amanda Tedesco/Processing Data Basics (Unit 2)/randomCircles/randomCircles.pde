void setup()
{
  size(500,500);
  background(#03FFFD);
  noStroke();
}
void draw()
{
  float clor = random(0,255);
  float clor2 = random(0,255);
  float clor3 = random(0,255);
  float clor4 = random(0,255);
  float circ2 = random(5,500);
  float circ = random(5,500);
  float rad= random(1,200);
  fill(clor,clor2,clor3,clor4);
  ellipse(circ2,circ,rad,rad);
  
}
