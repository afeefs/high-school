import java.awt.*;

public abstract class Entity extends Rectangle implements Moveable, Displayable, Tangible
{
   private double xSpeed, ySpeed;
   private boolean grounded; // touching ground
   private Side facing; // left or right
   public static final double GRAVITY = 1;
   
   public Entity(int x, int y, int w, int h, double xs, double ys)
   {
      this(new Rectangle(x, y, w, h), xs, ys);
      grounded = false;
      facing = Side.RIGHT;
   }
   
   public Entity(Rectangle r, double xs, double ys)
   {
      super(r);
      xSpeed = xs;
      ySpeed = ys;
   }
   
   public double xSpeed(){return xSpeed;}
   public double ySpeed(){return ySpeed;}
   public boolean grounded(){return grounded;}
   public Side facing(){return facing;}
   
   public void setFacing(Side s){facing = s;}
   
   public void setXSpeed(double s){xSpeed = s;}
   public void setYSpeed(double s){ySpeed = s;}
   public void setGrounded(boolean g){grounded = g;}
   
   public abstract void move(Level l);
   public abstract void update(Level l);
   
   public abstract void display(Graphics g);
   
   public abstract boolean collides(Tangible t);
   
   public Rectangle hitbox()
   {
      return new Rectangle((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
   }
   
   /*public static Side collide(Rectangle r1, Rectangle r2) // which side of r2 collides with r1
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
   }*/
   
   public static Side collide(Rectangle r1, Rectangle r2) // which side is r2 colliding
   {
      if(r1.intersects(r2))
      {
         if(r2.getY() + r2.getHeight() < r1.getY() + r1.getHeight()/2)
            return Side.BOT;
         if(r2.getY() > r1.getY() + r1.getHeight()/2)
            return Side.TOP;
         if(r2.getX() > r1.getX() + r1.getWidth()/2)
            return Side.LEFT;
         return Side.RIGHT;
      }
      
      return Side.NONE;
   }
}