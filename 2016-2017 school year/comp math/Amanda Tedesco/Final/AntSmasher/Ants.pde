public class Ants{
  float xpos;
  float ypos;
  float yspeed;
  color c;
  float r;
  public Ants(float xposn, float yposn, float yspe, color cn,float radius){
    xpos = xposn;
    ypos = yposn;
    yspeed = yspe;
    c = cn;
    r = radius;
  }
void display(){
  noStroke();
  ellipseMode(CENTER);
  fill(c);
  ellipse(xpos,ypos-20,15,30);
  ellipse(xpos,ypos,r,r);
  ellipse(xpos,ypos+20,15,30);
  //Body of the ants
  
  stroke(5);
  line(xpos-9,ypos-10,xpos-20,ypos-20);
  line(xpos+9,ypos-10,xpos+20,ypos-20);
  line(xpos-9,ypos,xpos-20,ypos-10);
  line(xpos+9,ypos,xpos+20,ypos-10);
  line(xpos-9,ypos+10,xpos-20,ypos);
  line(xpos+9,ypos+10,xpos+20,ypos);
  //Legs of the ants
  
  fill(0);
  ellipse(xpos-5,ypos+23,5,5);
  ellipse(xpos+5,ypos+23,5,5);
  //Eyes of the ant
  
 
}

void move(){
  //Ants start to crawl
  ypos = ypos + yspeed;
  
  //When you kill an ant it dies and your score gets adjusted
  for(int i= ant.size()-1; i>= 0; i--)
    {
     
      if(ant.get(i).xpos+ 30>= mouseX&&ant.get(i).xpos - 30<= mouseX&& ant.get(i).ypos+ 15>= mouseY&& ant.get(i).ypos- 15<= mouseY)
      {
        ant.remove(i);
        score++;
        
      } 
     
    }
 }
 
void loss(){
  
 //When an ant gets past you you lose a life
  for(int i = 0; i < ant.size(); i++){
    if(ant.get(i).ypos >= height){
      lives-=1;
      opplives++;
      ant.remove(i);
    }
   }
}
}

