import java.awt.*;

public class Chest extends Rectangle implements Displayable
{
   private boolean hasKey;
   
   public Chest(int x, int y)
   {
      super(x, y, Block.WIDTH, Block.HEIGHT);
      hasKey = true;
   }
   
   public boolean takeKey()
   {
      boolean ret = hasKey;
      hasKey = false;
      return ret;
   }  
   
   /*public void display(Graphics g)
   {
      if(hasKey)
         g.setColor(Color.magenta);
      else
         g.setColor(Color.cyan);
      g.fillRect((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
   }*/
   
   public void display(Graphics g)
   {
      if(hasKey)
      {
         g.drawImage(Images.chestWithKeyImage, (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
      }
      else
      {
         g.drawImage(Images.chestImage, (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
      }
   }
}