void finger(){
  noStroke();
  ellipseMode(CENTER);
  fill(#F5C825);
  ellipse(mouseX,mouseY,20,20);
  rectMode(CENTER);
  rect(mouseX,mouseY+30,20,50);
  fill(0);
  ellipse(mouseX,mouseY,10,20);
  fill(#F5C825);
  rect(mouseX,mouseY+5,10,10);
}
