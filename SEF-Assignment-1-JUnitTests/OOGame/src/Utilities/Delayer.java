package Utilities;

public class Delayer {

	   // method to delay by specified time in ms
	   public static void delay(int time)
	   {
	   	try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	   
	   }
	
}
