float numFrames = 0; 
void setup()
{
  background(#7B45A7);
  size(500,500);
  rectMode(CENTER);
  frameRate(5);
}
void draw()
{
  numFrames++;
  noStroke();
  fill(255);
  ellipse(250,250,300,300);
  //the head
  
  noStroke();
  fill(#45A7A2);
  ellipse(190,180,90,60);
  ellipse(310,180,90,60);
  fill(255);
  rect(250,160,210,25);
  stroke(3);
  strokeWeight(4);
  line(144,142,150,170);
  line(220,180,280,180);
  line(356,142,350,170);
  //the sunglasses
  
  noStroke();
  fill(#859B40);
  rect(250,250,25,38);
  //the nose
  
  stroke(2);
  strokeWeight(10);
  line(185,315,315,315);
  //part of the mouth


  if(numFrames/5==1)
  {
    line(170,295,185,315);
    line(330,295,315,315);
    //smile
  }
  else if(numFrames/5==2)
  {
    line(170,335,185,315);
    line(330,335,315,315);
    noStroke();
    fill(#F7194D);
    ellipse(250,335,50,90);
    fill(255);
    rect(250,296,48,30);
    //frown with tongue
  }
  else
  {
    line(170,315,185,315);
    line(330,315,315,315);
    //no emotion
  }

}
