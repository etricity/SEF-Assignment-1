package Users_Save_Data;

import javax.swing.*;

import BaseGame.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSystem extends JDialog implements ActionListener{
	
	
	
	private JLabel message;
	private JLabel usernameLabel;
	private JLabel passwordLabel;	
	private JTextField usernameField;
	private JTextField passwordField;
	private JButton signUp;
	private JButton logIn;
	//used to ensure the user logins in before the game can be opened
	private Boolean userLoggedIn = false;
	private User user;
	private Game game;
	
	public LoginSystem(Game game)
	{
		this.game = game;
		setModal(true);
		
		this.setSize(600, 350);
		this.setTitle("Welcome");
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - getHeight()/2);
		this.setLayout(new BorderLayout());
		
		//BorderLayout.NORTH
		JPanel north = new JPanel();
		north.setLayout(new BorderLayout());
		north.setPreferredSize(new Dimension(0,100));
		
		message = new JLabel("", JLabel.CENTER);
		north.add(message, BorderLayout.CENTER);
		north.setVisible(true);
		
		this.add(north, BorderLayout.NORTH);
		
		//BorderLayout.CENTER
		JPanel center = new JPanel();
		center.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");	
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		center.add(usernameLabel, c);
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1;
		center.add(usernameField, c);
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0;
		center.add(passwordLabel,c);
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 1;
		center.add(passwordField,c);
		center.setVisible(true);
		
		this.add(center, BorderLayout.CENTER);
		center.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 100));
		
		//BorderLayout.SOUTH
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		south.setPreferredSize(new Dimension(0, 150));
		
		signUp = new JButton("Sign Up");
		logIn = new JButton("Log In");

		signUp.setPreferredSize(new Dimension(150,40));
		logIn.setPreferredSize(new Dimension(150,40));
		south.add(signUp);
		south.add(logIn);
		
		this.add(south, BorderLayout.SOUTH);
		
		//Action Listeners
		signUp.addActionListener(this);
		logIn.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton)e.getSource()).getText().equals("Sign Up"))
		{
			signUp(usernameField.getText(), passwordField.getText());
		}
		else if (((JButton)e.getSource()).getText().equals("Log In"))
		{
			logIn(usernameField.getText(), passwordField.getText());
		}
	}
	
	public boolean signUp(String username, String password)
	{
		Boolean validSignUp = true;
		
		//Validation for empty username or password
		if(username.trim().equals("") || password.trim().equals(""))
		{
			validSignUp = false; 
			message.setText("Username or Password cannot be empty.");
		}
		
		//Validation for if the username already exists in system
		for(User u : game.getUsers()) {
			if(u.getUserName().equals(username))
			{
				validSignUp = false;
				message.setText("This user alreasy exists in the system. Choose a different username.");
			}
		}
		
		//If the signUp is valid, the user is added to the system
		if(validSignUp)
		{
			user = new User(username, passwordField.getText());
			game.addUser(user);
			message.setText(user.getUserName() + " successfully added to the system. You can now log in.");
		}
		
		return validSignUp;
	}
	
	//Validates user before allowing them into the game
	//Updates GUI for that user
	public boolean logIn(String username, String password)
	{
		User user = null;
		Boolean userExists = false;
		
		//finding user in system (checks username is correct)
		for(User u : game.getUsers())
		{
			if(username.equals(u.getUserName()))
			{
				userExists = true;
				user = u;
				break;
			}
		}
		
		//checks password is correct
		if(userExists)
		{
			if(password.equals(user.getPassword()))
			{
				userLoggedIn = true;
				game.setLoggedInUsername(user.getUserName());
				this.dispose();
			}
			else
			{
				message.setText("Password Incorrect.");
			}
		}
		//Runs if user is not found in system
		else
		{
			message.setText("User does not exist in our system.");
		}
		return userLoggedIn;
	}

	public boolean getUserLoggedIn()
	{
		return userLoggedIn;
	}
}
