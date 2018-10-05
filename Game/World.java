import java.awt.*;
import java.util.*;

public class World implements Displayable
{
   private Level[] levels;
   private int currLevel;// levels start at 0, menu is -1
   private boolean paused;
   private int lives;
   
   public World()
   {
      currLevel = -1;
      lives = 3;
      paused = true;
      levels = new Level[4];
      ArrayList<Enemy> temp = new ArrayList<Enemy>();
      temp.add(new Toad(658, 750));
      temp.add(new Toad(252, 250));
      temp.add(new Toad(438, 750));
      temp.add(new Toad(670, 550));
      temp.add(new Toad(876, 350));
      levels[0] = new Level(new ArrayList<Block>(), temp, 0, Block.HEIGHT, new Rectangle(950, 300, Block.WIDTH, Block.HEIGHT * 2));
      
      levels[0].setPlayer(new Player(Block.WIDTH, Game.HEIGHT - Block.HEIGHT*3/2, false));
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
      
      
      temp = new ArrayList<Enemy>();
      temp.add(new Toad(796, 750));
   temp.add(new Toad(496, 550));
   temp.add(new Toad(750, 550));
    
    levels[1] = new Level(new ArrayList<Block>(), temp, 0, Block.HEIGHT, new Rectangle(950, 50, Block.WIDTH, Block.HEIGHT * 2));
    levels[1].setPlayer(new Player(Block.WIDTH, Game.HEIGHT - Block.HEIGHT * 5/4, true));
    levels[1].player().setXSpeed(10);
    
    for(int i = 0; i < 20; i++)
      {
         levels[1].blocks().add(new Platform(i*Block.WIDTH, -Block.HEIGHT));
         levels[1].blocks().add(new Platform(i*Block.WIDTH, Game.HEIGHT));
      }
      
      for(int i = 0; i < 16; i++)
      {
         levels[1].blocks().add(new Platform(-Block.WIDTH, i*Block.HEIGHT));
         levels[1].blocks().add(new Platform(Game.WIDTH, i*Block.HEIGHT));
      }
      levels[1].blocks().add(new IceBlock(850, 750));
      levels[1].blocks().add(new IceBlock(900, 750));
      levels[1].blocks().add(new IceBlock(900, 700));
      levels[1].blocks().add(new IceBlock(950, 750));
      levels[1].blocks().add(new IceBlock(950, 700));
      levels[1].blocks().add(new IceBlock(950, 650));
      levels[1].blocks().add(new IceBlock(800, 600));
      levels[1].blocks().add(new IceBlock(750, 600));
      levels[1].blocks().add(new IceBlock(500, 600));
      levels[1].blocks().add(new IceBlock(450, 600));
      levels[1].blocks().add(new IceBlock(400, 600));
      levels[1].blocks().add(new IceBlock(200, 600));
      levels[1].blocks().add(new IceBlock(150, 600));
      levels[1].blocks().add(new IceBlock(100, 600));
      levels[1].blocks().add(new IceBlock(50, 600));
      levels[1].blocks().add(new IceBlock(0, 600));
      levels[1].blocks().add(new IceBlock(100, 550));
      levels[1].blocks().add(new IceBlock(0, 450));
      levels[1].blocks().add(new IceBlock(50, 500));
      levels[1].blocks().add(new IceBlock(150, 300));
      levels[1].blocks().add(new IceBlock(100, 350));
      levels[1].blocks().add(new IceBlock(200, 250));
      levels[1].blocks().add(new IceBlock(400, 250));
      levels[1].blocks().add(new IceBlock(750, 250));
      levels[1].blocks().add(new IceBlock(150, 100));
      levels[1].blocks().add(new IceBlock(500, 200));
      levels[1].blocks().add(new IceBlock(50, 200));
      levels[1].blocks().add(new IceBlock(0, 100));
      levels[1].blocks().add(new IceBlock(950, 150));
      levels[1].blocks().add(new IceBlock(850, 550));
      levels[1].blocks().add(new IceBlock(350, 550));
      levels[1].blocks().add(new IceBlock(550, 550));
      levels[1].blocks().add(new IceBlock(700, 550));
      
      temp = new ArrayList<Enemy>();
      temp.add(new Toad(72, 350));
 temp.add(new Toad(418, 450));
 temp.add(new Yoshi(457, 700));
 temp.add(new Yoshi(592, 700));
 temp.add(new Toad(839, 250));
    levels[2] = new Level(new ArrayList<Block>(), temp, 0, Block.HEIGHT, new Rectangle(950, 150, Block.WIDTH, Block.HEIGHT * 2));
      levels[2].setPlayer(new Player(0, Game.HEIGHT - Block.WIDTH * 3/2, false));
      
      
   for(int i = 0; i < 20; i++)
      {
         levels[2].blocks().add(new Platform(i*Block.WIDTH, -Block.HEIGHT));
         levels[2].blocks().add(new Platform(i*Block.WIDTH, Game.HEIGHT));
      }
      
      for(int i = 0; i < 16; i++)
      {
         levels[2].blocks().add(new Platform(-Block.WIDTH, i*Block.HEIGHT));
         levels[2].blocks().add(new Platform(Game.WIDTH, i*Block.HEIGHT));
      }
      levels[2].blocks().add(new Platform(150, 750));
 levels[2].blocks().add(new Platform(200, 750));
 levels[2].blocks().add(new Platform(200, 700));
 levels[2].blocks().add(new Platform(200, 650));
 levels[2].blocks().add(new Platform(250, 650));
 levels[2].blocks().add(new Platform(250, 600));
 levels[2].blocks().add(new Platform(250, 550));
 levels[2].blocks().add(new Platform(300, 550));
 levels[2].blocks().add(new Platform(350, 550));
 levels[2].blocks().add(new GreenBlock(300, 500));
 levels[2].blocks().add(new GreenBlock(350, 500));
 levels[2].blocks().add(new GreenBlock(350, 450));
 levels[2].blocks().add(new GreenBlock(400, 500));
 levels[2].blocks().add(new GreenBlock(400, 550));
 levels[2].blocks().add(new GreenBlock(450, 550));
 levels[2].blocks().add(new GreenBlock(450, 500));
 levels[2].blocks().add(new GreenBlock(500, 500));
 levels[2].blocks().add(new GreenBlock(550, 500));
 levels[2].blocks().add(new GreenBlock(500, 550));
 levels[2].blocks().add(new GreenBlock(550, 550));
 levels[2].blocks().add(new GreenBlock(600, 500));
 levels[2].blocks().add(new GreenBlock(650, 500));
 levels[2].blocks().add(new GreenBlock(600, 450));
 levels[2].blocks().add(new GreenBlock(200, 400));
 levels[2].blocks().add(new GreenBlock(150, 400));
 levels[2].blocks().add(new GreenBlock(150, 350));
 levels[2].blocks().add(new Platform(100, 400));
 levels[2].blocks().add(new Platform(50, 400));
 levels[2].blocks().add(new Platform(0, 400));
 levels[2].blocks().add(new Platform(700, 550));
 levels[2].blocks().add(new Platform(800, 650));
 levels[2].blocks().add(new Platform(900, 700));
 levels[2].blocks().add(new Platform(950, 700));
 levels[2].blocks().add(new Platform(950, 650));
 levels[2].blocks().add(new Platform(950, 750));
 levels[2].blocks().add(new Platform(950, 600));
 levels[2].blocks().add(new Platform(950, 550));
 levels[2].blocks().add(new GreenBlock(950, 500));
 levels[2].blocks().add(new GreenBlock(900, 500));
 levels[2].blocks().add(new GreenBlock(850, 450));
 levels[2].blocks().add(new GreenBlock(800, 450));
 levels[2].blocks().add(new GreenBlock(800, 400));
 levels[2].blocks().add(new GreenBlock(800, 350));
 levels[2].blocks().add(new GreenBlock(800, 300));
 levels[2].blocks().add(new GreenBlock(850, 300));
 levels[2].blocks().add(new GreenBlock(850, 350));
 levels[2].blocks().add(new GreenBlock(850, 400));
 levels[2].blocks().add(new GreenBlock(900, 450));
 levels[2].blocks().add(new GreenBlock(900, 400));
 levels[2].blocks().add(new GreenBlock(950, 450));
 levels[2].blocks().add(new GreenBlock(950, 400));
 levels[2].blocks().add(new GreenBlock(950, 350));
 levels[2].blocks().add(new GreenBlock(900, 350));
 levels[2].blocks().add(new GreenBlock(900, 300));
 levels[2].blocks().add(new GreenBlock(950, 300));
 levels[2].blocks().add(new GreenBlock(950, 250));
 levels[2].blocks().add(new GreenBlock(900, 250));
 levels[2].blocks().add(new Platform(0, 300));
 levels[2].blocks().add(new Platform(0, 100));
 levels[2].blocks().add(new GreenBlock(100, 200));
 levels[2].blocks().add(new GreenBlock(150, 200));
 levels[2].blocks().add(new GreenBlock(150, 150));
 levels[2].blocks().add(new GreenBlock(200, 150));
 levels[2].blocks().add(new GreenBlock(250, 150));
 levels[2].blocks().add(new Platform(200, 200));
 levels[2].blocks().add(new Platform(250, 200));
 levels[2].blocks().add(new Platform(450, 200));
 levels[2].blocks().add(new Platform(600, 200));
 levels[2].blocks().add(new GreenBlock(450, 150));
 levels[2].blocks().add(new GreenBlock(600, 150));
 levels[2].blocks().add(new GreenBlock(750, 250));
 
 temp = new ArrayList<Enemy>();
 levels[3] = new Level(new ArrayList<Block>(), temp, -Block.WIDTH, -Block.HEIGHT, new Rectangle(0, 0, Block.WIDTH * 4, Block.HEIGHT * 4));
      levels[3].setPlayer(new Player(0, Game.HEIGHT - Block.HEIGHT * 3/2, true));
      
      for(int i = 0; i < 20; i++)
      {
         levels[3].blocks().add(new Platform(i*Block.WIDTH, -Block.HEIGHT));
         levels[3].blocks().add(new Platform(i*Block.WIDTH, Game.HEIGHT));
      }
      
      for(int i = 0; i < 16; i++)
      {
         levels[3].blocks().add(new Platform(-Block.WIDTH, i*Block.HEIGHT));
         levels[3].blocks().add(new Platform(Game.WIDTH, i*Block.HEIGHT));
      }
      levels[3].blocks().add(new RedBlock(950, 700));
 levels[3].blocks().add(new RedBlock(850, 600));
 levels[3].blocks().add(new RedBlock(800, 600));
 levels[3].blocks().add(new RedBlock(750, 600));
 levels[3].blocks().add(new RedBlock(700, 600));
 levels[3].blocks().add(new RedBlock(650, 600));
 levels[3].blocks().add(new RedBlock(600, 600));
 levels[3].blocks().add(new RedBlock(500, 600));
 levels[3].blocks().add(new RedBlock(550, 600));
 levels[3].blocks().add(new RedBlock(450, 600));
 levels[3].blocks().add(new RedBlock(400, 600));
 levels[3].blocks().add(new RedBlock(350, 600));
 levels[3].blocks().add(new RedBlock(250, 600));
 levels[3].blocks().add(new RedBlock(300, 600));
 levels[3].blocks().add(new RedBlock(200, 600));
 levels[3].blocks().add(new RedBlock(150, 600));
 levels[3].blocks().add(new RedBlock(100, 600));
 levels[3].blocks().add(new RedBlock(0, 500));
 levels[3].blocks().add(new RedBlock(200, 400));
 levels[3].blocks().add(new RedBlock(250, 400));
 levels[3].blocks().add(new RedBlock(300, 400));
 levels[3].blocks().add(new RedBlock(350, 400));
 levels[3].blocks().add(new RedBlock(450, 400));
 levels[3].blocks().add(new RedBlock(400, 400));
 levels[3].blocks().add(new RedBlock(500, 400));
 levels[3].blocks().add(new RedBlock(600, 400));
 levels[3].blocks().add(new RedBlock(550, 400));
 levels[3].blocks().add(new RedBlock(650, 400));
 levels[3].blocks().add(new RedBlock(700, 400));
 levels[3].blocks().add(new RedBlock(800, 400));
 levels[3].blocks().add(new RedBlock(750, 400));
 levels[3].blocks().add(new RedBlock(850, 400));
 levels[3].blocks().add(new RedBlock(950, 300));
 levels[3].blocks().add(new RedBlock(100, 400));
 levels[3].blocks().add(new RedBlock(150, 400));
 levels[3].blocks().add(new RedBlock(850, 200));
 levels[3].blocks().add(new RedBlock(800, 200));
 levels[3].blocks().add(new RedBlock(750, 200));
 levels[3].blocks().add(new RedBlock(700, 200));
 levels[3].blocks().add(new RedBlock(650, 200));
 levels[3].blocks().add(new RedBlock(600, 200));
 levels[3].blocks().add(new RedBlock(550, 200));
 levels[3].blocks().add(new RedBlock(500, 200));
 levels[3].blocks().add(new RedBlock(450, 200));
 levels[3].blocks().add(new RedBlock(400, 200));
 levels[3].blocks().add(new RedBlock(350, 200));
 levels[3].blocks().add(new RedBlock(300, 200));
 levels[3].blocks().add(new RedBlock(250, 200));
 levels[3].blocks().add(new RedBlock(150, 200));
 levels[3].blocks().add(new RedBlock(200, 200));
 levels[3].blocks().add(new RedBlock(100, 200));
 levels[3].blocks().add(new RedBlock(50, 200));
 levels[3].blocks().add(new RedBlock(0, 200));
   }   
   
