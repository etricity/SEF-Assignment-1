import javax.swing.*;
import javax.swing.border.CompoundBorder;

import java.awt.*;
import guiElements.*;

/* This class is the main System level class which creates all the objects 
 * representing the game logic (model) and the panel for user interaction. 
 * It also implements the main game loop 
 */

public class Game extends JFrame {

   private final int TIMEALLOWED = 100;

   private JButton up = new JButton("up"); 
   private JButton down = new JButton("down"); 
   private JButton left = new JButton("left"); 
   private JButton right = new JButton("right");
   private JButton start = new JButton("start");
   private JLabel mLabel = new JLabel("Time Remaining : "+TIMEALLOWED);
   
   private Grid grid;
   private Player player;
   private Monster monster;
   private BoardPanel bp;
   
   
   /* This constructor creates the main model objects and the panel used for UI.
    * It throws an exception if an attempt is made to place the player or the 
    * monster in an invalid location.
    */
   public Game() throws Exception
   {  
	   
	  //BorderLayout.WEST
	  grid = new Grid();
	  player = new Player(grid,0,0);
	  monster = new Monster(grid,player,5,5);
	  bp = new BoardPanel(grid,player,monster);
	  
	  this.add (bp, BorderLayout.WEST); 
	  bp.setPreferredSize(new Dimension(500,0));
	  
	  //BorderLayout.NORTH
	  Container north = new Container();
	  north.setPreferredSize(new Dimension(0,30));
	  this.add(north, BorderLayout.NORTH);
	  
	  //BorderLayout.CENTER
	  Container center = new Container();
	  center.setLayout(new GridLayout(2,1));
	  center.setVisible(true);
	  
	  GameModesPanel gmp = new GameModesPanel();
	  center.add(gmp);
	  
      JPanel panel = new JPanel();
      panel.add(up); 
	  panel.add(down); 
	  panel.add(left); 
	  panel.add(right);
	  panel.add(start);
	  panel.add(mLabel);
	  this.add (panel,BorderLayout.SOUTH);
	  
	  // add Action listeners to all button events
	  up.addActionListener(bp);
	  down.addActionListener(bp);
	  left.addActionListener(bp);
	  right.addActionListener(bp);
	  start.addActionListener(bp);
	  center.add(panel);
	  
	  this.add(center, BorderLayout.CENTER);
	  
	  //BorderLayout.EAST
	  Container east = new Container();
	  east.setLayout(new GridLayout(2,1));
	  east.setVisible(true);
	  LeaderBoard lb = new LeaderBoard();
	  east.add(lb);
      east.setPreferredSize(new Dimension(300,0));
      
      PlayerDetailsPanel pdp = new PlayerDetailsPanel();
      east.add(pdp);
      
      this.add(east, BorderLayout.EAST);

   }	   
    
   // method to delay by specified time in ms
   public void delay(int time)
   {
   	try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	   
   }
   
     
   /* This method waits until play is ready (until start button is pressed) 
    * after which it updates the moves in turn until time runs out (player won) 
    * or player is eaten up (player lost).
    */
   public String play()
   {
	  int time = 0; 
	  String message;
      player.setDirection(' '); // set to no direction
      while (!player.isReady()) 
          delay(100);
	  do {
      
		 Cell newPlayerCell = player.move();
         if (newPlayerCell == monster.getCell())
        	break;
         player.setDirection(' ');   // reset to no direction 
         
         
         if (newPlayerCell == monster.getCell())
         	break;
          player.setDirection(' ');   // reset to no direction 
         
         
         Cell newMonsterCell = monster.move();
         if (newMonsterCell == player.getCell())
         	break;        

         // update time and repaint
         time++;
         mLabel.setText("Time Remaining : "+ (TIMEALLOWED - time));
         delay(750);
         bp.repaint();      

	  } while (time < TIMEALLOWED);

	  if (  time < TIMEALLOWED)			// players has been eaten up
    	  message =  "Player Lost"; 
      else 			
    	  message =  "Player Won";   

      mLabel.setText(message);
	  return message;
   }
   
   public static void main(String args[]) throws Exception
   {
       Game game = new Game();
       game.setTitle("Monster Game");
       game.setSize(1200,700);
       game.setLocationRelativeTo(null);  // center the frame
       game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       game.setVisible(true);
       
       game.play();
   }
}
