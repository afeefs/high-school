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
  rect(mouseX-35,mouseY+60,20,100);
  rectMode(CENTER);
  rect(mouseX+35,mouseY+60,20,100);
  //legs
  
  fill(#802DE0);
  ellipseMode(CENTER);
  ellipse(mouseX,mouseY,85,140);
  //body
  
  fill(#4AE010);
  rectMode(CENTER);
  rect(mouseX,mouseY-70,40,20);
  //neck
  
  fill(#10E0DE);
  ellipseMode(CENTER);
  ellipse(mouseX,mouseY-110,80,80); 
  //head
  

  fill(255);
  ellipseMode(CENTER);
  ellipse(mouseX-20,mouseY-125,20,35);
  ellipseMode(CENTER);
  ellipse(mouseX+20,mouseY-125,20,35);
  //eyes
  
  fill(#802DE0);
  rectMode(CENTER);
  rect(mouseX-40,mouseY-30,50,20);
  rectMode(CENTER);
  rect(mouseX+40,mouseY-30,50,20);
  rectMode(CENTER);
  rect(mouseX-60,mouseY-30,20,50);
  rectMode(CENTER);
  rect(mouseX+60,mouseY-30,20,50);
  //arms


  
}

