import java.applet.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Game extends Applet implements Runnable, MouseListener, KeyListener
{
   private Graphics p;
   private Image offscreen;
   private Thread clockThread;
   private World world;
   public static int WIDTH = 1000, HEIGHT = 800;
   private boolean moving;
   
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
   
   public void stop(){clockThread = null;}
   
   public void init()
   {
      resize(WIDTH, HEIGHT);
      setBackground(Color.white);
      offscreen = createImage(getWidth(), getHeight());
      p = offscreen.getGraphics();     
      addMouseListener(this);
      addKeyListener(this);
      
      world = new World(WIDTH, HEIGHT); 
      
      moving = false;
      
      clockThread = null;
   }
   
   public void paint(Graphics g)
   {
      p.clearRect(0,0,getWidth(), getHeight());
      
      if(moving)
         world.currLevel().player().move(world.currLevel());
      world.display(p);
      
      g.drawImage(offscreen,0,0,this);
   }
   
   public void keyTyped(KeyEvent e)
   {
      if(!world.paused())
      {
         if(e.getKeyChar() == 'w')
            world.currLevel().player().jump();
      }
   }
   
   public void keyPressed(KeyEvent e)
   {
      if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
      {
         world.pause();
         System.out.println(world.paused());
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
   }
   
   public void keyReleased(KeyEvent e)
   {
      if(!world.paused())
         if(e.getKeyChar() == 'a' || e.getKeyChar() == 'd')
         {
            moving = false;
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