import edu.cmu.ri.createlab.terk.robot.finch.*;
Finch myFinch = new Finch();

while((myFinch.isShaken() == true)||(myFinch.isTapped() == true))
{
  myFinch.setWheelVelocities(-200,-200,1000);
  myFinch.setWheelVelocities(-200,0,500);
  if(myFinch.getYAcceleration() > myFinch.getXAcceleration())
  {
    myFinch.setWheelVelocities(0,200,1000);
    myFinch.setWheelVelocities(200,200,1000);
  }
  else if(myFinch.getZAcceleration() > myFinch.getYAcceleration())
  {
    myFinch.setWheelVelocities(200,0,1000);
    myFinch.setWheelVelocities(200,200,1000);
  }
  else
  {
    myFinch.setWheelVelocities(-200,-200,2000);
    myFinch.setWheelVelocities(200,200,2000);
  }
}
