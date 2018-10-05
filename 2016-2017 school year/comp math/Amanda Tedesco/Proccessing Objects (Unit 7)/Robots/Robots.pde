Robots [] bot = new Robots[250];

void setup() {
  size(500,500);
  smooth();
  for(int i = 0; i < bot.length; i++) {
    color nc = color(random(0,255), random(0,255), random(0,255));
    bot[i] = new Robots(nc, 0, i*2., i/20.0);
  }
}

void draw() {
  background(255);
  
  for(int i = 0; i < bot.length; i++) {
    bot[i].move();
    bot[i].display();
  }
}


public class Robots {
  color c;
  float xpos;
  float ypos;
  float xspeed;
  
  public Robots(color cn, float xposn, float yposn, float xsp) {
    c = cn;
    xpos = xposn;
    ypos = yposn;
    xspeed = xsp;
  }
  
  void display() {
        
    float a = xpos;
    float b = ypos;
    
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
  
  void move() {
    xpos = xpos + xspeed;
    
    if(xpos > width)
      xpos = 0;
  }
}
