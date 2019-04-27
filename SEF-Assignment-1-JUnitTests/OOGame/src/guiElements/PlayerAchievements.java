package guiElements;

import java.awt.*;

import javax.swing.*;

import Utilities.DataFiller;

public class PlayerAchievements extends JPanel{
	
	private Container dataContainer;
	
	public Container getDataContainer()
	{
		return dataContainer;
	}
	
	public PlayerAchievements()
	{
		
		this.setLayout(new GridLayout(4,1));
		this.setBorder(BorderFactory.createEmptyBorder(30, 15, 30, 15));
		this.setVisible(true);
	}

	
	

}
