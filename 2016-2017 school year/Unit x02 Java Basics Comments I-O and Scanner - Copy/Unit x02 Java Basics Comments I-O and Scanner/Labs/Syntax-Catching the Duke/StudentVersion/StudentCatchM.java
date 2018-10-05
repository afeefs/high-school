import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class StudentCatchM extends Applet {

   // Correct all syntax errors and compile.
   // This class will allow you to play Catch the Duke game
   // when all syntax errors are corrected.
    Try to catch the duke and hit it by pressing the left
   * mouse button.
   * Illustrates sound, images and movement
   * and mouse handling events. */
    
    int mx, my, limitx, limity
    int wins;
    int boardSize;
    Image duke;

    public void init() {
      wins = 0;
      boardSize = getSize().width - 1;
      duke = getImage(getCodeBase(),"duke.gif");
      this.add(MouseListener (new mousePressHandler());
      this.addMouseMotionListener (new mouseMotionHandler());
    }

    class mousePressHandler extends MouseAdapter {

      public void mousePressed (MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        requestFocus();
        if (mx < x && x < mx+limitx &&
            my < y && y < my+limity) {
          wins++;
	     getAppletContext().showStatus("Caught it!  Total " + wins);
          play(getCodeBase(), "sounds/ou.au");
        		}
        else {
          getAppletContext().showStatus("Missed again.");
          play(getCodeBase(), "sounds/haha.au");
        }
        repaint();
      }
   }

   public class mouseMotionHandler extends MouseMotionAdapter {
     public void mouseMoved(MouseEvent e) {
       if (e.getX() % 3 == 0 && e.getY() % 3 == 0)
         repaint();
     }
   }

   public void paint(Graphics g) {
     // wait till the image is in before getting the
     // size. Can't put these statements in init
     limitx = duke.getWidth(this);
     limity = duke.getHeight(this);
     int change = boardSize-limitx;

     // draw a boundary
     g.drawRect(0, 0, boardSize, boardSize);

      // calculate a new place for the duke
      // and draw it.
      mx = (int)(Math.rando()*1000) % change;
      my = (int)(Math.random()*1000) % change;
      g.drawImage(duke, mx, my, this);
    }
}
