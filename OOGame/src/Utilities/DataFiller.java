package Utilities;

import java.awt.*;
import javax.swing.*;
import Users_Save_Data.User;
import guiElements.PlayerAchievements;

public class DataFiller {
	
	private JLabel label;
	
	public void fillPlayerScores(User user, Container p)
	{
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
		pdp.getPlayerNameLabel().setText(user.getUserName() + "'s Achievements");
		
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
				pdp.getDataContainer().add(label);
				label.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		}
	}
}
