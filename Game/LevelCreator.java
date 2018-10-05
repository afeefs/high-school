import java.applet.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class LevelCreator extends Applet implements Runnable, MouseListener, KeyListener
{
   private Graphics p;
   private Image offscreen;
   private Thread clockThread;
   private Level level;
   private Block blockType;
   private Enemy enemyType;
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
      resize(Game.WIDTH, Game.HEIGHT); // 1000 x 800
      setBackground(Color.black);
      offscreen = createImage(getWidth(), getHeight());
      p = offscreen.getGraphics();
      addMouseListener(this);
      addKeyListener(this);
      
      Images images = new Images();
      
      level = new Level(new ArrayList<Block>(), new ArrayList<Enemy>(), 0, Block.HEIGHT, new Rectangle(0,0,1,1));
      level.setPlayer(new Player(0, Game.HEIGHT-Block.HEIGHT*3/2, false));
      
      blockType = new IceBlock(0,0);
      enemyType = new Toad(0,0);
      moving = false;
      
      for(int i = 0; i < 20; i++)
      {
         level.blocks().add(new Platform(i*Block.WIDTH, -Block.HEIGHT));
         level.blocks().add(new Platform(i*Block.WIDTH, getHeight()));
      }
      
      for(int i = 0; i < 16; i++)
      {
         level.blocks().add(new Platform(-Block.WIDTH, i*Block.HEIGHT));
         level.blocks().add(new Platform(getWidth(), i*Block.HEIGHT));
      }
      
      clockThread = null;
   }
   
   public void paint(Graphics g)
   {
      p.clearRect(0,0,getWidth(), getHeight());
      
      if(moving)
         level.player().move(level);
      level.update();
      
      level.display(p);
      
      
      p.setColor(Color.white);
      for(int i = 0; i < 20; i++)
      {
         p.drawLine(i*Block.WIDTH, 0, i*Block.WIDTH, getHeight());
      }
      
      for(int i = 0; i < 16; i++)
      {
         p.drawLine(0, i*Block.HEIGHT, getWidth(), i*Block.HEIGHT);
      }
      
      g.drawImage(offscreen,0,0,this);
   }
   
   public void keyTyped(KeyEvent e)
   {
      if(e.getKeyChar() == '1')
      {
         blockType = new Platform(0,0);
      }
      
      if(e.getKeyChar() == '2')
      {
         blockType = new IceBlock(0,0);
      }
      
      if(e.getKeyChar() == '3')
      {
         blockType = new GreenBlock(0,0);
      }
      
      if(e.getKeyChar() == '4')
      {
         blockType = new RedBlock(0,0);
      }
      
      if(e.getKeyChar() == '5')
      {
         enemyType = new Toad(0,0);
      }
      
      if(e.getKeyChar() == '6')
      {
         enemyType = new Yoshi(0,0);
      }
      
      if(e.getKeyChar() == '7')
      {
         enemyType = new Flame(0,0);
      }
      
      if(e.getKeyChar() == 'r')
      {
         level.reset();
      }
      
      if(e.getKeyChar() == 'p')
         print(3);
      
      if(!level.paused())
      {
         if(e.getKeyChar() == 'w')
            level.player().jump();
      }
   }
   
   public void keyPressed(KeyEvent e)
   {
      if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
      {
         level.pause();
      }
      
      if(!level.paused())
         if(e.getKeyChar() == 'a' || e.getKeyChar() == 'd')
         {
            if(e.getKeyChar() == 'a')
               level.player().setFacing(Side.LEFT);
            if(e.getKeyChar() == 'd')
               level.player().setFacing(Side.RIGHT);
            moving = true;
         }
   }
   
   public void keyReleased(KeyEvent e)
   {
      if(!level.paused())
         if(e.getKeyChar() == 'a' || e.getKeyChar() == 'd')
         {
            moving = false;
         }
   }
   
   public void mouseClicked(MouseEvent e)
   {
      if(e.getButton() == MouseEvent.BUTTON1)
      {
         for(Block b : level.blocks())
            if(b.contains(e.getX(), e.getY()))
            {
               level.blocks().remove(b);
               return;
            }
         blockType.setLocation((int)(e.getX()/Block.WIDTH)*Block.WIDTH, (int)(e.getY()/Block.HEIGHT)*Block.HEIGHT);
         level.blocks().add(blockType.clone());
      }
      else if(e.getButton() == MouseEvent.BUTTON3)
      {
         for(Enemy en : level.enemies())
            if(en.contains(e.getX(), e.getY()))
            {
               level.enemies().remove(en);
               return;
            }
         enemyType.setLocation((int)(e.getX()/Block.WIDTH)*Block.WIDTH, (int)(e.getY()/Block.HEIGHT)*Block.HEIGHT);
         level.enemies().add(enemyType.clone());
      }
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
   
   public void print(int n)
   {
      String print = "";
      for(int i = 72; i < level.blocks().size(); i++)
         if(level.blocks().get(i) instanceof IceBlock)
            print+="\nlevels["+n+"].blocks().add(new IceBlock("+((int)level.blocks().get(i).getX())+", "+((int)level.blocks().get(i).getY())+"));";
         else if(level.blocks().get(i) instanceof Platform)
            print+="\nlevels["+n+"].blocks().add(new Platform("+((int)level.blocks().get(i).getX())+", "+((int)level.blocks().get(i).getY())+"));";
         else if(level.blocks().get(i) instanceof GreenBlock)
            print+="\nlevels["+n+"].blocks().add(new GreenBlock("+((int)level.blocks().get(i).getX())+", "+((int)level.blocks().get(i).getY())+"));";
         else
            print+="\nlevels["+n+"].blocks().add(new RedBlock("+((int)level.blocks().get(i).getX())+", "+((int)level.blocks().get(i).getY())+"));";
         
      for(Enemy e : level.enemies())
         if(e instanceof Toad)
            print+="\nlevels["+n+"].enemies().add(new Toad("+((int)e.getX())+", "+((int)e.getY())+"));";
         else
            print+="\nlevels["+n+"].enemies().add(new Yoshi("+((int)e.getX())+", "+((int)e.getY())+"));";
         
      System.out.println(print);
   }
}