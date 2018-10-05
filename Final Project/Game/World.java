import java.awt.*;
import java.util.*;

public class World implements Displayable
{
   private Level[] levels;
   private int currLevel;// levels start at 0, menu is -1
   private boolean paused;
   private int width, height;
   
   public World(int width, int height)
   {
      currLevel = 0;
      paused = true;
      levels = new Level[4];
      levels[0] = new Level(new ArrayList<Block>(), new ArrayList<Enemy>(), 0, Block.HEIGHT);
      
      levels[0].setPlayer(new Player(100, 600));
      for(int i = 0; i < 20; i++)
      {
         levels[0].blocks().add(new Platform(i*Block.WIDTH, -Block.HEIGHT));
         levels[0].blocks().add(new Platform(i*Block.WIDTH, Game.HEIGHT));
      }
      
      for(int i = 0; i < 16; i++)
      {
         levels[0].blocks().add(new Platform(-Block.WIDTH, i*Block.HEIGHT));
         levels[0].blocks().add(new Platform(Game.WIDTH, i*Block.HEIGHT));
      }
      levels[0].blocks().add(new Platform(100, 750));
 levels[0].blocks().add(new Platform(150, 750));
 levels[0].blocks().add(new Platform(150, 700));
 levels[0].blocks().add(new Platform(200, 750));
 levels[0].blocks().add(new Platform(200, 700));
 levels[0].blocks().add(new Platform(250, 750));
 levels[0].blocks().add(new Platform(250, 650));
 levels[0].blocks().add(new Platform(200, 650));
 levels[0].blocks().add(new Platform(250, 700));
 levels[0].blocks().add(new Platform(250, 600));
 levels[0].blocks().add(new Platform(300, 600));
 levels[0].blocks().add(new Platform(300, 650));
 levels[0].blocks().add(new Platform(300, 700));
 levels[0].blocks().add(new Platform(300, 750));
 levels[0].blocks().add(new Platform(450, 550));
 levels[0].blocks().add(new Platform(450, 600));
 levels[0].blocks().add(new Platform(500, 600));
 levels[0].blocks().add(new Platform(600, 600));
 levels[0].blocks().add(new Platform(550, 600));
 levels[0].blocks().add(new Platform(650, 600));
 levels[0].blocks().add(new Platform(700, 600));
 levels[0].blocks().add(new Platform(750, 550));
 levels[0].blocks().add(new Platform(750, 600));
 levels[0].blocks().add(new Platform(950, 600));
 levels[0].blocks().add(new Platform(950, 550));
 levels[0].blocks().add(new Platform(950, 500));
 levels[0].blocks().add(new Platform(900, 450));
 levels[0].blocks().add(new Platform(950, 450));
 levels[0].blocks().add(new Platform(900, 400));
 levels[0].blocks().add(new Platform(950, 400));
 levels[0].blocks().add(new Platform(150, 450));
 levels[0].blocks().add(new Platform(100, 400));
 levels[0].blocks().add(new Platform(50, 350));
 levels[0].blocks().add(new Platform(0, 300));
 levels[0].blocks().add(new Platform(150, 250));
 levels[0].blocks().add(new Platform(250, 300));
 levels[0].blocks().add(new Platform(200, 300));
 levels[0].blocks().add(new Platform(300, 300));
 levels[0].blocks().add(new Platform(350, 300));
 levels[0].blocks().add(new Platform(400, 250));
 levels[0].blocks().add(new Platform(450, 200));
 levels[0].blocks().add(new Platform(500, 200));
 levels[0].blocks().add(new Platform(550, 200));
 levels[0].blocks().add(new Platform(600, 200));
 levels[0].blocks().add(new Platform(850, 750));
 levels[0].blocks().add(new Platform(900, 700));
 levels[0].blocks().add(new Platform(950, 650));
 levels[0].blocks().add(new Platform(800, 600));
 levels[0].blocks().add(new Platform(850, 450));
 levels[0].blocks().add(new Platform(650, 200));
 levels[0].blocks().add(new Platform(350, 100));
 levels[0].blocks().add(new Platform(300, 100));
 levels[0].blocks().add(new Platform(250, 100));
 levels[0].blocks().add(new Platform(200, 100));
 levels[0].blocks().add(new Platform(150, 100));
 levels[0].blocks().add(new Platform(50, 100));
 levels[0].blocks().add(new Platform(0, 100));
 levels[0].blocks().add(new Platform(100, 100));
 levels[0].blocks().add(new Platform(950, 700));
 levels[0].blocks().add(new Platform(950, 750));
 levels[0].blocks().add(new Platform(900, 750));
 levels[0].blocks().add(new Platform(700, 250));
 levels[0].blocks().add(new Platform(750, 300));
 levels[0].blocks().add(new Platform(800, 350));
 levels[0].blocks().add(new Platform(850, 400));
 levels[0].blocks().add(new Platform(450, 250));
 levels[0].blocks().add(new Platform(500, 250));
 levels[0].blocks().add(new Platform(550, 250));
 levels[0].blocks().add(new Platform(600, 250));
 levels[0].blocks().add(new Platform(450, 300));
 levels[0].blocks().add(new Platform(400, 300));
 levels[0].blocks().add(new Platform(500, 300));
 levels[0].blocks().add(new Platform(550, 300));
 levels[0].blocks().add(new Platform(600, 300));
 levels[0].blocks().add(new Platform(650, 250));
 levels[0].blocks().add(new Platform(650, 300));
 levels[0].blocks().add(new Platform(700, 300));
 levels[0].blocks().add(new Platform(700, 350));
 levels[0].blocks().add(new Platform(750, 350));
 levels[0].blocks().add(new Platform(800, 400));
 levels[0].blocks().add(new Platform(750, 400));
 levels[0].blocks().add(new Platform(0, 350));
 levels[0].blocks().add(new Platform(50, 400));
 levels[0].blocks().add(new Platform(100, 450));
 levels[0].blocks().add(new Platform(50, 450));
 levels[0].blocks().add(new Platform(0, 400));
 levels[0].blocks().add(new Platform(150, 500));
 levels[0].blocks().add(new Platform(200, 450));
 levels[0].blocks().add(new Platform(100, 500));
 levels[0].blocks().add(new Platform(300, 550));
 levels[0].enemies().add(new Toad(658, 750));
 levels[0].enemies().add(new Toad(252, 250));
 levels[0].enemies().add(new Toad(438, 750));
 levels[0].enemies().add(new Toad(670, 550));
 levels[0].enemies().add(new Toad(876, 350));
   }
   
   public void display(Graphics g)
   {
      if(currLevel == -1)
         displayLevelSelect(g);
      else
      {
         if(paused)
            displayMenu(g);
         else
            levels[currLevel].update();
         levels[currLevel].display(g);
      }
   }
   
   private void displayLevelSelect(Graphics g)
   {
      
   }
   
   private void displayMenu(Graphics g)
   {
      
   }
   
   public void displayOptions(Graphics g)
   {
      
   }
   
   public Level currLevel()
   {
      if(currLevel == -1)
         return new Level(new ArrayList<Block>(), new ArrayList<Enemy>(), -Block.WIDTH, -Block.HEIGHT);
      return levels[currLevel];
   }
   
   public void pause()
   {
      paused = !paused;
      levels[currLevel].pause();
   }
   
   public boolean paused(){return paused;}
   
   private void selectLevel(int l)
   {
      if(currLevel != -1)
         levels[currLevel].reset();
      currLevel = l;
   }
}