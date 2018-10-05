import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.Color;
//import java.awt.Component;
import java.awt.BorderLayout;

 
public class StartPage {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public StartPage(){
      prepareGUI();
     
   }
   public static void main(String[] args){
      StartPage  button = new StartPage();      
      button.showButtonDemo();
      setPage();
   }
   private void prepareGUI(){
      JFrame frame = new JFrame("Checker");
      mainFrame = new JFrame("Checkers");
      mainFrame.setSize(800,800);
      mainFrame.setLayout(new GridLayout(3, 1));
           
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      //mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
     // mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }  
   private static void setPage(){
      Color cream = new Color(255,220,185);
      //setBackground(cream);
   }
   private void showButtonDemo(){
      //headerLabel.setText("Control in action: Button"); 

      //resources folder should be inside SWING folder.
      JButton okButton = new JButton("Play"); 
      Dimension d = new Dimension(150,50);
      okButton.setPreferredSize(d);
      okButton.setBackground(Color.red);
     // setLayout(new BorderLayout());
     // mainFrame.add(JPanel, BorderLayout.SOUTH);
      okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            //statusLabel.setText("Ok Button clicked.");
         }          
      });
           controlPanel.add(okButton);

      mainFrame.setVisible(true);  
   }
}