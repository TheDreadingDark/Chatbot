package chat.controller;

import chat.view.PopupDisplay;
import chat.model.Chatbot;
import chat.view.ChatFrame;

public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	/**
	 * Declaring variables
	 */
	public ChatbotController()
	{
		chatbot = new Chatbot("AJ Woolsey");
		//View initialized after Model
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	/**
	 * Starts the window with Chatbot saying, "What do you want to talk about?"
	 */
	public void start()
	{
		display.displayText("Welcome to Chatbot");
	}
	
	/**
	 * Chatbot replies with nothing till the user does then shows what the user said then Chatbot replies
	 * @param chat
	 * @return
	 */
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public String interactWithChatbot(String input)
	{	
		String chatbotSays = "";
	
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}
	
	public String useCheckers(String text)
	{
		String response = "";
		
		if(chatbot.contentChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			response += "";
		}
		//continue with all checkers except length and quit checker
		
		return response;
	}
}
