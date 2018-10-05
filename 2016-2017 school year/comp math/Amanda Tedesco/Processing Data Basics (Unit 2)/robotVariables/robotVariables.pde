void setup()
{
  size(500,500);
 
}

void draw()
{
  noStroke();
  background(155);
  
  fill(#105EE0);
  rectMode(CENTER);
  rect(290,330,legX,legsY);
  rectMode(CENTER);
  rect(220,330,legX,legsY);
  //legs
  
  fill(#802DE0);
  ellipseMode(CENTER);
  ellipse(255,270,bodyX,bodyY);
  //body
  
  fill(#4AE010);
  rectMode(CENTER);
  rect(255,200,neckX,neckY);
  //neck
  
  fill(#10E0DE);
  ellipseMode(CENTER);
  ellipse(255,160,headX,headX); 
  //head
  

  fill(255);
  ellipseMode(CENTER);
  ellipse(235,145,eyeX,eyesX);
  ellipseMode(CENTER);
  ellipse(275,145,eyeX,eyesX);
  //eyes
  
  fill(#802DE0);
  rectMode(CENTER);
  rect(215,240,armX,armsX);
  rectMode(CENTER);
  rect(295,240,armX,armsX);
  rectMode(CENTER);
  rect(195,240,armsX,armX);
  rectMode(CENTER);
  rect(315,240,armsX,armX);
  //arms
  
  legX = legX +1;
  legsY = legsY+1;
  bodyX= bodyX+1;
  neckX= neckX+1;
  headX= headX+1;
  eyeX=eyeX+1;
  eyesX=eyesX+1;
  armX=armX+1;
  armsX=armsX+1;
  
}
int legX= 20;
int legsY = 100;
int bodyX = 85;
int bodyY= 140;
int neckX = 40;
int neckY = 20;
int headX= 80;
int headY= 80;
int eyeX = 20;
int eyesX= 35;
int eyesY= 145;
int armX= 50;
int armsX= 20;

