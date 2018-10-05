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
  rect(290,330,20,100);
  rectMode(CENTER);
  rect(220,330,20,100);
  //legs
  
  fill(#802DE0);
  ellipseMode(CENTER);
  ellipse(255,270,85,140);
  //body
  
  fill(#4AE010);
  rectMode(CENTER);
  rect(255,200,40,20);
  //neck
  
  fill(#10E0DE);
  ellipseMode(CENTER);
  ellipse(255,160,80,80); 
  //head
  

  fill(255);
  ellipseMode(CENTER);
  ellipse(235,145,20,35);
  ellipseMode(CENTER);
  ellipse(275,145,20,35);
  //eyes
  
  fill(#802DE0);
  rectMode(CENTER);
  rect(215,240,50,20);
  rectMode(CENTER);
  rect(295,240,50,20);
  rectMode(CENTER);
  rect(195,240,20,50);
  rectMode(CENTER);
  rect(315,240,20,50);
  //arms
  
  
}

