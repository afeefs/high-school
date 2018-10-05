
float bright0 = 0;
float bright1 = 0;
float bright2 = 0;
float bright3 = 0;

void setup() { 
  size(500,500); 
} 

void draw() { 
  background(0); 

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


  bright0 = bright0 - 1;
  bright1 = bright1 - 1;
  bright2 = bright2 - 1;
  bright3 = bright3 - 1;


  noStroke(); 
  fill(bright0);
  rect(0,0,250,250); 
  fill(bright1);
  rect(250,0,250,250); 
  fill(bright2);
  rect(0,250,250,250); 
  fill(bright3);
  rect(250,250,250,250); 
  
  stroke(255); 
  line(250,0,250,500); 
  line(0,250,500,250); 

}
