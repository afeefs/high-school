import edu.cmu.ri.createlab.terk.robot.finch.*;
Finch myFinch = new Finch();


void Go(){
if(myFinch.isObstacleLeftSide()){
myFinch.setLED(255,0,0);
myFinch.stopWheels();
myFinch.setWheelVelocities(-200,-200,1000);
myFinch.setWheelVelocities(0,200,1000);
}

else if(myFinch.isObstacleRightSide()){
myFinch.setLED(0,0,255);
myFinch.stopWheels();
myFinch.setWheelVelocities(-200,-200,1000);
myFinch.setWheelVelocities(200,0,1000);
}
else {
  myFinch.setWheelVelocities(200,200,1000);
}
}

void setup(){}
void draw(){
 Go();
 
}
