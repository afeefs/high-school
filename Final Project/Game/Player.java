import java.awt.*;
import javax.swing.*;

public class Player extends Entity
{
   private int lives;
   private boolean grace; // cannot be hit again
   private int graceTimer;
   public static final int JUMP = 14;
   private ImageIcon wario1; 
   private JLabel lable1;
   private ImageIcon wario2;
   private JLabel lable2;
   
  /** public Player(){
      setLayout(new FlowLayout());
      
      wario1 = new ImageIcon(getClass().gerResource("wario1.png")); 
      label1 = new JLabel(wario1);
      wario2 = new ImageIcon(getClass().gerResource("wario.png")); 
      label2 = new JLabel(wario2);
        
   }*/
   public Player(int x, int y)
   {
      super(x, y, Block.WIDTH*3/4, Block.WIDTH*3/2, 7, 0);
      lives = 3;
      grace = false;
      graceTimer = 0;
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
   
   public void display(Graphics g)
   {
      if(grace && graceTimer%6 < 3)
         g.setColor(Color.white);
      else
       //  gui.setVisible(true);
       g.setColor(Color.red);
         
   }
}
   