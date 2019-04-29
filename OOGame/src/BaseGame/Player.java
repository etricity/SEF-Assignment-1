package BaseGame;
/*  This class encapsulates player position and direction  
 */
public class Player extends Moveable {
   private boolean readyToStart = false;
   public Player(Grid g, int row, int col) throws Exception
   {
	   super(g);
	   currentCell = grid.getCell(row, col);   
	   currentDirection = ' ';
   }
   public Cell move()
   {
       currentCell = grid.getCell(currentCell,currentDirection);	          
       return currentCell;
   }
   public int maxCellsPerMove()
   {
	   return 1;
   }
   public  int pointsRemaining()
   {
	   return -1;  // not implemented
   }
   public void setReady(boolean val)
   {
	   readyToStart = val;
   }
   public boolean isReady()
   {   return readyToStart;
   }
   
   //initial energy store that will get depleted as abilities are cast
   //at depletion, player waits 3 seconds to go back to four energy.
   public int energyStore() {
	  int energyCheck = 4;
	   
	   
	   if (energyCheck = 0) {
		   this.maxCellsPerMove = 0;
	   }
	   
	   else {
		   energyCheck = 4;
	   }
	   
	   
   }
}