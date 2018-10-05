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
  rect(legsX,legsY,20,100);
  rectMode(CENTER);
  rect(legX,legsY,20,100);
  //legs
  
  fill(#802DE0);
  ellipseMode(CENTER);
  ellipse(bodyX,bodyY,85,140);
  //body
  
  fill(#4AE010);
  rectMode(CENTER);
  rect(neckX,neckY,40,20);
  //neck
  
  fill(#10E0DE);
  ellipseMode(CENTER);
  ellipse(headX,headY,80,80); 
  //head
  

  fill(255);
  ellipseMode(CENTER);
  ellipse(eyeX,eyesY,20,35);
  ellipseMode(CENTER);
  ellipse(eyesX,eyesY,20,35);
  //eyes
  
  fill(#802DE0);
  rectMode(CENTER);
  rect(armX,armsY,50,20);
  rectMode(CENTER);
  rect(armsX,armsY,50,20);
  rectMode(CENTER);
  rect(handX,handsY,20,50);
  rectMode(CENTER);
  rect(handsX,handsY,20,50);
  //arms
  
  legX = legX +3;
  legsX = legsX+3;
  bodyX= bodyX+3;
  neckX= neckX+3;
  headX= headX+3;
  eyeX=eyeX+3;
  eyesX=eyesX+3;
  armX=armX+3;
  armsX=armsX+3;
  handX=handX+3;
  handsX=handsX+3;
  
}
int legX= 290;
int legsX = 220;
int legsY = 330;
int bodyX = 255;
int bodyY= 270;
int neckX = 255;
int neckY = 200;
int headX= 255;
int headY= 160;
int eyeX = 235;
int eyesX= 275;
int eyesY= 145;
int armX= 215;
int armsX= 295;
int armsY= 240;
int handX= 195;
int handsX= 315;
int handsY=240;
