PImage img;

int lives = 5;
int opplives = 0;
int score = 0;

ArrayList<Ants> ant = new ArrayList<Ants>();
ArrayList<Bees> bee = new ArrayList<Bees>();


void setup() {
  // Make sure to declare a size
  size(590,420);
  
  // Images must be in the "data" directory to load correctly
  img = loadImage("PicnicTable.jpg");
  
  //To change intensity of game edit the number of Ants and Bees
  //Initialized and Declares the Ants
  for(int i = 0; i < 21; i++){
    float a = random(0,width);
    float b = random(1,10);
    float c = random(1,10);
    ant.add(new Ants(a,0,c/b,#8E8B93,35));
  }
  
  //Initializes and Declares the Bees
  for(int i = 0; i < 11; i++){
    float d = random(0,width);
    float e = random(1,10);
    float f = random(1,10);
    bee.add(new Bees(d,0,f/e,#F5C20A,45));
  }
}

void draw() {
  // 0,0 is where the image starts to be drawn
  // the height and width makes the image stretch to the ends
  image(img, 0, 0,width,height);
  
  //Draws the Ants
  for(int i = 0; i < ant.size()-1; i++){
    ant.get(i).display();
    ant.get(i).move();
    ant.get(i).loss();
       
  }
  
  //Draws the Bees
  for(int i = 0; i < bee.size()-1; i++){
    bee.get(i).display2();
    bee.get(i).move2();
  }
  
 texts();
 finger();
}


