import java.util.*;
import java.awt.*;

public class Level implements Displayable
{
   private ArrayList<Block> blocks;
   private ArrayList<Enemy> enemies, initEnemies;
   private Player player;
   private Chest chest;
   private boolean paused;
   
   public Level(ArrayList<Block> b, int x, int y)
   {
      this(b, new ArrayList<Enemy>(), x, y);
   }
   
   public Level(ArrayList<Block> b, ArrayList<Enemy> e, int x, int y)
   {
      blocks = b;
      initEnemies = e;
      enemies = (ArrayList<Enemy>)e.clone();
      paused = true;
      chest = new Chest(x, y);
   }
   
   public void display(Graphics g)
   {
      if(player != null)
         player.display(g);
      
      for(Block b : blocks)
         if(b != null)
            b.display(g);
      
      for(Enemy e : enemies)
         e.display(g);
         
      chest.display(g);
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
               remove = e;
               player.setYSpeed(-Player.JUMP); // bounces off top of e
               player.move(this);
            }
         }
         //e.display(g);
      }  
      enemies.remove(remove);
      
      player.update(this);
   }
   
   public Player player(){return player;}
   public void setPlayer(Player p){player = p;}
   
   public boolean paused(){return paused;}
   
   public ArrayList<Enemy> enemies(){return enemies;}
   
   public void reset()  
   {
      enemies = new ArrayList<Enemy>();
      for(Enemy e : initEnemies)
         enemies.add(e.clone());
   }
   
   public ArrayList<Block> blocks(){return blocks;}
      
   public void pause()
   {
      paused = !paused;
   }
}