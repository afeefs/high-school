import java.awt.*;

public class RedBlock extends Block
{
   public RedBlock(int x, int y)
   {
      super(x,y,Block.WIDTH,Block.HEIGHT);
   }
   
   public boolean collides(Tangible t)
   {
      return intersects(t.hitbox());
   }
   
   public void display(Graphics g)
   {
      g.setColor(Color.red);
      g.fillRect((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
   }
   
   public Block clone()
   {
      return new RedBlock((int)getX(), (int)getY());
   }
}  