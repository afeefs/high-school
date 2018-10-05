Truck [] trucks = new Truck[100];

void setup()
{
  size(300,300);
  smooth();
  
  for(int i=0; i<trucks.length; i++)
  {
    color cn=color(random(0,255), random(0,255), random(0,255));
    trucks[i]=new Truck(cn,0.,i*3,i/25.);
  }
}

void draw()
{
  background(255);
  
  for(int i=0; i<trucks.length;i++)
  {
    trucks[i].move();
    trucks[i].display();
  }
}
  
public class Truck //create class
{
  color c;
  float xpos;
  float ypos;
  float xspeed;
  
  public Truck(color cn, float xp, float yp, float xsp) //constructor (declare, initialize, and set values)
  {
    c=cn;
    xpos=xp;
    ypos=yp;
    xspeed=xsp;
  }
  
  public void display()
  {
    rectMode(CENTER);
    stroke(0);
    fill(c);
    rect(xpos,ypos,30,10);
  }
  
  void move() //not putting "public" automatically assumes public
  {
    xpos+=xspeed;
    if(xpos>width)
      xpos=0;
  }
}

//never return anything with constructors


