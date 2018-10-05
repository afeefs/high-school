PImage img;

void setup() {
  // Make sure to declare a size
  size(600,400,P3D);
  // Images must be in the "data" directory to load correctly
  img = loadImage("caves.jpg");
}

void draw() {
  // 0,0 is where the image starts to be drawn
  // the height and width makes the image stretch to the ends
  image(img, 0, 0,width,height);
  translate(width/2,height/2,0);
  noStroke();
  spotLight(123,255,50, width/2, height/2, 400, 0, 0, -1, PI/4, 2);

  sphere(50);
  
}

