void setup()
{
  size(500,500);
  background(0);
  fill(200);
  //The display window

  for(int i =30;i < 510; i +=63)
     for(int j =30; j < 510;j+=63)
        ellipse(i,j,43,43);
  //The circles ontop of eachother
        
        
  fill(0);
  beginShape();
  vertex(34,0);
  vertex(500,471);
  vertex(500,0);
  endShape(CLOSE);
  //The triangle coving the circles
}
