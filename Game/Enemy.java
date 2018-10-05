import java.awt.*;

public abstract class Enemy extends Entity
{
   public Enemy(int x, int y, int w, int h, int xs, int ys)
   {
      super(x,y,w,h,xs,ys);
   }
   
   public Enemy(Rectangle r, int xs, int ys)
   {
      super(r, xs, ys);
   }
   
   public abstract Enemy clone();
   public abstract void move(Level l);
}