
public class Weed{
  color c;
  float ypos;
  float xpos;
  
  public Weed(color cr, float xpom, float ypom){
    c = cr;
    xpos = xpom;
    ypos = ypom;
  }
  
  void Seaweed(){
  fill(c);
  float a = random(0,30);
  float b = random(0,100);
  rectMode(CENTER);
  rect(xpos,ypos,a,b);
  ellipseMode(CENTER);
  ellipse(xpos,ypos,a,a);
  
  }
}
