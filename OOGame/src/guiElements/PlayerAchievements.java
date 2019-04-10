package guiElements;

import java.awt.*;

import javax.swing.*;

import Utilities.DataFiller;

public class PlayerAchievements extends JPanel{
	
	private JLabel playerNameLabel = new JLabel("",JLabel.CENTER);
	private Container dataContainer;
	
	public Container getDataContainer()
	{
		return dataContainer;
	}
	public JLabel getPlayerNameLabel()
	{
		return playerNameLabel;
	}
	
	public PlayerAchievements()
	{
		
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		playerNameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(playerNameLabel, BorderLayout.NORTH);
		this.setBorder(BorderFactory.createEmptyBorder(30, 15, 30, 15));
		
		dataContainer = new Container();
		dataContainer.setLayout(new GridLayout(3,1));
		dataContainer.setVisible(true);
		this.add(dataContainer, BorderLayout.CENTER);
	}

	
	

}
