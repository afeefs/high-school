float lw = 20;
float lh = 100;
float bw = 85;
float bh = 140;
float nw = 40;
float nh = 20;
float hwh = 80;
float ew = 20;
float eh = 35;
float aw = 50;
float ah = 20;
//width and height of the robot

float lx= 290;
float lxl = 220;
float bx = 255;
float nx = 255;
float hx = 255;
float ex = 235;
float exe = 275;
float ax = 215;
float axa = 295;
float axaa = 195;
float axaaa = 315;
//x coordinate of the robot

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
  rect(lx,330,lw,lh);
  rectMode(CENTER);
  rect(lxl,330,lw,lh);
  //legs
  
  fill(#802DE0);
  ellipseMode(CENTER);
  ellipse(bx,270,bw,bh);
  //body
  
  fill(#4AE010);
  rectMode(CENTER);
  rect(nx,200,nw,nh);
  //neck
  
  fill(#10E0DE);
  ellipseMode(CENTER);
  ellipse(nx,160,hwh,hwh); 
  //head
  

  fill(255);
  ellipseMode(CENTER);
  ellipse(ex,146,ew,eh);
  ellipseMode(CENTER);
  ellipse(exe,145,ew,eh);
  //eyes
  
  fill(#802DE0);
  rectMode(CENTER);
  rect(ax,240,aw,ah);
  rectMode(CENTER);
  rect(axa,240,aw,ah);
  rectMode(CENTER);
  rect(axaa,240,ah,aw);
  rectMode(CENTER);
  rect(axaaa,240,ah,aw);
  //arms  
  
 if (mouseX < width/2)
{ 
  lx+=5;
  lxl+=5;
  bx+=5;
  nx+=5;
  hx+=5;
  ex+=5;
  exe+=5;
  ax+=5;
  axa+=5;
  axaa+=5;
  axaaa+=5;
 //x coordinates minipulated
 
}
 else if (mouseX > width/2)
{ 
  lx-=5;
  lxl-=5;
  bx-=5;
  nx-=5;
  hx-=5;
  ex-=5;
  exe-=5;
  ax-=5;
  axa-=5;
  axaa-=5;
  axaaa-=5;
 //y coordinates minipulated
 
}

}
void mousePressed()
{
  lw-=3;
  lh-=3;
  bw-=5;
  bh-=5;
  nw-=3;
  nh-=3;
  hwh-=5;
  ew-=4;
  eh-=4;
  aw-=3;
  ah-=3;
  //width and height are being minipulated 
    
}


