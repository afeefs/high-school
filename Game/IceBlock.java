import java.awt.*;

public class IceBlock extends Block
{
   public IceBlock(int x, int y)
   {
      super(x,y,Block.WIDTH,Block.HEIGHT);
   }
   
   public boolean collides(Tangible t)
   {
      return intersects(t.hitbox());
   }
   
   public void display(Graphics g)
   {
      g.setColor(Color.cyan);
      g.fillRect((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
   }
   
   public Block clone()
   {
      return new IceBlock((int)getX(), (int)getY());
   }
}  