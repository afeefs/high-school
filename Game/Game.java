import java.applet.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

/*
   WASD TO MOVE
   ESC TO PAUSE
   1, 2, 3 TO PICK LEVEL IN LEVEL SELECT
   WHEN GAME IS PAUSED, PRESS 1 TO RETURN TO LEVEL SELECT AND QUIT CURRENT LEVEL
   PRESS E TO INTERACT (WITH DOOR (YELLOW), CHEST (MAGENTA), DONKEY KONG)
   INTERACT WITH DOOR TO FINISH LEVEL
   INTERACT WITH CHEST TO GAIN KEY
   CAN'T SPAM GAIN KEYS ONCE ALREADY GOTTEN ONCE
   3 KEYS TO UNLOCK BOSS LEVEL
   INTERACT WITH DONKEY KONG TO BEAT GAME
   KILL 1 ENEMY TO GAIN 1 LIFE
   0 LIVES = GAME LOST, TRY AGAIN
*/

public class Game extends Applet implements Runnable, MouseListener, KeyListener
{
   private Graphics p;
   private Image offscreen;
   private Thread clockThread;
   private World world;
   public static int WIDTH = 1000, HEIGHT = 800;
   private boolean moving, hasKey, alive, enterPressed, won, inMenu;
   private int keys;
   private boolean[] levelKey;
   
   public void start(){if (clockThread == null) {clockThread = new Thread(this, "Clock");clockThread.start();}}
    
   public void run() 
   {
      Thread myThread = Thread.currentThread();
      while (clockThread == myThread)
      {
         repaint();
         try {Thread.sleep(10);} catch (InterruptedException e){}
      }
   }
   
   public void stop(){super.stop(); clockThread = null;}
   
   public void init()
   {
      resize(WIDTH, HEIGHT);
      setBackground(Color.black);
      offscreen = createImage(getWidth(), getHeight());
      p = offscreen.getGraphics();     
      addMouseListener(this);
      addKeyListener(this);
      
      Images images = new Images();
      world = new World(); 
      
      moving = false;
      hasKey = false;
      alive = true;
      won = false;
      enterPressed = false;
      inMenu = false;
      keys = 0;
      levelKey = new boolean[3];
      
      clockThread = null;
   }
   
   public void paint(Graphics g)
   {
      p.clearRect(0,0,getWidth(), getHeight());
      
      if(alive)
      {
         if(moving)
            world.currLevel().player().move(world.currLevel());
         world.display(p);
         
         p.setColor(Color.white);
         p.drawString("Keys: " + keys + "  Lives: " + world.lives(), Game.WIDTH-100, 15);
         if(world.lives() < 1)
         {
            alive = false;
         }
      }
      else
      {
         if(!won)
         {
            world.displayDeathScreen(p);
            if(enterPressed)
            {
               world = new World();
               moving = false;
               hasKey = false;
               alive = true;
               enterPressed = false;
               keys = 0;
               levelKey = new boolean[3];
            }
         }
         else
         {
            world.displayWinScreen(p);
            if(enterPressed)
            {
               world = new World();
               moving = false;
               hasKey = false;
               alive = true;
               enterPressed = false;
               keys = 0;
               levelKey = new boolean[3];
               won = false;
            }
         }
      }
      
      g.drawImage(offscreen,0,0,this);
   }
   
   public void keyTyped(KeyEvent e)
   {
      if(!world.paused())
      {
         if(e.getKeyChar() == 'w')
            world.currLevel().player().jump();
         if(e.getKeyChar() == 'e')
         {
            if(world.levelNum() == 3)
            {
               alive = false;
               won = true;
            }
         
            if(world.currLevel().player().intersects(world.currLevel().chest()) && world.currLevel().chest().takeKey())
            {
               hasKey = true;
               if(!levelKey[world.levelNum()])
                  keys++;
               levelKey[world.levelNum()] = true;
            }
            
            if(world.currLevel().player().intersects(world.currLevel().door()) && world.currLevel().enemies().size() == 0)
            {
               world.selectLevel(-1); // go to menu
               //world.pause();
               hasKey = false;
            }
         }
      }
      else
      {
         if(world.levelNum() == -1)
         {
            
            if(e.getKeyChar() == '1')
            {
               world.selectLevel(1);
            }
               
            if(e.getKeyChar() == '2')
               world.selectLevel(0);
               
            if(e.getKeyChar() == '3')
               world.selectLevel(2);
               
            if(keys >= 3 && e.getKeyChar() == '4')
               world.selectLevel(3);
         }
         else if(inMenu)
         { 
            if(e.getKeyChar() == '1')
            {
               world.selectLevel(-1); // go to menu
               //world.pause();
               hasKey = false;
            }
         }
      }
   }
   
   public void keyPressed(KeyEvent e)
   {
      if(world.levelNum() != -1)
         if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
         {
            inMenu = !inMenu;
            world.pause();
         }
      
      if(!world.paused())
         if(e.getKeyChar() == 'a' || e.getKeyChar() == 'd')
         {
            if(e.getKeyChar() == 'a')
               world.currLevel().player().setFacing(Side.LEFT);
            if(e.getKeyChar() == 'd')
               world.currLevel().player().setFacing(Side.RIGHT);
            moving = true;
         }
         
      if(e.getKeyCode() == KeyEvent.VK_ENTER)
      {
         enterPressed = true;
      }
   }
   
   public void keyReleased(KeyEvent e)
   {
      if(!world.paused())
         if(e.getKeyChar() == 'a' || e.getKeyChar() == 'd')
         {
            moving = false;
         }
         
      if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
      {
         enterPressed = false;
      }
   }
   
   public void mouseClicked(MouseEvent e)
   {
      
   }
   
   public void mousePressed(MouseEvent e)
   {
      
   }
   
   public void mouseReleased(MouseEvent e)
   {
      
   }
   
   public void mouseEntered(MouseEvent e)
   {
      
   }
   
   public void mouseExited(MouseEvent e)
   {
      
   }
   
   public void update(Graphics g)
   {
      paint(g);
   }
}