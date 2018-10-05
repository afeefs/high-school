import java.awt.*;

public class GreenBlock extends Block
{
   public GreenBlock(int x, int y)
   {
      super(x,y,Block.WIDTH,Block.HEIGHT);
   }
   
   public boolean collides(Tangible t)
   {
      return intersects(t.hitbox());
   }
   
   public void display(Graphics g)
   {
      g.setColor(new Color(28, 112, 31));
      g.fillRect((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
   }
   
   public Block clone()
   {
      return new GreenBlock((int)getX(), (int)getY());
   }
}  