import edu.cmu.ri.createlab.terk.robot.finch.*;
Finch myFinch = new Finch();
int magnitude=round(random(1,8));
if(magnitude>=5&&magnitude<=6)
{
 myFinch.setWheelVelocities(magnitude*25,magnitude*25,500);
 myFinch.setWheelVelocities(-magnitude*25,-magnitude*25,500);
  myFinch.setWheelVelocities(magnitude*25,magnitude*25,500);
   myFinch.setWheelVelocities(-magnitude*25,-magnitude*25,500);
    myFinch.setWheelVelocities(magnitude*25,magnitude*25,500);
     myFinch.setWheelVelocities(-magnitude*25,-magnitude*25,500);
}
else if(magnitude<5)
{
  myFinch.setWheelVelocities(-magnitude*25,-magnitude*25,500);
   myFinch.setWheelVelocities(magnitude*25,magnitude*25,500);
   myFinch.setWheelVelocities(-magnitude*25,-magnitude*25,500);
    myFinch.setWheelVelocities(magnitude*25,magnitude*25,500);
     myFinch.setWheelVelocities(-magnitude*25,-magnitude*25,500);
      myFinch.setWheelVelocities(magnitude*25,magnitude*25,500);
}

else if(magnitude>6)
{
  myFinch.setWheelVelocities(magnitude*25,magnitude*25,500);
  myFinch.setWheelVelocities(-magnitude*25,-magnitude*25,500);
  myFinch.setWheelVelocities(magnitude*25,magnitude*25,500);
  myFinch.setWheelVelocities(-magnitude*25,-magnitude*25,500);
  myFinch.setWheelVelocities(magnitude*25,magnitude*25,500);
  myFinch.setWheelVelocities(-magnitude*25,-magnitude*25,500);
}

myFinch.saySomething("The magnitude was" + magnitude);
