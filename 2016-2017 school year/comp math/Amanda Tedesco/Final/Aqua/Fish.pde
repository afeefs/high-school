public class Sea{
  color c;
  float xpos;
  float ypos;
  float xspeed;
  float yspeed;
  float q;
  
  public Sea(color cn, float xposn, float yposn, float xsp,float ysp) {
    c = cn;
    xpos = xposn;
    ypos = yposn;
    xspeed = xsp;
    yspeed = ysp;
  }
  //Display and Move should be in the Public Class Sea
  void display() {
    if(xspeed > 0){
    stroke(0);
    fill(c);
   //tail
  beginShape();
  vertex(xpos-40,ypos-15);
  vertex(xpos-40,ypos+15);
  vertex(xpos,ypos);
  endShape(CLOSE);
  
  //body
  ellipse(xpos,ypos,50,30);
  
  //taillines
  line(xpos-40,ypos+5,xpos-23,ypos+2);
  line(xpos-40,ypos,xpos-23,ypos);
  line(xpos-40,ypos-5,xpos-23,ypos-2);
  
  //eyes
  fill(0);
  ellipse(xpos+17,ypos-6,5,5);
  
  //mouth
  line(xpos+15,ypos,xpos+25,ypos);
      
    }
else{    
        stroke(0);
    fill(c);
   //tail
  beginShape();
  vertex(xpos+40,ypos+15);
  vertex(xpos+40,ypos-15);
  vertex(xpos,ypos);
  endShape(CLOSE);
  
  //body
  ellipse(xpos,ypos,50,30);
  
  //taillines
  line(xpos+40,ypos-5,xpos+23,ypos-2);
  line(xpos+40,ypos,xpos+23,ypos);
  line(xpos+40,ypos+5,xpos+23,ypos+2);
  
  //eyes
  fill(0);
  ellipse(xpos-17,ypos-6,5,5);
  
  //mouth
  line(xpos-15,ypos,xpos-25,ypos);
}  
  }  
  void move() {
    xpos = xpos + xspeed;
    ypos = ypos + yspeed;
    float v = random(0,20);
    q = random(0,10000);
    
    //If the fish reach the right or left side they swim the other direction 
    
    if((xpos >= width)||(q<50)){
      xspeed = (xspeed*-1);
      }
   
    if(xpos <= 0){
      xspeed = (xspeed*-1);
      for(int r = 0; r < fish.length; r++)
      fish[r].display();
  }
  //If the fish reach the bottom or the top they swim the other direction
   if((ypos >height) || (ypos < 0)||(q>9050))
     yspeed = yspeed*-1;

  }
  
 }
