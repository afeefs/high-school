import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JFrame;
import java.applet.Applet;
/**
Charles Steelberg
Morgan Petrie
Afeeah Manzoor 

APCSA Final Project
*/

public class Board extends Applet implements MouseListener {
	Graphics bufferGraphics;
	Image offscreen;
	Dimension dim = new Dimension(800, 800); //sets size of the applet
	Player[][] board = new Player[8][8]; //Array for board
	ArrayList<Player> listOfPlayers = new ArrayList<Player>(); //arrayLiist of players
	int startNum = 0; //resets game
	boolean isFirstClick = true; //checks the piece selected
	int playerNum = -1;
	boolean BluePlayerTurn = true; //boolean for who's turn
	boolean startScreen = true; //start screen appears first then doeas not show

	public void init() {
		dim = getSize();
		setBackground(Color.black); //sets background color
		offscreen = createImage(800, 800); //sets size of applet
		bufferGraphics = offscreen.getGraphics(); 
		addMouseListener(this); 
		resetGame();
	}

	public void paint(Graphics g) {
		resize(800, 800); //resizes board
		drawBoard(); //draws board
		drawPieces(); //draws pieces
		updateBoard(); //updates board
		bufferGraphics.setColor(Color.black); //sets background to black
		bufferGraphics.drawRect(0, 0, 800, 800); //draws black square
		if(startScreen){ //start screen opens first
			bufferGraphics.setColor(Color.red); //sets color red
			bufferGraphics.setFont(new Font("Ariel", Font.PLAIN, 80)); //sets font and color
			bufferGraphics.drawString("Checkers", 250, 200+160); //draws checkers
			bufferGraphics.setFont(new Font("Ariel", Font.PLAIN, 40)); //sets new font size
         //draws credits
			bufferGraphics.drawString("Made By:", 335, 235+160); 
			bufferGraphics.drawString("Charles, ", 345, 270+160);
			bufferGraphics.drawString("Afeefah, ", 344, 305+160);
			bufferGraphics.drawString("And Morgan!", 310, 340+160);
		}
		else{
			drawBoard(); //draws board
			drawPieces(); //draws pieces
			updateBoard(); //updates board
			if (gameOver() == -1) { //checks if blue piece is left
				//setVisible(false); //is not visible
				JFrame frame = new JFrame("GameOver Blue Wins"); //creates new frame
				frame.setSize(400, 20); //sets frame size
				frame.setLocation(252, 350); //sets location 
				frame.setVisible(true); //maekes frame visible
			} else if (gameOver() == 1) { //checks if red piece is red
				//setVisible(false); //is not visible
				JFrame frame = new JFrame("GameOver Red Wins"); //creates new frame
				frame.setSize(400, 20); //sets size
				frame.setLocation(252, 350); //sets location
				frame.setVisible(true);//makes frame visible
			}
		}
				g.drawImage(offscreen, 0, 0, this);  //calls the image that was drew offscreen and draws it
	}

	public void drawBoard() {
		for (int i = 0; i <= 8; i++) { // loops the rows
			for (int k = 0; k <= 8; k++) { // loops the columns
         //makes every other square black
				if (i % 2 == 0) {
					if (k % 2 == 0) {
						bufferGraphics.setColor(Color.black);
						bufferGraphics.fillRect(i * 100, k * 100, 100, 100);
					}
				}
				if (i % 2 == 1) {
					if (k % 2 == 1) {
						bufferGraphics.setColor(Color.black);
						bufferGraphics.fillRect(i * 100, k * 100, 100, 100);
					}
				}
			}
		}
	}

	public void drawPieces() {
		Color red2 = new Color(180, 5, 5); //creates new red color
		Color purp = new Color(49, 123, 234); //creates new blue color
		for (int rows = 0; rows < 8; rows++) {
			for (int cols = 0; cols < 8; cols++) {
				if (locationType(cols, rows) == 1) { //checks to see if piece is Blue
					bufferGraphics.setColor(purp); //sets color to blue
					bufferGraphics.fillOval(cols * 100, rows * 100, 100, 100); //creates the Man piece
               //lets the playerknow the blue piece is King
					if (((King) board[cols][rows]).isKing()) { //checks if piece has reached the opposite side
						bufferGraphics.setColor(new Color (222,165,78)); //sets text color
						bufferGraphics.setFont(new Font("Ariel", Font.PLAIN, 50)); //sets text font and size
						bufferGraphics.drawString("K", (cols * 100) + 45, (rows * 100) + 70); //draaws the'K' for King
					}
				} else if (locationType(cols, rows) == 2) { //checks to see if piece is Red
					bufferGraphics.setColor(red2); //sets the color to red
					bufferGraphics.fillOval(cols * 100, rows * 100, 100, 100); //makes the Man pieces
               //lets the player know the red piece is King
					if (((King) board[cols][rows]).isKing()) { //checks if piece has reached the opposite side
						bufferGraphics.setColor(new Color (222,165,78)); //sets text color
                  bufferGraphics.setFont(new Font("Ariel", Font.PLAIN, 50)); //sets text font and size
						bufferGraphics.drawString("K", (cols * 100) + 45, (rows * 100) + 70); //draws the "K" for King
					}
				}
			}
		}
	}

