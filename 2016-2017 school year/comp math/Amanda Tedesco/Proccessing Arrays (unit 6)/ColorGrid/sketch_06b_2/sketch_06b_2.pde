color vals[][]=new color[400] [400];
int r;
int w;
int v1;
int v2;
int red;
int blue;
int green;
color c;
color t;

void setup() {
  size(400,400);
  v1=0;
  v2=255; 
  frameRate(5); 
  }
void draw() {
  for (r=0;r<height;r=r+10) {
    for(w=0;w<width;w=w+10) {
      if (v1<=0) {
        c = color(random(v1,v2),random(v1,v2),random(v1,v2));
        vals[r][w]=c;
      }
      else {
        t=vals[r][w];
        red=int(red(t))+v1;
        green=int(green(t))+v1;
        blue=int(blue(t))+v1;
        c=color(red,green,blue); 
      }  
      fill(c);
      rect(w,r,10,10);
      }
    }
    v1=v1+10;
    if (v1>220) {
    v1=0;
    }  
}
