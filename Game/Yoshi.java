import java.awt.*;

public class Yoshi extends Enemy
{
   private static final int XSPEED = 1, YSPEED = 0;
   
   public Yoshi(int x, int y)
   {
      super(x, y, Block.WIDTH*2, Block.HEIGHT*2, XSPEED, YSPEED);
   }
   
   public void move()
   {
      
   }
   
   public void move(int dir)
   {
      
   }
   
   public void move(Level l)
   {
      if(facing() == Side.LEFT)
         translate(-(int)xSpeed(), 0);
      if(facing() == Side.RIGHT)
         translate((int)xSpeed(), 0); 
         
      boolean left = false, right = false, bot = false;
      for(Block b : l.blocks())
      {
         if(left && right && bot)
            break;
         switch(collide(b, this))
         {
            case NONE:
               break;
               
            case LEFT:
               setLocation((int)(b.getX()+b.getWidth()), (int)getY());
               left = true;
               setFacing(Side.RIGHT);
               break;
            
            case RIGHT:
               setLocation((int)(b.getX()-getWidth()), (int)getY());
               right = true;
               setFacing(Side.LEFT);
               break;
               
            case BOT:
               setLocation((int)getX(), (int)(b.getY() - getHeight()));
               setYSpeed(0);
               bot = true;
               break;
         }
      }
      setGrounded(bot);
   }

   
   public void update(Level l)
   {           
      translate(0, (int)ySpeed());
      if(!grounded())
      {
         boolean grounded = false;
         for(Block b : l.blocks())
         {
            if(Entity.collide(b.hitbox(), this) == Side.BOT)
            {
               grounded = true;  
               setGrounded(true);
               setYSpeed(0);
               setLocation((int)getX(), (int)(b.getY() - getHeight()));
               break;
            }
            if(Entity.collide(b.hitbox(), this) == Side.TOP)
            {
               setYSpeed(0);
               setLocation((int)getX(), (int)(b.getY() + b.getHeight()));
            }
         }
         if(!grounded)
            setYSpeed(ySpeed()+GRAVITY);
      }
   }
   
   public boolean collides(Tangible t)
   {
      if(t instanceof Enemy)
         return false;
      if(t instanceof Player)
         return Entity.collide(t.hitbox(), hitbox()) == Side.TOP; // if player hits top of Yoshi, Yoshi is hit.
      return intersects(t.hitbox());
   }
   
   public void display1(Graphics g)
   {
      g.setColor(Color.orange);
      g.fillRect((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
   }
   
   public void display(Graphics g)
   {
      if(facing() == Side.RIGHT)
         g.drawImage(Images.yoshiImage, (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
      if(facing() == Side.LEFT)
         g.drawImage(Images.yoshiImage, (int)(getX() + getWidth()), (int)getY(), -(int)getWidth(), (int)getHeight(), null);
   }
   
   public Enemy clone()
   {
      return new Yoshi((int)getX(), (int)getY());
   }
}