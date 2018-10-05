package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
	
	Image background;
	Image playNow;
	Image exitGame;
	
	public Menu(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("res/world_map.png");
		playNow = new Image("res/play_now.png");
		exitGame = new Image("res/exit_game.png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0, 0);
		playNow.draw(100, 100);
		exitGame.draw(100, 200);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		if ((posX > 100 && posX < 311) && (posY > 209 && posY < 260)) {
			if (Mouse.isButtonDown(0)) {
				sbg.initStatesList(gc);
				sbg.enterState(1);
			}
		}
		
		if ((posX > 100 && posX < 311) && (posY > 109 && posY < 160)) {
			if (Mouse.isButtonDown(0)) {
				System.exit(0);
			}
		}
	}
	
	public int getID() {
		return 0;
	}
}