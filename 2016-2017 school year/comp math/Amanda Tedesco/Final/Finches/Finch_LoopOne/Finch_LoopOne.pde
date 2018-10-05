import edu.cmu.ri.createlab.terk.robot.finch.*;
Finch myFinch = new Finch();


void Go(){
if(myFinch.isObstacleLeftSide()){
myFinch.setLED(255,0,0);
myFinch.stopWheels();
myFinch.setWheelVelocities(-200,-200,1000);
myFinch.setWheelVelocities(0,250,1000);
}

else if(myFinch.isObstacleRightSide()){
myFinch.setLED(0,0,255);
myFinch.stopWheels();
myFinch.setWheelVelocities(-200,-200,1000);
myFinch.setWheelVelocities(250,0,1000);
}
else {
  myFinch.setWheelVelocities(200,200,500);
}
}

void setup(){}
void draw(){
 Go();
 
}
