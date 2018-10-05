import javax.swing.JFrame;                                                                   //Import the JFrame

public class frame {                                                                         //Run this class to run the game
        public static void main(String[] args) {                                                 //The first method called by java
                JFrame frame = new JFrame("");                     //Create JFrame called frame

                frame.getContentPane().add(new board());                       //Go to board class
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                //Make frame close on X click
                frame.setSize(950,640);                                                              //Set the frame size to the size of the background
                frame.setResizable(false);                                                           //Make sure the user can't resize the frame
                frame.setLocation(20, 50);                                                           //Place the frame in a nicer position
                frame.setVisible(true);                                                              //Make the frame visible

                int frameWidth  = frame.getContentPane().getWidth();
                int frameHeight  = frame.getContentPane().getHeight();
        }
} 