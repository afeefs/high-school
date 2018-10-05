import java.awt.*;

public class Platform extends Block
{
   public Platform(int x, int y)
   {
      super(x,y,Block.WIDTH,Block.HEIGHT);
   }
   
   public boolean collides(Tangible t)
   {
      return intersects(t.hitbox());
   }
   
   public void display(Graphics g)
   {
      g.setColor(Color.green);
      g.fillRect((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
   }
   
   public Block clone()
   {
      return new Platform((int)getX(), (int)getY());
   }
}