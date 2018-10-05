/**
Charles Steelberg
Morgan Petrie
Afeeah Manzoor 

APCSA Final Project
*/
public class King extends Player {
	private int x;
	private int y;
	private boolean redTeam;

	public King(int xPos, int yPos, boolean teamColor) { // true = red false =
															// black
		x = xPos; //sets x
		y = yPos; //sets y
		redTeam = teamColor; //sets color
	}

	public int getX() {
		return x; //retuns x pos
	}

	public int getY() {
		return y; //returns y pos
	}

	public boolean getTeam() {
		return redTeam; //returns what team it is
	}

	public void move(int dir, boolean isJumping) {
		if(!isJumping){ //if the piece cannot jump
			if (dir == 7) {
				setX(this.getX() - 1); //sets new x
				setY(this.getY() - 1); //sets new y
			} else if (dir == 9) {
				setX(this.getX() + 1); //sets new x
				setY(this.getY() - 1); //sets new y
			} else if (dir == 1) {
				setX(this.getX() - 1); //sets new x
				setY(this.getY() + 1); //sets new y
			} else if (dir == 3) {
				setX(this.getX() + 1);//sets new x
				setY(this.getY() + 1); //sets new y
			}
		}
		else {
			if (dir == 7) {
				setX(this.getX() - 2); //sets new x
				setY(this.getY() - 2); //sets new y
			} else if (dir == 9) {
				setX(this.getX() + 2); //sets new x
				setY(this.getY() - 2); //sets new y
			} else if (dir == 1) {
				setX(this.getX() - 2); //sets new x
				setY(this.getY() + 2); //sets new y
			} else if (dir == 3) {
				setX(this.getX() + 2);//sets new x
				setY(this.getY() + 2); //sets new y
			}
		}
	}

	public boolean isKing() {
		return true; //r=makes piece a king
	}

	public boolean jump() {
		return false;
	}

	public void setX(int newX) {
		x = newX;
	}

	public void setY(int newY) {
		y = newY;
	}
}