package BaseGame;
import javax.swing.*;

import Player_MonsterTypes.DefaultMonster;
import Player_MonsterTypes.DefaultPlayer;
import Player_MonsterTypes.Monster;
import Player_MonsterTypes.Player;
import Users_Save_Data.Achievement;
import Users_Save_Data.LoginSystem;
import Users_Save_Data.SaveSystem;
import Users_Save_Data.User;
import Utilities.DataFiller;
import Utilities.Delayer;
import Utilities.KeyBoardActions;

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
   private JLabel mLabel = new JLabel("Time Remaining : "+TIMEALLOWED, JLabel.CENTER);
   private JLabel message = new JLabel("TEST");
   
   public JLabel getMessage()
   {
	   return message;
   }
   
   private Grid grid;
   private Player player;
   private Monster monster;
   private BoardPanel bp;
   
   private PlayerScores ps;
   private PlayerAchievements pa;
   
   private SaveSystem ss;
   private LoginSystem ls;
   
   
   private Collection<User> users = new ArrayList<User>();
   private User loggedInUser;
   private DataFiller df = new DataFiller();

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
   
   public void setLoggedInUser(User user)
   {
	   this.loggedInUser = user;
   }
   
   public Player getPlayer()
   {
	   return player;
   }
   public void setPlayer(Player playerType)
   {
	   this.player = playerType;
   }
   public Monster getMonster()
   {
	   return monster;
   }
   public void setMonster(Monster monsterType)
   {
	   this.monster = monsterType;
   }
   public Grid getGrid()
   {
	   return grid;
   }
   public BoardPanel getBP()
   {
	   return bp;
   }
   

   
   /* This constructor creates the main model objects and the panel used for UI.
    * It throws an exception if an attempt is made to place the player or the 
    * monster in an invalid location.
    */
   public Game() throws Exception
   {  
	   
	  //BorderLayout.WEST
	  grid = new Grid();
	  player = new DefaultPlayer(grid, 0, 0);
	  monster = new DefaultMonster(grid, player, 5, 5);
	  bp = new BoardPanel(this, grid,player,monster);
	  
	  JPanel west = new JPanel();
	  west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
	  west.add(bp);
	  this.add(west, BorderLayout.WEST);
 
	  
	  //BorderLayout.NORTH
	  Container north = new Container();
	  north.setPreferredSize(new Dimension(0,30));
	 
	  this.add(north, BorderLayout.NORTH); 
	  
	//BorderLayout.CENTER
	  Container center = new Container();
	  center.setLayout(new FlowLayout());
	  center.setVisible(true);
	  
	  GameModesPanel gmp = new GameModesPanel(this);
	  center.add(gmp);
	  
	  
	  JButton up = new JButton("up"); 
	  JButton down = new JButton("down"); 
	  JButton left = new JButton("left"); 
	  JButton right = new JButton("right");
	  JButton start = new JButton("start");
	  
      JPanel panel = new JPanel();
      panel.add(up); 
	  panel.add(down); 
	  panel.add(left); 
	  panel.add(right);
	  panel.add(start);
	  panel.add(message);
	 
	 
	  
	  center.add(panel);
	  this.add(center, BorderLayout.CENTER);
	  
	//BorderLayout.SOUTH
	  this.add(mLabel, BorderLayout.SOUTH);
	  mLabel.setPreferredSize(new Dimension(100,100));
	  
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
      
      pa = new PlayerAchievements();
      east.add(pa);
      
      this.add(east, BorderLayout.EAST);
      
	  bp.addKeyListener(new KeyBoardActions(this));
	  bp.setFocusable(true);

   }	   
   
   public static void main(String args[]) throws Exception
   { 
       Game game = new Game();
       game.setTitle("Monster Game");
       game.setSize(1400,600);
       game.setLocationRelativeTo(null);  // center the frame
       game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       game.ss = new SaveSystem(game);
       
       //Caught here instead of handling in SaveSystem to make JUnit Test easier to show
       try{
    	   game.ss.importData("savedData.txt");
       } catch (FileNotFoundException e){
    	   e.getLocalizedMessage();
       } 
       
	   //SignUp or LogIn
       game.ls = new LoginSystem(game);
	   game.ls.setVisible(true);
	   
	   

	 game.setVisible(true);
	 //Updates Player Scores & Achievements Panels
	 game.df.fillPlayerAchievements(game.loggedInUser, game.pa);
	 game.df.fillPlayerScores(game.loggedInUser, game.ps);

       
	   
	   
     //Updates UI for the specific user
     //TODO update leaderBoard, player details
       game.play();
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
          Delayer.delay(100);
	  do {
		  
      
		if(player.playerMovement(monster))
		{
			break;
		}        
         
        if(monster.monsterMovement(player))
        {
        	break;
        }

         // update time and repaint
         time++;
         mLabel.setText("Time Remaining : "+ (TIMEALLOWED - time));     

	  } while (time < TIMEALLOWED);

	  if (  time < TIMEALLOWED)	
	  {// players has been eaten up
		  message =  "Player Lost"; 
	  }
    	 
      else 	
      {
    	  message =  "Player Won. Achievemnt Unlocked.";
    	  this.loggedInUser.addAchievement(monster.getReward());  
      }
	  
	  this.loggedInUser.updateScore(monster.getReward().getDifficulty(), time * monster.getReward().getDifficulty());
	  df.fillPlayerAchievements(loggedInUser,pa);
	  df.fillPlayerScores(loggedInUser,ps);
	  
	  this.ss.saveData(users);
      mLabel.setText(message);
	  return message;
   }
   
   
   //Called when a new Player/Monster type is chosen
   public void updateGameReferences()
   {
	   this.bp.updateBoardPanel(player, monster);
	   this.monster.updateMonster(player);
	   bp.repaint();
   }  
   
   //Possibly reset the game state
   public void resetGameState() throws Exception
   {
	   player.setCell(grid.getCell(0, 0));
	   monster.setCell(grid.getCell(5, 5));
	   bp.repaint();
   }
   
}
