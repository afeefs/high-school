import edu.cmu.ri.createlab.terk.robot.finch.*;
Finch myFinch = new Finch();


int b = 20;
while(myFinch.isBeakUp() == true)
{
  myFinch.playTone(b,200);
  b+=200;
}            
