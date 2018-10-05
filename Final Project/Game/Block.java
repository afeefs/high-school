import java.awt.*;

public abstract class Block extends Rectangle implements Displayable, Tangible
{
   public static final int WIDTH = 50, HEIGHT = 50;
   public Block(int x, int y, int w, int h)
   {
      super(x,y,w,h);
   }
   
   public abstract boolean collides(Tangible t);
   
   public Rectangle hitbox()
   {
      return new Rectangle((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
   }
   
   public abstract void display(Graphics g);
   
   public abstract Block clone();
}