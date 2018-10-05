import java.awt.*;

public class Player extends Entity
{
   private int lives;
   private boolean grace, isWario; // cannot be hit again
   private int graceTimer;
   public static final int JUMP = 14;
   
   public Player(int x, int y, boolean isWario)
   {
      super(x, y, (isWario)?Block.WIDTH: Block.WIDTH*3/4, (isWario)?Block.WIDTH*5/4: Block.WIDTH*3/2, 7, 0);
      lives = 3;
      grace = false;
      graceTimer = 0;
      this.isWario = isWario;
   }
   
   public boolean inGrace()
   {
      return grace;
   }
   
   public void hit()
   {
      if(grace) return;
      lives--;
      grace = true;
      graceTimer = 0;
   }
   
   public void collectLife()
   {
      if(lives < 3)
         lives++;
   }
   
   public int lives(){return lives;}
   public void setLives(int l){lives = l;}
   
   public void update(Level l)
   {
      if(grace && graceTimer > 100)
         grace = false;
      else
         graceTimer++;
         
      for(Enemy e : l.enemies())
         if(collides(e))
            hit();
            
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
      
      if(getY() + getHeight() > Game.HEIGHT)
         setLocation((int)getX(), Game.HEIGHT - (int)getHeight());
   }
   
   public int graceTimer(){return graceTimer;}
   
   public void jump()
   {
      jump(JUMP);
   }
   
   public void jump(int J)
   {
      if(grounded())
      {
         setYSpeed(ySpeed()-J);
         setGrounded(false);
      }
   }
    
   public boolean collides(Tangible t)
   {
      if(t instanceof Enemy)
         return t.collides(this);
      if(t instanceof Block && Entity.collide(t.hitbox(), this) == Side.BOT)
         setGrounded(true);
      return intersects(t.hitbox());
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
               break;
            
            case RIGHT:
               setLocation((int)(b.getX()-getWidth()), (int)getY());
               right = true;
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
   
   public void display1(Graphics g)
   {
      if(grace && graceTimer%6 < 3)
         g.setColor(Color.white);
      else
         g.setColor(Color. red);
         
      g.fillRect((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
   }
   
   public void display(Graphics g)
   {
      if(!(grace && graceTimer%6 < 3))
      {
         if(isWario)
         {
            if(facing() == Side.RIGHT)
               g.drawImage(Images.warioImage, (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
            if(facing() == Side.LEFT)
               g.drawImage(Images.warioImage, (int)(getX() + getWidth()), (int)getY(), -(int)getWidth(), (int)getHeight(), null);
         }
         else
         {
            if(facing() == Side.RIGHT)
               g.drawImage(Images.waluigiImage, (int)getX(), (int)getY(), (int)getWidth(), (int)getHeight(), null);
            if(facing() == Side.LEFT)
               g.drawImage(Images.waluigiImage, (int)(getX() + getWidth()), (int)getY(), -(int)getWidth(), (int)getHeight(), null);
         }
      }
   }
}
   