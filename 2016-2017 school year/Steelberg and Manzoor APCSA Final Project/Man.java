/**
Charles Steelberg
Morgan Petrie
Afeeah Manzoor 

APCSA Final Project
*/
public class Man extends King {
	public Man(int xPos, int yPos, boolean teamColor) {
		super(xPos, yPos, teamColor); //calls current pos and color
	}

	public void move(int dir, boolean isJumping) {
		if (dir == 4) {
			if (this.getX() == 0) {
				return;
			}
			if (!super.getTeam()) {
				if (isJumping && this.getX() != 1) {
					super.setX(this.getX() - 2); //sets new x
					super.setY(this.getY() - 2); //sets new y
				} else {
					super.setX(this.getX() - 1); //sets new x
					super.setY(this.getY() - 1); //xets new y
				}
			} else {
				if (isJumping && this.getX() != 1) {
					super.setX(this.getX() - 2); //sets new x
					super.setY(this.getY() + 2); //sets new y
				} else {
					super.setX(this.getX() - 1); //sets new x
					super.setY(this.getY() + 1); //sets new y
				}
			}
		} else if (dir == 6) {
			if (this.getX() == 7) {
				return;
			}
			if (!super.getTeam()) {
				if (isJumping && this.getX() != 6) {
					super.setX(this.getX() + 2); //sets new x
					super.setY(this.getY() - 2); //sets new y
				} else {
					super.setX(this.getX() + 1); //sets new x
					super.setY(this.getY() - 1); //sets new y
				}
			} else {
				if (isJumping && this.getX() != 6) {
					super.setX(this.getX() + 2); //sets new x
					super.setY(this.getY() + 2); //sets new y
				} else {
					super.setX(this.getX() + 1); //sets new x
					super.setY(this.getY() + 1); //sets new y 
				}
			}
		}
	}

	public boolean isKing() {
		return false; //not king
	}
}