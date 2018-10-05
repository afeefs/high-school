PImage img;

void setup() {
  // Make sure to declare a size
  size(500,500);
  // Images must be in the "data" directory to load correctly
  img = loadImage("dino pants.jpg");
}

void draw() {
  // 0,0 is where the image starts to be drawn
  // the height and width makes the image stretch to the ends
  image(img, 0, 0,width,height);
  image(img, 110, 110,30,30);
}
