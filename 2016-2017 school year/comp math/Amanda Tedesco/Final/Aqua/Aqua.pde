PImage img;
Sea [] fish = new Sea[100];
Weed [] we = new Weed[1000];
Bub [] bubble = new Bub[100];


void setup() {
  size(1280,835);
  // Images must be in the "data" directory to load correctly
  img = loadImage("underwater.jpg");
  smooth();
  //Declares the fishes position,color and speed
  for(int i = 0; i < fish.length; i++) {
    float a = random(0,800);
    float b = random(0,800);
    float j = random(1,5);
    color nc = color(random(0,255), random(0,255), random(0,255));
    fish[i] = new Sea(nc, a, b, i/20.0,j);
}
  //Declares the Seaweeds color and positions 
  for(int l = 0; l < we.length; l++){
    float a = random(0,width);
    float b = random(height/2,height);
    color p = color(random(0,120), random(0,255), random(0,50));
    we[l] = new Weed(p,a,b);
  }
  //Declares the Bubbles and positions
  for(int i = 0; i < bubble.length; i++){
    float t = random(0,width);
    float e = random(1,5);
    float g = random(5,20);
    bubble[i] = new Bub(t,height,g,e);
  }
}

void draw() {
  image(img, 0, 0,width,height);
  
  //Draws the Seaweed
  for(int n = 0; n < we.length; n++)
    we[n].Seaweed();
  
  Castle();
  //Moves and Draws the fish
  for(int i = 0; i < fish.length-1; i++) {
    fish[i].display();
    fish[i].move();
}
//Draws the Bubbles
for(int i = 0; i < bubble.length-1; i++){
  bubble[i].bubble();
  bubble[i].update();
}
}





