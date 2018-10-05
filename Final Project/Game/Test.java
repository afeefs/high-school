import java.awt.*;

public class Test
{
   public static void main(String[] args)
   {
      Rectangle r1 = new Rectangle(100, 500, 50, 50), r2 = new Rectangle(100, 430, 50, 75);
      System.out.println(collide(r1, r2));
   }

   public static Side collide(Rectangle r1, Rectangle r2) // which side of r2 collides with r1
   {
      double dx = r1.getX() + r1.getWidth()/2 - r2.getX() + r2.getWidth()/2,
      dy = r1.getY() + r1.getHeight()/2 - r2.getY() + r2.getHeight()/2,
      width = (r1.getWidth() + r2.getWidth())/2,
      height = (r1.getHeight() + r2.getHeight())/2,
      crossWidth = width*dy,
      crossHeight = height*dx;
      
      if(Math.abs(dx) <= width && Math.abs(dy) <= height)
      {
         if(crossWidth > crossHeight)
         {
            if(crossWidth > -crossHeight)
               return Side.TOP;
            return Side.LEFT;
         }
         
         if(crossWidth > -crossHeight)
            return Side.RIGHT;
         return Side.BOT;
      }
      
      return Side.NONE;
   }
}