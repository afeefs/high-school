size(500,500);
background(127);
float w = width;
float rad = 500;

while(w>0)
{
  stroke(0);
  ellipse(width/2,height/2,w,w);
  w-=20;
  rad-=25;
  if(rad%2==1)
  {
  fill(0);
  }
  
  if(rad%2==0)
  {
    fill(255);
  }
  
  if(w<155)
  {
    fill(#E80202);
    ellipse(250,250,137,137);
    noStroke();
  }
}
  

