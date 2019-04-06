package Users_Save_Data;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginSystem extends JDialog implements ActionListener{
	
	private ArrayList<User> users = new ArrayList<User>();
	
	private JLabel message;
	private JLabel usernameLabel;
	private JLabel passwordLabel;	
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton signUp;
	private JButton logIn;
	
	public LoginSystem()
	{
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
		
		message = new JLabel("ty", JLabel.CENTER);
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

	public ArrayList<User> getUsers()
	{
		return users;
	}
	public void addNewUser(User user)
	{
		users.add(user);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton)e.getSource()).getText().equals("Sign Up"))
		{
			signUp();
		}
		else if (((JButton)e.getSource()).getText().equals("Log In"))
		{
			logIn();
		}
	}
	
	public void signUp()
	{
		User user = new User(usernameField.getText(), passwordField.getPassword());
		users.add(user);
		message.setText(user.getUserName() + " successfully added to the system. You can now log in.");
	}
	
	//Validation later
	public void logIn()
	{
		this.dispose();
	}

}