   public void display(Graphics g)
   {
      if(currLevel == -1)
         displayLevelSelect(g);
      else
      {
         levels[currLevel].display(g);
         if(paused)
            ;//displayMenu(g);
         else
            levels[currLevel].update();
         
         lives = levels[currLevel].player().lives();
      }
   }
   
   private void displayLevelSelect(Graphics g)
   {
      g.drawImage(Images.levelSelectImage, 0, 0, Game.WIDTH, Game.HEIGHT, null);
   }
   
   private void displayMenu(Graphics g)
   {
      
   }
   
   public void displayWinScreen(Graphics g)
   {
      g.setColor(Color.white);
      g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
      
      g.setColor(Color.black);
      g.drawString("You win!", Game.WIDTH/2 - 70, Game.HEIGHT/2);
   }
   
   public void displayDeathScreen(Graphics g)
   {
      g.setColor(Color.black);
      g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
      
      g.setColor(Color.white);
      g.drawString("You died!", Game.WIDTH/2 - 70, Game.HEIGHT/2);
      g.drawString("Press ENTER to restart.", Game.WIDTH/2 - 70, Game.HEIGHT/2+15);
   }
   
   public Level currLevel()
   {
      if(currLevel != -1)
         return levels[currLevel];
      return null;
   }
   
   public int levelNum(){return currLevel;}
   
   public Level[] levels(){return levels;}
   
   public void pause()
   {
      paused = !paused;
      if(currLevel != -1)
         levels[currLevel].pause();
   }
   
   public boolean paused(){return paused;}
   
   public int lives(){return lives;}
   
   public void selectLevel(int l)
   {
      if(currLevel != -1)
      {
         levels[currLevel].reset();
      }
      
      if(l == -1)
         paused = true;
      else
      {
         levels[l].player().setLives(lives);
         paused = false;
      }
         
      currLevel = l;
   }
}