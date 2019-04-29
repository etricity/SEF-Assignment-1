package Utilities;

import java.awt.*;
import javax.swing.*;
import Users_Save_Data.User;
import guiElements.PlayerAchievements;

public class DataFiller {
	
	private JLabel label;
	
	public void fillPlayerScores(User user, Container p)
	{
		p.removeAll();
		JLabel col1 = new JLabel("Score",  JLabel.CENTER);
		JLabel col2 = new JLabel("Difficulty",  JLabel.CENTER);
		col1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		col2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		p.add(col1);
		p.add(col2);
		String[] data = {"", "", "", "", "", ""};
		
		int x = 0;
		for(int n = 0; n < (2 * user.getScores().length) - 1; n += 2)
		{
			
			String scoreValue = String.valueOf(user.getScores()[x].getDifficulty());
			String difficultyString = String.valueOf(user.getScores()[x].getValue());
			data[n] = scoreValue;
			data[n + 1] = difficultyString; 
			x++;
		}
		
		for(String s: data)
		{
				label = new JLabel(s, JLabel.CENTER);
				p.add(label);
				label.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		}
		
	}		
	
	public void fillPlayerAchievements(User user, PlayerAchievements pdp)
	{	
		pdp.removeAll();
		JLabel playerNameLabel = new JLabel("",JLabel.CENTER);
		playerNameLabel.setText(user.getUserName() + "'s Achievements");
		playerNameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pdp.add(playerNameLabel, BorderLayout.NORTH);
		
		
		
		String[] data = {"", "", ""};
		
		for(int i = 0; i < user.getAchievements().length; i++)
		{
			if(user.getAchievements()[i] != null)
			{
				data[i] = user.getAchievements()[i].getDescription();
			}
		}
		
		for(String s: data)
		{

				label = new JLabel(s, JLabel.CENTER);
				pdp.add(label);
				label.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		}
	}
}
