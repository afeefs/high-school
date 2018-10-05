JitterBug[] bugs = new JitterBug[1];
 
void setup() {
  size(200, 200);
  smooth();
  for (int i = 0; i < bugs.length; i++) {
    float x = random(width);
    float y = random(height);
    int r = i + 50;
    bugs[i] = new JitterBug(x, y, r);
  }
   
}
 
void draw() {
  for (int i = 0; i < bugs.length; i++) {
    bugs[i].move();
    bugs[i].display();
  }
   
}
 
class JitterBug {
   
  float x;
  float y;
  int diameter;
  float speed = 2.5;
  color c = color(random(0,255),random(0,255),random(0,255));
   
  JitterBug (float tempX, float tempY, int tempDiameter) {
    x = tempX;
    y = tempY;
    diameter = tempDiameter;
  }
   
  void move() {
    x += random(-speed, speed);
    y += random(-speed, speed);
  }
   
  void display() {
    ellipse(x, y, diameter, diameter);
    fill(c);
  }
   
}

