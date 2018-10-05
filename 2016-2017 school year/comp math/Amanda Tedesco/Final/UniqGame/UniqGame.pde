float angle = 0.0;
float a = random(100,200);
Pins [] pin = new Pins();


void setup(){
  size(500,500);
  background(0);
}
void draw(){
  Circle();
}
void Circle(){
  stroke(5);
  fill(255);
  ellipse(width/2,height/2,a,a);
  fill(#691FEA);
  text("Use the spacebar to get all",(width/2)-75,height/2); 
  text("the balls on the Circle",(width/2)-66,(height/2)+20);
}
void tate(){
  translate(width/2,height/2);
  rotate(angle);
  ellipse( width/2,height/2,a,a);
  angle += 0.05;
}
void Pins(){
  
