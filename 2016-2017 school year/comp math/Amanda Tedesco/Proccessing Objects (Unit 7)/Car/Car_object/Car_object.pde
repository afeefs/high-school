Car [] cars = new Car[100];

void setup() {
  size(200,200);
  smooth();
  for(int i = 0; i < cars.length; i++) {
    color nc = color(random(0,255), random(0,255), random(0,255));
    cars[i] = new Car(nc, 0, i*2., i/20.0);
  }
}

void draw() {
  background(255);
  
  for(int i = 0; i < cars.length; i++) {
    cars[i].move();
    cars[i].display();
  }
}


public class Car {
  color c;
  float xpos;
  float ypos;
  float xspeed;
  
  public Car(color cn, float xposn, float yposn, float xsp) {
    c = cn;
    xpos = xposn;
    ypos = yposn;
    xspeed = xsp;
  }
  
  void display() {
    rectMode(CENTER);
    stroke(0);
    fill(c);
    rect(xpos, ypos, 20, 10);
  }
  
  void move() {
    xpos = xpos + xspeed;
    
    if(xpos > width)
      xpos = 0;
  }
}
    
    
    
    
    
    
    
    
    
    
    
