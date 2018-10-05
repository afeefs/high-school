package javagame;

//import org.newdawn.slick.*;
//import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
	
	Animation mario, movingUp, movingDown, movingLeft, movingRight;
	Image worldMap;
	boolean quit = false;
	int[] duration = {200};
	float marioPositionX = 0;
	float marioPositionY = 0;
	float shiftX = marioPositionX + 0;
	float shiftY = marioPositionY + 260;
	Image finished_game;
	boolean finish = false;
	int jump = 0;
	
	public Play(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		worldMap = new Image("res/world_map.png");
		
		Image[] walkUp = {new Image("res/mario_right.png")};
		Image[] walkDown = {new Image("res/mario_right.png")};
		Image[] walkLeft = {new Image("res/mario_left.png")};
		Image[] walkRight = {new Image("res/mario_right.png")};
	
		movingUp = new Animation(walkUp, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		
		mario = movingRight;
		
		marioPositionX = 0;
		marioPositionY = 0;
		
		finished_game = new Image("res/space.png");
		finished_game.draw(250, 150);
		
		finish = false;
		jump = 0;
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		worldMap.draw(marioPositionX, marioPositionY);
		mario.draw(shiftX, shiftY);
		
		g.drawString("X: " + marioPositionX + ", Y: " + marioPositionY, 420, 10);
		
		if (quit == true) {
			g.drawString("Devam (R)", 450, 50);
			g.drawString("Ana Menu (M)", 450, 100);
			g.drawString("Cikis (Q)", 450, 150);
			
			if (quit == false) {
				g.clear();
			}
		}
		
		if ((marioPositionX >= -208 && marioPositionX <= -207) && marioPositionY >= 211 && marioPositionY <= 212) {
			finish = true;
			finished_game = new Image("res/finish.png");
			finished_game.draw(250, 150);
		}
		
		if (marioPositionX >= -208 && marioPositionX <= -207) {
			marioPositionY += .1f;
		}
		
		if (marioPositionY >= 212) {
			marioPositionY = 212;
		}
		
		if (jump == 1) {
			marioPositionY += .2f;
			
			if (marioPositionY >= 150) {
				jump = 2;
				marioPositionY = 150;
			}
		}
		else if (jump == 2) {
			marioPositionY -= .2f;
			
			if (marioPositionY <= 0) {
				jump = 0;
				marioPositionY = 0;
			}
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		
		if (input.isKeyDown(Input.KEY_UP)) {
			if (finish) {
				return;
			}
			
			jump = 1;
		}
		
		if (input.isKeyDown(Input.KEY_DOWN)) {
			if (finish) {
				return;
			}
			
			mario = movingDown;
			marioPositionY -= delta * .1f;
			
			if (marioPositionY < 0) {
				marioPositionY += delta * .1f;
			}
		}
		
		if (input.isKeyDown(Input.KEY_LEFT)) {
			if (finish) {
				return;
			}
			
			mario = movingLeft;
			marioPositionX += delta * .1f;
			
			if (marioPositionX > 0) {
				marioPositionX -= delta * .1f;
			}
		}
		
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			if (finish) {
				return;
			}
			
			mario = movingRight;
			marioPositionX -= delta * .1f;
			
			if (marioPositionX < -208) {
				marioPositionX += delta * .1f;
			}
		}
		
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			quit = true;
			finished_game = new Image("res/space.png");
			finished_game.draw(250, 150);
		}
		
		if (quit == true) {
			if (input.isKeyDown(Input.KEY_R)) {
				quit = false;
			}
			
			if (input.isKeyDown(Input.KEY_M)) {
				quit = false;
				sbg.enterState(0);
			}
			
			if (input.isKeyDown(Input.KEY_Q)) {
				System.exit(0);
			}
		}
	}
	
	public int getID() {
		return 1;
	}
}