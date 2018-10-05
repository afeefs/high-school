import edu.cmu.ri.createlab.terk.robot.finch.*;
Finch myFinch = new Finch();
 void draw(){
 float c=myFinch.getLeftLightSensor();
 boolean a = myFinch.isFinchUpsideDown();
 boolean b = myFinch.isLeftWingDown();
 boolean g = myFinch.isRightWingDown();
 boolean d = myFinch.isFinchLevel();
 boolean e = myFinch.isBeakUp();
 boolean f = myFinch.isBeakDown();
if(c>20)
{
 
  if(a == true)
  myFinch.setLED(0,0,255);
   
  else if (b == true)
  myFinch.setLED(255,0,0);
 
  else if (g == true)
  
    myFinch.setLED(0,0,255);
  
  
  else if(d == true)
  
    myFinch.setLED(255,255,0);
  
 
  else if(e == true)
  
    myFinch.setLED(255,255,255);
  
 
  else if(f == true)
  
    myFinch.setLED(0,0,0);
}
}
