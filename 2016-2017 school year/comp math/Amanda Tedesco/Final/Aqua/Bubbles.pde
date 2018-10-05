public class Bub{
  float xpos;
  float ypos;
  float rad;
  float yspeed;
  public Bub(float xposn, float yposn, float r,float yspe){
    xpos = xposn;
    ypos = yposn;
    rad = r;
    yspeed = yspe;
  }
  
 void bubble(){
   ellipseMode(CENTER);
   fill(116,250,246);
   ellipse(xpos,ypos,rad,rad);
 }
 void update(){
   //Bubbles move up
   ypos = ypos - yspeed;
   
}}
