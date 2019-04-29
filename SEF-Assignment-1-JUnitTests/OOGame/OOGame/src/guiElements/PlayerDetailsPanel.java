package guiElements;

import java.awt.*;

import javax.swing.*;

import Utilities.DataFiller;

public class PlayerDetailsPanel extends JPanel{
	
	private JLabel playerNameLabel = new JLabel("[playerName]'s Achievements");
	private String[][] achievementData = new String[][] {{"",""}, {"",""}, {"",""}};
	private DataFiller df = new DataFiller();
	
	public PlayerDetailsPanel()
	{
		
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		playerNameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(playerNameLabel, BorderLayout.NORTH);
		this.setBorder(BorderFactory.createEmptyBorder(30, 15, 30, 15));
		
		Container c = new Container();
		c.setLayout(new GridLayout(3,2));
		c.setVisible(true);
		this.add(c, BorderLayout.CENTER);
		df.fillTable(achievementData, c);
	}
	
	public String[][] getAchievementData()
	{
		return achievementData;
	}
	public void setAchievementData(String[][] achievementData)
	{
		this.achievementData = achievementData;
	}

}
