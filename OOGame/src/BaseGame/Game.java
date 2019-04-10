package BaseGame;
import javax.swing.*;

import Users_Save_Data.Achievement;
import Users_Save_Data.LoginSystem;
import Users_Save_Data.SaveSystem;
import Users_Save_Data.User;
import Utilities.DataFiller;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

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
   
   private GameModesPanel gmp;
   private PlayerScores ps;
   private PlayerAchievements pd;
   
   
   private Collection<User> users = new ArrayList<User>();
   private String loggedInUsername;
   private DataFiller df = new DataFiller();
   

   private  Achievement achievementEasy = new Achievement("Monster Slayer - Defeat Default Monster", 1);
   private  Achievement achievementMedium = new Achievement("All Seeing Being - Defeat Invisible Monster", 2);
   private  Achievement achievementHard = new Achievement("Super Sonic - Defeat Speedy Monster", 3);
   

   //Getters & Setters
   public Collection<User> getUsers()
   {
	   return users;
   }
   public void addUser(User user)
   {
	   users.add(user);
   }
   public User getUser(String username)
   {
	   User selectedUser = null;
	   for(User u : users)
	   {
		   if(u.getUserName().equals(username))
		   {
			   selectedUser = u;
		   }
	   }
	   return selectedUser;
   }
   
   public void setLoggedInUsername(String username)
   {
	   this.loggedInUsername = username;
   }

   public Achievement getAchievementEasy() {
		return achievementEasy;
	}
   public Achievement getAchievementMedium() {
		return achievementMedium;
	}
   public Achievement getAchievementHard() {
		return achievementHard;
	}
   
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
	  bp.setPreferredSize(new Dimension(500,0));
	  
	  this.add (bp, BorderLayout.WEST); 
	  
	  //BorderLayout.NORTH
	  Container north = new Container();
	  north.setPreferredSize(new Dimension(0,30));
	  
	  this.add(north, BorderLayout.NORTH);
	  
	  //BorderLayout.CENTER
	  Container center = new Container();
	  center.setLayout(new GridLayout(2,1));
	  center.setVisible(true);
	  
	  gmp = new GameModesPanel();
	  center.add(gmp);
	  
      JPanel panel = new JPanel();
      panel.add(up); 
	  panel.add(down); 
	  panel.add(left); 
	  panel.add(right);
	  panel.add(start);
	  panel.add(mLabel);
	  center.add (panel);
	  
	  this.add(center, BorderLayout.CENTER);
	  
	  // add Action listeners to all button events
	  up.addActionListener(bp);
	  down.addActionListener(bp);
	  left.addActionListener(bp);
	  right.addActionListener(bp);
	  start.addActionListener(bp);
	  
 
	  //BorderLayout.EAST
	  Container east = new Container();
	  east.setLayout(new GridLayout(2,1));
	  east.setVisible(true);
	  
	  ps = new PlayerScores();
	  east.add(ps);
      east.setPreferredSize(new Dimension(350,0));
      
      pd = new PlayerAchievements();
      east.add(pd);
      
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
       
       SaveSystem ss = new SaveSystem(game);
       
       //Caught here instead of handling in SaveSystem to make JUnit Test easier to show
       try{
    	   ss.importData("savedData.txt");
       } catch (FileNotFoundException e){
    	   e.getLocalizedMessage();
       }
       
       
	   //SignUp or LogIn
       LoginSystem ls = new LoginSystem(game);
	   ls.setVisible(true);
	   
	 //Prevents the user from just exiting the LoginSystem to gain access
	   if(!ls.getUserLoggedIn())
	   {
		   System.exit(0);
	   }
	   else
	   {
		   game.setVisible(true);
		   //Updates Player Scores & Achievements Panels
		   game.df.fillPlayerAchievements(game.getUser(game.loggedInUsername), game.pd);
		   game.df.fillPlayerScores(game.getUser(game.loggedInUsername), game.ps);
	   }
       
	   //Testing
	   
	   ss.saveData(game.getUsers());
	   
	   
     //Updates UI for the specific user
     //TODO update leaderBoard, player details
       game.play();
   }

}
