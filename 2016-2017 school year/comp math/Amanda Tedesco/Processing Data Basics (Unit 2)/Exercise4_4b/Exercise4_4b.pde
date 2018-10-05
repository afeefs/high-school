int variable1 = 255;
int variable2 = 0;
int variable3 = 500;

void setup()
{
  background(255);
  size(500,500);
}
void draw()
{
  line(variable1,variable2,variable1,variable1);
  line(variable2,variable3,variable1,variable1);
  line(variable3,variable3,variable1,variable1);
  
  variable1 = variable1 +1;

}
