package chat.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import chat.controller.ChatbotController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton checkerButton;
	private JLabel infoLabel;
	
	/**
	 * Initialize GUI data members
	 * @param appController
	 */
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		chatButton = new JButton("chat");
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		infoLabel = new JLabel ("Type to chat with the chatbot");
		appLayout = new SpringLayout();
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.GREEN);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		this.add(infoLabel);
	}
	
	/**
	 * Holds all the code created from the WindowBuilder
	 */
	private void setupLayout()
	{

		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -26, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
		appLayout.putConstraint(SpringLayout.WEST, infoLabel, 30, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, infoLabel, -3, SpringLayout.NORTH, inputField);
		

	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						String userText = inputField.getText();
						String displayText = appController.interactWithChatbot(userText);
						chatArea.append(displayText);
						inputField.setText("");
					}
				});
		
		checkerButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						String userText = inputField.getText();
						String displayText = appController.useCheckers(userText);
						chatArea.append(displayText);
						inputField.setText("");
					}
				});
	}
}
