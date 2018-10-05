import edu.cmu.ri.createlab.terk.robot.finch.*;
Finch myFinch = new Finch();

boolean alm = myFinch.isBeakUp();
if(alm == true){
myFinch.saySomething("i'm flying.Wheeeeeee!!");
myFinch.setLED(255,255,255);
myFinch.playTone(200,5000);
}

boolean plm = myFinch.isFinchLevel();
if (plm == true){
myFinch.saySomething("My wheels are down, I'm going to dance!");
myFinch.setLED(0,0,255);
myFinch.setWheelVelocities(250,250,1000);
myFinch.setWheelVelocities(-250,-250,1000);
myFinch.setWheelVelocities(250,250,1000);
myFinch.setWheelVelocities(-250,-250,1000);
myFinch.setWheelVelocities(250,250,1000);
myFinch.setWheelVelocities(-250,-250,1000);
myFinch.setLED(0,255,0);
}

boolean dlm = myFinch.isFinchUpsideDown();
if(dlm == true){
myFinch.saySomething("Please turn me over.",3000);
myFinch.setLED(255,0,0);
  boolean poop = myFinch.isFinchLevel();
  if(poop == true)
    {
      myFinch.saySomething("Thanks");
      myFinch.setLED(0,0,255);
    }
   else
   {
     myFinch.saySomething("I'm so sad no one helped me.");
   }
}

if(alm == false && plm == false && dlm == false)
myFinch.saySomething("he's either pointed at the floor or one of his wings is down.");
      
     

