void setup()
{background(0);
size(500,500);
}

void draw()
{background(225);
  line(0,0,mouseX,mouseY);
  line(500,500,mouseX,mouseY);
  line(500,0,mouseX,mouseY);
  line(0,500,mouseX,mouseY);
}

