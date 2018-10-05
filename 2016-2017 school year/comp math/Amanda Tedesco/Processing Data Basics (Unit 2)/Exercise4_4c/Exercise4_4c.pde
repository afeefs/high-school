int csize = 0;
void setup()
{
  background(0);
  size(500,500);
  rectMode(CENTER);
  ellipseMode(CENTER);
  frameRate(500);
}
void draw()
{
  fill(255);
  rect(width/2,height/2,width-20,height-20);
  fill(#C94141);
  ellipse(width/2,height/2,csize,csize);
  csize= csize+1;
  scale(csize);
}
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

