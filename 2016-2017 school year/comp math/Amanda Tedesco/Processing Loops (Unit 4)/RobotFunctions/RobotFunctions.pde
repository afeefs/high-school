void setup()
{
  size(500,500);
  background(127);
  noStroke();
  drawRobot();
  
}
void drawRobot()
{
 float a = random(0,500);
 //x variable
  float b = 100;
 //y variable

  fill(#105EE0);
  rectMode(CENTER);
  rect(a,b,20,100);
  rectMode(CENTER);
  rect(a-70,b,20,100);
  //legs
  
  fill(#802DE0);
  ellipseMode(CENTER);
  ellipse(a-35,b-60,85,140);
  //body
  
  fill(#4AE010);
  rectMode(CENTER);
  rect(a-35,b-130,40,20);
  //neck
  
  fill(#10E0DE);
  ellipseMode(CENTER);
  ellipse(a-35,b-170,80,80); 
  //head
  

  fill(255);
  ellipseMode(CENTER);
  ellipse(a-55,b-185,20,35);
  ellipseMode(CENTER);
  ellipse(a-15,b-185,20,35);
  //eyes
  
  fill(#802DE0);
  rectMode(CENTER);
  rect(a-75,b-90,50,20);
  rectMode(CENTER);
  rect(a+5,b-90,50,20);
  rectMode(CENTER);
  rect(a-95,b-90,20,50);
  rectMode(CENTER);
  rect(a+25,b-90,20,50);
  //arms
  
}
