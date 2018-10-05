

float x = 0;
float y = 0;
float xspeed = 5.2;
float yspeed = 6.5;
float r = 70;

void setup() {
  size(600,500);
  smooth();
}

void draw() {
  background(#2EA7AA);

  x = x + xspeed;
  y = y + yspeed;

  if ((x > width) || (x < 0)) {
    xspeed = xspeed * -1;
    r = 100;
  }
  
  if ((y > height) || (y < 0)) {
    yspeed = yspeed * -1;
    r = 100;
  }

  stroke(0);
  fill(#1FDE56);
  ellipse(x,y,r,r);
  
  r = constrain(r-2,70,100);
  
}
