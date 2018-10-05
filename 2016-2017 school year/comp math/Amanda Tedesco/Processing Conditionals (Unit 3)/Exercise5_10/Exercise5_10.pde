
float x = 0;
float y = 0;
float xspeed = 2.2;
float yspeed = 1.5;
float r = 32;
float bright0 = 0;
float bright1 = 0;
float bright2 = 0;
float bright3 = 0;


void setup() {
  size(500,500);
  smooth();
}

void draw() {
  background(#2EA7AA);

 if (mouseX < 250 && mouseY < 250) { 
    bright0 = 255;
  } 
  else if (mouseX > 250 && mouseY < 250) { 
    bright1 = 255;
  } 
  else if (mouseX < 250 && mouseY > 250) { 
    bright2 = 255;
  } 
  else if (mouseX > 250 && mouseY > 250) { 
    bright3 = 255;
  } 

  // All rectangles always fade
  bright0 = bright0 - 1;
  bright1 = bright1 - 1;
  bright2 = bright2 - 1;
  bright3 = bright3 - 1;

  // Fill color and draw each rectangle
  noStroke(); 
  fill(bright0);
  rect(0,0,250,250); 
  fill(bright1);
  rect(250,0,250,250); 
  fill(bright2);
  rect(0,250,250,250); 
  fill(bright3);
  rect(250,250,250,250); 
  
  // Draw grid lines
  stroke(255); 
  line(250,0,250,250); 
  line(0,250,250,250); 

  x = x + xspeed;
  y = y + yspeed;

  if ((x > width) || (x < 0)) {
    xspeed = xspeed * -1;
    r = 64;
  }
  
  if ((y > height) || (y < 0)) {
    yspeed = yspeed * -1;
    r = 64;
  }

  stroke(0);
  fill(#1FDE56);
  ellipse(x,y,r,r);
  
  r = constrain(r-2,32,64);
}
