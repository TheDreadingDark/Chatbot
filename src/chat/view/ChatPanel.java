package chat.view;

import javax.swing.*;
import java.awt.*;
import chat.controller.ChatbotController;
import java.awt.event.*;

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton checkerButton;
	private JLabel infoLabel;
	private JScrollPane chatScrollPane;
	private JButton loadButton;
	private JButton saveButton;
	private JButton tweetButton;
	private JButton searchButton;
	
	/**
	 * Initialize GUI data members
	 * @param appController
	 */
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		chatButton = new JButton("chat", new ImageIcon(getClass().getResource("/chat/view/images/chat.png")));
		loadButton = new JButton("load", new ImageIcon(getClass().getResource("/chat/view/images/load.png")));
		saveButton = new JButton("save", new ImageIcon(getClass().getResource("/chat/view/images/save.png")));
		tweetButton = new JButton("tweet", new ImageIcon(ChatPanel.class.getResource("/chat/view/images/tweet.png")));
		searchButton = new JButton("search", new ImageIcon(getClass().getResource("/chat/view/images/search.png")));
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		infoLabel = new JLabel ("Type to chat with the chatbot");
		appLayout = new SpringLayout();
		
		
	
		
		chatScrollPane = new JScrollPane();
		checkerButton = new JButton ("Check contents");
		
		
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
	
	private void setupPanel()
	{
		this.setMinimumSize(new Dimension(800, 600));
		this.setBackground(Color.GREEN);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatScrollPane);
		this.add(infoLabel);
		this.add(loadButton);
		this.add(saveButton);
		this.add(tweetButton);
		this.add(searchButton);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}
	
	/**
	 * Holds all the code created from the WindowBuilder
	 */
	private void setupLayout()
	{
		
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.WEST, infoLabel, 30, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -48, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 670, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -51, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, infoLabel, -77, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 3, SpringLayout.SOUTH, infoLabel);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 204, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 472, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, tweetButton, 6, SpringLayout.EAST, searchButton);
		appLayout.putConstraint(SpringLayout.EAST, tweetButton, -6, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, loadButton, -48, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, searchButton, -6, SpringLayout.NORTH, loadButton);
		appLayout.putConstraint(SpringLayout.EAST, searchButton, -233, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, searchButton, 475, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 6, SpringLayout.EAST, loadButton);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -6, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, searchButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 200, SpringLayout.EAST, inputField);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, -233, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, tweetButton, 204, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 6, SpringLayout.SOUTH, tweetButton);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -48, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, tweetButton, -134, SpringLayout.SOUTH, this);
		
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
		
		searchButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent click)
					{
						
					}
				});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.tweet(inputField.getText());
			}
		});
		
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
	}
}
