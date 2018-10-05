/* Name: Amanda Tedesco
 * Date: January 24 2016
 * Description: Starfield design... moving stars and 1 Oddball */
 Particle[] fire = new Particle[20];
 public void setup()
 {
   background(0);
   size(500,500);
   //Initializes the particles in the order
   for(int i = 0; i < fire.length; i++)
   {
     double x = random(0, width);
     double y = random(0, height);
     double angle = random(1,360);
     double speed = random(1,5);
     color col = color(random(0,255),random(0,255),random(0,255));
     if(i == 0)
     {
       fire[i] = new OddballParticle(x, y, speed, angle, col);
     }
     else if(i == 1)
     {
       fire[i] = new JumboParticle(x, y, speed, angle, col);
     }
     else
     {
       fire[i] = new NormalParticle(x,y,speed,angle,col);
     }
   }  
 }
 
 public void draw()
 {
   //Shows and moves the initalized particles
   for(int i = 0; i < fire.length; i++)
   {
     fire[i].move();
     fire[i].show();
     //fire[i].edges();
   }
 }
 
 public class NormalParticle implements Particle// inheritance here
 {  
   double x, y, speed, angle;
   color col;
   public NormalParticle(double xpos, double ypos, double spe, double ang, color c)
   {
     x = xpos;
     y = ypos;
     speed = spe;
     angle = ang;
     col = c;
   }
   public NormalParticle()
   {
   }
   public void move()
   {
     x = x + cos((float)(radians((float)angle)))*speed;
     y = y + sin((float)(radians((float)angle)))*speed;
   }
   public void show()
   {
     noStroke();
     fill(col);
     ellipse((float)x,(float)y, 8, 8);
   }
   /*public void edges()
   {
     if((x <= 10) || (x >= width-10))
     {
       x = x - cos((float)(radians((float)angle)))*speed;
       y = y - sin((float)(radians((float)angle)))*speed;
     } 
     if((y <= 10) || (y >= width-10))
     {
       x = x - cos((float)(radians((float)angle)))*speed;
       y = y - sin((float)(radians((float)angle)))*speed;
     }
   }*/
 }
 
 public interface Particle
 {
   public void show();
   public void move();
   //public void edges();
 }
 
 public class OddballParticle extends NormalParticle implements Particle // extends a class and implements an interface
 { 
   public OddballParticle(double xpos, double ypos, double spe, double ang, color c)
   {
     super(xpos, ypos, spe, ang, c);
   }
   public void move()
   {
     x = x + random(1,10);
     y = y + random(1,(float)speed);
   }
 }

 public class JumboParticle extends NormalParticle implements Particle // extends a class and implements an interface 
 {
   public JumboParticle(double xpos, double ypos, double spe, double ang, color c)
   {
     super(xpos,ypos,spe,ang,c);
   }
   public void show()
   {
     noStroke();
     fill(col);
     ellipse((float)x, (float)y, 20, 20);
   }
 }
 
 
 
 