void setup()
{
  size(500,500);
  frameRate(10);

for(int c = 1; c <= 100; c++)
{
  float a = random(0,500);
  float b = random(0,500);
  
    fill(#12C646);
  //tail
  beginShape();
  vertex(a-40,b-15);
  vertex(a-40,b+15);
  vertex(a,b);
  endShape(CLOSE);
  
  //body
  ellipse(a,b,50,30);
  
  //taillines
  line(a-40,b+5,a-23,b+2);
  line(a-40,b,a-23,b);
  line(a-40,b-5,a-23,b-2);
  
  //eyes
  fill(0);
  ellipse(a+17,b-6,5,5);
  
  //mouth
  line(a+15,b,a+25,b);
  
}
}
