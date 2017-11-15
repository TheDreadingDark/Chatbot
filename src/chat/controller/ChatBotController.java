package chat.controller;

import chat.view.PopupDisplay;
import chat.model.Chatbot;

public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
//	private ChatFrame appFrame;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("AJ Woolsey");
		//View initialized after Model
		display = new PopupDisplay();
	}
	
	public void start()
	{
		String response = display.collectResponse("What do you want to talk about?");
		
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}
	}
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
}