	public void resetGame() { //resets the game
		if (startNum == 0) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < this.board[0].length; j++) {
					if (i % 2 == 1) {
						if (j % 2 == 1)
							this.listOfPlayers.add(new Man(j, i, true));
					}
					if (i % 2 == 0) {
						if (j % 2 == 0)
							listOfPlayers.add(new Man(j, i, true));
					}
				}
			}
			for (int i = 5; i < 8; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (i % 2 == 0) {
						if (j % 2 == 0) {
							listOfPlayers.add(new Man(j, i, false));
						}
					}
					if (i % 2 == 1) {
						if (j % 2 == 1) {
							listOfPlayers.add(new Man(j, i, false));
						}
					}
				}
			}
			startNum++;
		}
	}

	public void updateBoard() { //updates board
		for (int i = 0; i < 8; i++) {
			for (int k = 0; k < 8; k++) {
				board[i][k] = null;
			}
		}
		for (int i = 0; i < listOfPlayers.size(); i++) { //loops through list of all the players
			board[(((King) listOfPlayers.get(i)).getX())][(((King) listOfPlayers.get(i)).getY())] = listOfPlayers
					.get(i); //updates list of players
		}
	}

	public int locationType(int row, int col) { //checks if who is on that square
		if (board[row][col] == null) //0 if no one
			return 0;
		else if (board[row][col].getTeam()) //1 if blue
			return 1;
		else //2 if red
			return 2;
	}

	public int countRedPlayers() { //counts how many red plays are on the board
		int counter = 0;
		for (int i = 0; i < listOfPlayers.size(); i++) {
			if (((King) listOfPlayers.get(i)).getTeam() != true) {
				counter++;
			}
		}
		return counter;
	}

	public int countBluePlayers() { //counts how mant blue players are on the board
		int counter = 0;
		for (int i = 0; i < listOfPlayers.size(); i++) {
			if (((King) listOfPlayers.get(i)).getTeam() == true) {
				counter++;
			}
		}
		return counter;
	}

	public int gameOver() { //sees who is lthe last piece on the board and returns loser
		if (countBluePlayers() <= 0)
			return 1;
		else if (countRedPlayers() <= 0)
			return -1;
		else
			return 0;
	}

	private void selectPiece(int x, int y) { //selects piece
		for (int i = 0; i < listOfPlayers.size(); i++) { //loops through list of players
			if (((King) listOfPlayers.get(i)).getX() == x) { //checks if X matches
				if (((King) listOfPlayers.get(i)).getY() == y) { //check if Y matches 
					if (((King) listOfPlayers.get(i)).getTeam() == true) {//if it is the right team selected
						isFirstClick = false; //piece is selected
						playerNum = i; //sets player number
					} else {
						isFirstClick = false;
						playerNum = i;
					}
				}
			}
		}
	}

	public void mouseClicked(MouseEvent me) {
		int x = (int) (me.getX() / 100); //sets x
		int y = (int) (me.getY() / 100); //sets y
		startScreen=false; //start screan is disappears
		if (isFirstClick == false) { //if selected
			selectSpot(x, y, playerNum); //calls select spot
		} else if (x % 2 == 1 && y % 2 == 1) {
			selectPiece(x, y);
		} else if (x % 2 == 0 && y % 2 == 0) {
			selectPiece(x, y);
		}
		if (BluePlayerTurn) { //if blue turn the "white" tiles blue
			bufferGraphics.setColor(Color.blue);
			bufferGraphics.fillRect(0, 0, 800, 800);
		} else {
			bufferGraphics.setColor(Color.red); //if red turn the "white" tiles red
			bufferGraphics.fillRect(0, 0, 800, 800);
		}
		repaint(); //repaint the frame
	}

	public void mousePressed(MouseEvent me) {
	}

	public void mouseReleased(MouseEvent me) {
	}

	public void mouseEntered(MouseEvent me) {
	}

	public void mouseExited(MouseEvent me) {
	}

	private void selectSpot(int x, int y, int pieceNum) {
      //sets where piece wants to move
		int x2 = ((King) listOfPlayers.get(pieceNum)).getX(); 
		int y2 = ((King) listOfPlayers.get(pieceNum)).getY(); 
		boolean team = ((King) listOfPlayers.get(pieceNum)).getTeam(); //sets what color is playing
		boolean hasMoved = false; 

		if (((King) listOfPlayers.get(pieceNum)).isKing()) {
			System.out.print("Is King");

			if (x == ((King) listOfPlayers.get(pieceNum)).getX() - 1
					|| x == ((King) listOfPlayers.get(pieceNum)).getX() - 2) {

				if (y == ((King) listOfPlayers.get(pieceNum)).getY() - 1
						|| y == ((King) listOfPlayers.get(pieceNum)).getY() - 2) { //7
					if (y2 != 1 && x2 != 1) {
						for (int i = 0; i < listOfPlayers.size(); i++) {
							if (x2 - 1 == ((King) listOfPlayers.get(i)).getX()
									&& y2 - 1 == ((King) listOfPlayers.get(i)).getY()
									&& ((King) listOfPlayers.get(pieceNum)).getTeam() != ((King) listOfPlayers.get(i))
											.getTeam()
									&& board[x2 - 2][y2 - 2] == null
									&& ((King) listOfPlayers.get(pieceNum)).getTeam() == BluePlayerTurn) {

								((King) listOfPlayers.get(pieceNum)).move(7, true); //new piece is placed
								listOfPlayers.remove(i); //removes previous piece
								updateBoard(); //updates board
								board[x2 - 1][y2 - 1] = null; //makes that space empty
								hasMoved = true; //sets that piece has moved
								BluePlayerTurn = !BluePlayerTurn; //changes turn
								repaint(); //repaints frame
							}

						}
					}
					if (!hasMoved && board[x2 - 1][y2 - 1] == null
							&& ((King) listOfPlayers.get(pieceNum)).getTeam() == BluePlayerTurn) {
						((King) listOfPlayers.get(pieceNum)).move(7, false);
						BluePlayerTurn = !BluePlayerTurn;
						repaint();
					}
				} else if (y == ((King) listOfPlayers.get(pieceNum)).getY() + 1
						|| y == ((King) listOfPlayers.get(pieceNum)).getY() + 2) {
					if (y2 != 6 && x2 != 1) {
						for (int i = 0; i < listOfPlayers.size(); i++) {
							if (x2 - 1 == ((King) listOfPlayers.get(i)).getX()
									&& y2 + 1 == ((King) listOfPlayers.get(i)).getY()
									&& ((King) listOfPlayers.get(pieceNum)).getTeam() != ((King) listOfPlayers.get(i)) //1
											.getTeam()
									&& board[x2 - 2][y2 + 2] == null
									&& ((King) listOfPlayers.get(pieceNum)).getTeam() == BluePlayerTurn) {

								((King) listOfPlayers.get(pieceNum)).move(1, true); //piece is selected "moves"
								listOfPlayers.remove(i); //previous piece is removed
								updateBoard(); //board is updated
								board[x2 - 1][y2 + 1] = null; //prevouis spot is unoccupied
								hasMoved = true; //piece is moved
								BluePlayerTurn = !BluePlayerTurn; //player turn changes
								repaint(); //repaints
							}
						}
					}
					if (!hasMoved && board[x2 - 1][y2 + 1] == null
							&& ((King) listOfPlayers.get(pieceNum)).getTeam() == BluePlayerTurn) {
						((King) listOfPlayers.get(pieceNum)).move(1, false);
						BluePlayerTurn = !BluePlayerTurn;
						repaint();
					}
				}
			}

			else if (x == ((King) listOfPlayers.get(pieceNum)).getX() + 1
					|| x == ((King) listOfPlayers.get(pieceNum)).getX() + 2) {// 3

				if (y == ((King) listOfPlayers.get(pieceNum)).getY() + 1
						|| y == ((King) listOfPlayers.get(pieceNum)).getY() + 2) {
					if (y2 != 6 && x2 != 6) {
						for (int i = 0; i < listOfPlayers.size(); i++) {
							if (x2 + 1 == ((King) listOfPlayers.get(i)).getX()
									&& y2 + 1 == ((King) listOfPlayers.get(i)).getY()
									&& ((King) listOfPlayers.get(pieceNum)).getTeam() != ((King) listOfPlayers.get(i))
											.getTeam()
									&& board[x2 + 2][y2 + 2] == null
									&& ((King) listOfPlayers.get(pieceNum)).getTeam() == BluePlayerTurn) {

								((King) listOfPlayers.get(pieceNum)).move(3, true);
								listOfPlayers.remove(i);
								updateBoard();
								board[x2 + 1][y2 + 1] = null;
								hasMoved = true;
								BluePlayerTurn = !BluePlayerTurn;
								repaint();
							}
						}
					}
					if (!hasMoved && board[x2 + 1][y2 + 1] == null
							&& ((King) listOfPlayers.get(pieceNum)).getTeam() == BluePlayerTurn) {
						((King) listOfPlayers.get(pieceNum)).move(3, false);
						BluePlayerTurn = !BluePlayerTurn;
						repaint();
					}
				} else if (y == ((King) listOfPlayers.get(pieceNum)).getY() - 1
						|| y == ((King) listOfPlayers.get(pieceNum)).getY() - 2) {// 9
					if (y2 != 1 && x2 != 7) {
						for (int i = 0; i < listOfPlayers.size(); i++) {
							if (x2 + 1 == ((King) listOfPlayers.get(i)).getX()
									&& y2 - 1 == ((King) listOfPlayers.get(i)).getY()
									&& ((King) listOfPlayers.get(pieceNum)).getTeam() != ((King) listOfPlayers.get(i))
											.getTeam()
									&& board[x2 + 2][y2 - 2] == null
									&& ((King) listOfPlayers.get(pieceNum)).getTeam() == BluePlayerTurn) {

								((King) listOfPlayers.get(pieceNum)).move(9, true);
								listOfPlayers.remove(i);
								updateBoard();
								board[x2 + 1][y2 - 1] = null;
								hasMoved = true;
								BluePlayerTurn = !BluePlayerTurn;
								repaint();
							}
						}
					}
					if (!hasMoved && board[x2 + 1][y2 - 1] == null
							&& ((King) listOfPlayers.get(pieceNum)).getTeam() == BluePlayerTurn) {
						((King) listOfPlayers.get(pieceNum)).move(9, false);
						BluePlayerTurn = !BluePlayerTurn;
						repaint();
					}
				}
			}
		}

		else if (x == ((King) listOfPlayers.get(pieceNum)).getX() - 1
				|| x == ((King) listOfPlayers.get(pieceNum)).getX() - 2)

		{
			for (int i = 0; i < listOfPlayers.size(); i++) {
				if (!((King) listOfPlayers.get(pieceNum)).getTeam() && ((King) listOfPlayers.get(pieceNum)).getY() != 1 && ((King) listOfPlayers.get(pieceNum)).getX() != 1
						&& x2 - 1 == ((King) listOfPlayers.get(i)).getX()
						&& y2 - 1 == ((King) listOfPlayers.get(i)).getY()
						&& ((King) listOfPlayers.get(pieceNum)).getTeam() != ((King) listOfPlayers.get(i)).getTeam()
						&& board[x2 - 2][y2 - 2] == null
						&& ((King) listOfPlayers.get(pieceNum)).getTeam() == BluePlayerTurn) {

					((King) listOfPlayers.get(pieceNum)).move(4, true);
					listOfPlayers.remove(i);// red
					updateBoard();
					board[x2 - 1][y2 - 1] = null;
					hasMoved = true;
					BluePlayerTurn = !BluePlayerTurn;
					repaint();
				} else if (((King) listOfPlayers.get(pieceNum)).getTeam() && y2 != 6 && x2 != 1
						&& x2 - 1 == ((King) listOfPlayers.get(i)).getX()
						&& y2 + 1 == ((King) listOfPlayers.get(i)).getY()
						&& ((King) listOfPlayers.get(pieceNum)).getTeam() != ((King) listOfPlayers.get(i)).getTeam()
						&& board[x2 - 2][y2 + 2] == null
						&& ((King) listOfPlayers.get(pieceNum)).getTeam() == BluePlayerTurn) {

					((King) listOfPlayers.get(pieceNum)).move(4, true);
					listOfPlayers.remove(i);// blue
					updateBoard();
					board[x2 - 1][y2 + 1] = null;
					hasMoved = true;
					BluePlayerTurn = !BluePlayerTurn;
					repaint();
				}
			}
			if (!hasMoved && ((King) listOfPlayers.get(pieceNum)).getTeam() == BluePlayerTurn
					&& ((((King) listOfPlayers.get(pieceNum)).getTeam() && board[x2 - 1][y2 + 1] == null
							|| (!((King) listOfPlayers.get(pieceNum)).getTeam() && board[x2 - 1][y2 - 1] == null)))) {
				((King) listOfPlayers.get(pieceNum)).move(4, false);
				BluePlayerTurn = !BluePlayerTurn;
				repaint();
			}

		} else if (x == ((King) listOfPlayers.get(pieceNum)).getX() + 1
				|| x == ((King) listOfPlayers.get(pieceNum)).getX() + 2) {
			for (int i = 0; i < listOfPlayers.size(); i++) {
				if (!((King) listOfPlayers.get(pieceNum)).getTeam() && y2 != 1 && x2 != 6
						&& x2 + 1 == ((King) listOfPlayers.get(i)).getX()
						&& y2 - 1 == ((King) listOfPlayers.get(i)).getY()
						&& ((King) listOfPlayers.get(pieceNum)).getTeam() != ((King) listOfPlayers.get(i)).getTeam()
						&& board[x2 + 2][y2 - 2] == null
						&& ((King) listOfPlayers.get(pieceNum)).getTeam() == BluePlayerTurn) {

					((King) listOfPlayers.get(pieceNum)).move(6, true);
					listOfPlayers.remove(i);
					updateBoard();
					board[x2 + 1][y2 - 1] = null;
					hasMoved = true;
					BluePlayerTurn = !BluePlayerTurn;
					repaint();
				} else if (((King) listOfPlayers.get(pieceNum)).getTeam() && y2 != 6 && x2 != 6
						&& x2 + 1 == ((King) listOfPlayers.get(i)).getX()
						&& y2 + 1 == ((King) listOfPlayers.get(i)).getY()
						&& ((King) listOfPlayers.get(pieceNum)).getTeam() != ((King) listOfPlayers.get(i)).getTeam()
						&& board[x2 + 2][y2 + 2] == null
						&& ((King) listOfPlayers.get(pieceNum)).getTeam() == BluePlayerTurn) {
					((King) listOfPlayers.get(pieceNum)).move(6, true);
					listOfPlayers.remove(i);
					updateBoard();
					board[x2 + 1][y2 + 1] = null;
					hasMoved = true;
					BluePlayerTurn = !BluePlayerTurn;
					repaint();
				}
			}
			if (!hasMoved && ((King) listOfPlayers.get(pieceNum)).getTeam() == BluePlayerTurn
					&& ((((King) listOfPlayers.get(pieceNum)).getTeam() && (board[x2 + 1][y2 + 1] == null)
							|| (!((King) listOfPlayers.get(pieceNum)).getTeam() && board[x2 + 1][y2 - 1] == null)))) {
				((King) listOfPlayers.get(pieceNum)).move(6, false);
				BluePlayerTurn = !BluePlayerTurn;
				repaint();
			}
		}
		board[x2][y2] = null;
		isFirstClick = true;
		playerNum = -1;
		for (int i = 0; i < listOfPlayers.size(); i++) {
			if (((King) listOfPlayers.get(i)).getX() == x && ((King) listOfPlayers.get(i)).getY() == y
					&& ((King) listOfPlayers.get(i)).getTeam() == team) {
				if (((King) listOfPlayers.get(i)).getTeam() && ((King) listOfPlayers.get(i)).getY() == 7) {
					this.listOfPlayers.add(
							new King(((King) listOfPlayers.get(i)).getX(), ((King) listOfPlayers.get(i)).getY(), true));
					listOfPlayers.remove(i);
					updateBoard();
				}
				if (!((King) listOfPlayers.get(i)).getTeam() && ((King) listOfPlayers.get(i)).getY() == 0) {
					this.listOfPlayers.add(new King(((King) listOfPlayers.get(i)).getX(),
							((King) listOfPlayers.get(i)).getY(), false));
					listOfPlayers.remove(i);
					updateBoard();
				}
			}
		}
		updateBoard();//board is updated

		repaint(); //board is repainted
	}
}