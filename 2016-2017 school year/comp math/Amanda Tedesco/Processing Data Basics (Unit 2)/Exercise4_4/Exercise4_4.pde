int variableX = 125;
int variableY= 125;
int circleX = 375;
int circleY = 125;
int charaX = 125;
int charaY = 375;
int happX = 375;
int happY = 375;
int csize = 100;

void setup()
{
  background(0);
  size(500,500);
}
void draw()
{
  fill(#2DF78D);
  ellipseMode(CENTER);
  ellipse(variableX,variableY,csize,csize);
  ellipseMode(CENTER);
  ellipse(circleX,circleY,csize,csize);
  ellipseMode(CENTER);
  ellipse(charaX,charaY,csize,csize);
  ellipseMode(CENTER);
  ellipse(happX,happY,csize,csize);
  csize= csize+1;
}
