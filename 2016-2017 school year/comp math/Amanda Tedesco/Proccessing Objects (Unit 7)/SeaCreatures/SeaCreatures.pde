Sea [] fish = new Sea[1000];

void setup() {
  size(500,500);
  smooth();
  for(int i = 0; i < fish.length; i++) {
    color nc = color(random(0,255), random(0,255), random(0,255));
    fish[i] = new Sea(nc, 0, i*2., i/20.0);
  }
}

void draw() {
  background(255);
  
  for(int i = 0; i < fish.length; i++) {
    fish[i].move();
    fish[i].display();
  }
}


public class Sea {
  color c;
  float xpos;
  float ypos;
  float xspeed;
  
  public Sea(color cn, float xposn, float yposn, float xsp) {
    c = cn;
    xpos = xposn;
    ypos = yposn;
    xspeed = xsp;
  }
  
  void display() {
    stroke(0);
    fill(c);
   //tail
  beginShape();
  vertex(xpos-40,ypos-15);
  vertex(xpos-40,ypos+15);
  vertex(xpos,ypos);
  endShape(CLOSE);
  
  //body
  ellipse(xpos,ypos,50,30);
  
  //taillines
  line(xpos-40,ypos+5,xpos-23,ypos+2);
  line(xpos-40,ypos,xpos-23,ypos);
  line(xpos-40,ypos-5,xpos-23,ypos-2);
  
  //eyes
  fill(0);
  ellipse(xpos+17,ypos-6,5,5);
  
  //mouth
  line(xpos+15,ypos,xpos+25,ypos);
  
    
  }
  
  void move() {
    xpos = xpos + xspeed;
    
    if(xpos > width)
      xpos = 0;
  }
}
