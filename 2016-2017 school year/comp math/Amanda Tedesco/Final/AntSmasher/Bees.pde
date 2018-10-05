public class Bees{
  float xpos;
  float ypos;
  float yspeed;
  color c;
  float r;
  public Bees(float xposn, float yposn, float yspe, color cn,float radius){
    xpos = xposn;
    ypos = yposn;
    yspeed = yspe;
    c = cn;
    r = radius;
  }
void display2(){
  fill(c);
  //Body
  ellipseMode(CENTER);
  ellipse(xpos,ypos,10,30);
  
  //Wings
  fill(0);
  ellipse(xpos-8,ypos-5,10,10);
  ellipse(xpos-8,ypos+5,10,10);
  ellipse(xpos+8,ypos-5,10,10);
  ellipse(xpos+8,ypos+5,10,10);
  
  //Lines
  line(xpos-5,ypos-5,xpos+5,ypos-5);
  line(xpos-5,ypos,xpos+5,ypos);
  line(xpos-5,ypos+5,xpos+5,ypos+5);
}
void move2(){
  //Bees start to fly
  ypos = ypos + yspeed;
  
  //If you touch a Bee you lose time
  for(int i= bee.size()-1; i>= 0; i--)
    {
     
      if(bee.get(i).xpos+ 30>= mouseX&&bee.get(i).xpos - 30<= mouseX&& bee.get(i).ypos+ 15>= mouseY&& bee.get(i).ypos- 15<= mouseY)
      {
         background(0);
         fill(255);
         text("You've lost time.",width/2,height/2);
         
              
      } 
    }
}

}
