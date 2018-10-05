

//class Base 

  Ball b1 = new Ball(2,2,50);
  Ball b2 = new Ball(100,100,50);
   
  void setup() {
    size(500,500);
    println("setup");

  }

    
  void draw(){
    
    background(255);    
    b1.update();
    b2.update();
    println("draw");

  }
//}

class Ball {
  float x;
  float y;
  float xspeed;
  float yspeed;
  float w;
  //Location, Speed, and size
  
  
  Ball(float xpos, float ypos, float ws) {
   x = xpos;
   y = ypos;
   w = ws;
   xspeed = random(-5,5);
   yspeed = random(-5,5);
  }
  //Declares Ball Object
  
  void update() { 
    display();
    bounce();
    move();
  }

 void display() {
    ellipse(x,y,w,w);
    float a = random(0,255);
    float b = random(0,255);
    float c = random(0,255);
    fill(a,b,c);
}
//Declares what the ball looks like

  void move() {
    x += xspeed;
    y = y + yspeed;
        
    if(x > height || x < 0)
    xspeed = xspeed * -1;
       
    if(y > width || y < 0)
    yspeed = yspeed * -1;
  }
  //Changes X and Y positions
  
  void bounce() {
    
      if (b1.intersect(b2)) { 
    b1.richochet();
    b2.richochet();
  }
    }
  boolean intersect(Ball b) {
    
    // Objects can be passed into functions as arguments too! 
    float distance = dist(x,y,b.x,b.y); // Calculate distance
    
    // Compare distance to sum of radii
    if (distance < w + b.w) {
      return true;
    } else {
      return false;
    }
  }
  
//Makes Balls bounce

void richochet() {
  xspeed *= .3;
  yspeed *= -1.5;
}
}


