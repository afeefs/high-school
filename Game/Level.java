import java.util.*;
import java.awt.*;

public class Level implements Displayable
{
   private ArrayList<Block> blocks;
   private ArrayList<Enemy> enemies, initEnemies;
   private Player player;
   private Chest chest;
   private boolean paused;
   private Rectangle door;
   private Point playerPos;
   private int timer;
   
   public Level(ArrayList<Block> b, int x, int y, Rectangle d)
   {
      this(b, new ArrayList<Enemy>(), x, y, d);
   }
   
   public Level(ArrayList<Block> b, ArrayList<Enemy> e, int x, int y, Rectangle d)
   {
      blocks = b;
      initEnemies = e;
      enemies = new ArrayList<Enemy>();
      for(Enemy a : initEnemies)
         enemies.add(a.clone());
      paused = false;
      chest = new Chest(x, y);
      door = d;
      timer = 0;
   }
   
   public Rectangle door(){return door;}
   
   public void display(Graphics g)
   {
      if(door.getWidth() <= Block.WIDTH)
      {
         g.setColor(Color.yellow);
         g.fillRect((int)door.getX(), (int)door.getY(), (int)door.getWidth(), (int)door.getHeight());
      }
      else
      {
         g.drawImage(Images.donkeyKongImage, (int)door.getX(), (int)door.getY(), (int)door.getWidth(), (int)door.getHeight(), null);
      }
      
      chest.display(g);
      
      if(player != null)
         player.display(g);
      
      for(Block b : blocks)
         if(b != null)
            b.display(g);
      
      for(Enemy e : enemies)
         e.display(g);
   }
   
   public Chest chest(){return chest;}
   
   public void update()
   {
      if(paused) return;
      Enemy remove = null;
      for(Enemy e : enemies)
      {
         e.move(this);
         e.update(this);            
         if(e.intersects(player.hitbox()))
         {
            if(player.ySpeed() <= 0 || !e.collides(player))
               player.hit();
            else if(!player.inGrace())
            {
               if(!(e instanceof Flame))
               {
                  remove = e;
                  player.setYSpeed(-Player.JUMP); // bounces off top of e
               }
               player.move(this);
               player.collectLife();
            }
         }
         //e.display(g);
      }  
      enemies.remove(remove);
      if(door.getWidth() > Block.WIDTH)
      {
         //System.out.println(true);
         if(timer % 150 == 0)
         {
            
            enemies.add(new Toad(200, 130)); // summon Toad at Donkey Kong
         }
         timer++;
      }
      
      player.update(this);
   }
   
   public Player player(){return player;}
   public void setPlayer(Player p)
   {
      if(playerPos == null)
         playerPos = new Point((int)p.getX(), (int)p.getY());
      player = p;
   }
   
   public boolean paused(){return paused;}
   
   public ArrayList<Enemy> enemies(){return enemies;}
   
   public void reset()  
   {
      enemies = new ArrayList<Enemy>();
      for(Enemy e : initEnemies)
         enemies.add(e.clone());
      
      chest = new Chest((int)chest.getX(), (int)chest.getY());
      paused = false;
      if(playerPos != null)
         player.setLocation((int)playerPos.getX(), (int)playerPos.getY());
      player.setYSpeed(0);
      timer = 0;
   }
   
   public ArrayList<Block> blocks(){return blocks;}
      
   public void pause()
   {
      paused = !paused;
   }
   
   public Level clone()
   {
      return new Level(blocks, initEnemies, (int)chest.getX(), (int)chest.getY(), door);
   }
}