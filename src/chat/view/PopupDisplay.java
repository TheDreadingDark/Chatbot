package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class PopupDisplay
{
	private ImageIcon icon;
	private String windowTitle;
	
	/**
	 * Shows the Chatbot as set image (chatbot.png)
	 */
	public PopupDisplay()
	{
		icon = new ImageIcon(getClass().getResource("images/chatbot.png"));
		windowTitle = "Chatbot says";
	}
	
	/**
	 * Displays text to the user
	 * @param message
	 */
	public void displayText(String message)
	{
		JOptionPane.showMessageDialog(null,  message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	/**
	 * Prompts user for a response
	 * @param question
	 * @return
	 */
	public String collectResponse(String question)
	{
		String answer = "";
		
		answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
		
		return answer;
	}

}
