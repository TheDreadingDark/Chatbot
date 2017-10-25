package chat.controller;

import chat.view.PopupDisplay;

public class ChatBotRunner
{
	public static void main(String [] args)
	{
		PopupDisplay test = new PopupDisplay();
		test.displayText("words go here");
		test.collectResponse("ask a question");
	}
}
