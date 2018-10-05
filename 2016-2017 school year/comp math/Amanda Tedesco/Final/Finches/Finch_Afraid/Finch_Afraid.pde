import edu.cmu.ri.createlab.terk.robot.finch.*;
Finch myFinch = new Finch();

float a = myFinch.isTapped();
float b = myFinch.isShaken();

if((a == true)||(b == true)){
 myFinch.setWheelVelocities(-200,-200,1000);
 myFinch.setWheelVelocities(0,500,1000);
 myFinch.setWheelVelocities(200,200,1000); 
 float c = myFinch.getXAcceleration();
 float d = myFinch.getYAcceleration();
 float e = myFinch.getZAcceleration();
 if(d > c){
   myFinch.setWheelVelocities(-200,-200,1000);
   myFinch.setWheelVelocities(0,250,1000);
   myFinch.setWheelVelocities(200,200,1000);
 }
   
  else if(e > d){
   myFinch.setWheelVelocities(-200,-200,1000);
   myFinch.setWheelVelocities(250,0,1000);
   myFinch.setWheelVelocities(200,200,1000);
 }
 
 else{
   myFinch.setWheelVelocities(200,200,2000);

