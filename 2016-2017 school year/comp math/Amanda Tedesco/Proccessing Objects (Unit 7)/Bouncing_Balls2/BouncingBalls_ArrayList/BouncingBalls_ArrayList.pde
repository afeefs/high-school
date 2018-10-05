ArrayList <Ball> b1 = new ArrayList<Ball>();

void setup() {
  size(400,400);
  smooth();
  
  // Initialize balls
  b1.add(new Ball(64));
  b1.add(new Ball(32));
}

void draw() {
  background(255);
  // Move and display balls
  b1.get(0).move();
  b1.get(1).move();
  

  
  b1.get(0).display();
  b1.get(1).display();
}

class Ball {
  
  float r; // radius
  float x,y;
  float xspeed,yspeed;
  color c = color(100,50);
  
  // Constructor
  Ball(float tempR) {
    fill(c);
    r = tempR;
    x = random(width);
    y = random(height);
    xspeed = random( -5,5);
    yspeed = random( -5,5);
  }
  
  void move() {
    x += xspeed; // Increment x
    y += yspeed; // Increment y
    
    // Check horizontal edges
    if (x > width || x < 0) {
      xspeed *= - 1;
    }
    
    // Check vertical edges
    if (y > height || y < 0) {
      yspeed *= - 1;
    }
  }
  
  // Whenever the balls are touching, this highlight() function is called 
  // and the color is darkened.
  void highlight() { 
    xspeed *= -1.02;
    yspeed *= 1.02;
  }
  
  // Draw the ball
  void display() {
    stroke(0);
    fill(c);
    ellipse(x,y,r*2,r*2);
     // After the ball is displayed, the color is reset back to a darker gray.
    c = color(100,50);
  }
  
  // A function that returns true or false based on whether two circles intersect
  // If distance is less than the sum of radii the circles touch
  boolean intersect(Ball b) {
    
    // Objects can be passed into functions as arguments too! 
    float distance = dist(x,y,b.x,b.y); // Calculate distance
    
    // Compare distance to sum of radii
    if (distance < r + b.r) {
      return true;
    } else {
      return false;
    }
  }
}
