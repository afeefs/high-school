void setup()
{background(#24E5FC);
size(800,600);
ellipseMode(CENTER);
}
void mouseClicked()
{
  fill(#12C646);
  
  //tail
  beginShape();
  vertex(mouseX-40,mouseY-15);
  vertex(mouseX-40,mouseY+15);
  vertex(mouseX,mouseY);
  endShape(CLOSE);
  
  //body
  ellipse(mouseX,mouseY,50,30);
  
  //taillines
  line(mouseX-40,mouseY+5,mouseX-23,mouseY+2);
  line(mouseX-40,mouseY,mouseX-23,mouseY);
  line(mouseX-40,mouseY-5,mouseX-23,mouseY-2);
  
  //eyes
  fill(0);
  ellipse(mouseX+17,mouseY-6,5,5);
  
  //mouth
  line(mouseX+15,mouseY,mouseX+25,mouseY);
  
}
void draw()
{
}
