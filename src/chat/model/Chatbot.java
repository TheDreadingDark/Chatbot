package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = null;
		this.currentTime = LocalTime.now();
		this.questions = new String [6];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.topics = new String [5];
		this.verbs = new String [4];
		this.followUps = null;
	
		buildVerbs();
		buildMovieList();
		buildShoppingList();
		buildTopics();
		buildQuestions();
	}
	
	private void buildTopics()
	{
		topics[0] = "Summoner's Rift";
		topics[1] = "mages";
		topics[2] = "marksman";
		topics[3] = "supports";
		topics[4] = "top laners";
	}
	
//	Topics that the Chatbot uses when you run the program
	
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	
//	Verbs that the Chatbot uses when you run the program
	
	private void buildMovieList()
	{
		movieList.add(new Movie ("Transformers (1986)"));
		movieList.add(new Movie ("Spawn"));
		movieList.add(new Movie ("The Incredible Hulk"));
		movieList.add(new Movie ("Thor: Ragnarok"));
		movieList.add(new Movie ("Spiderman"));
		movieList.add(new Movie ("Hidden Figures"));
		
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("eggs");
		shoppingList.add("hot peppers");
		shoppingList.add("onions");
		shoppingList.add("bagel");
		shoppingList.add("crunchy peanutbutter");
		shoppingList.add("hot sauce");
		shoppingList.add("juice");
	}
	
//	The shoppinglist without the list items that will crash it
	
	private void buildCuteAnimals()
	{
		
	}
	
	private void buildQuestions()
	{
		questions[0] = "Have you considered learning forbidden techniques?";
		questions[1] = "Have you done things you're not proud of in the past?";
		questions[2] = "Have you betrayed someone's trust in your lifetime?";
		questions[3] = "Do you use shadows to take down your enemies?";
		questions[4] = "Who's your favorite assassin?";
		questions[5] = "Which mage do you hate the most?";
	}
	
//	Questions the Chatbot asks once you run the program
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		currentTime = LocalTime.now();
		chatbotResponse += currentTime.getHour() + ":" + curentTime.getMinute() + " ";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	/**
	 * Makes it so you can't say something too short to Chatbot and makes Chatbot respond
	 * @return
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		random = (int) (Math.random() * 2);
		
		if (random % 2 == 0)
		{
			random = (int) (Math.random() * movieList.size());
			response += "\n" + movieList.get(random).getTitle() + "is a great movie!";
		}
		
		int followup = (int) (Math.random() * 5);
		
		switch (followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
		case 1:
			response += followUps[2] + "\n";
		default:
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
			break;
		}
		
		return response;
	}
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null)
		{
			if (input.length() > 2)
			{
				validLength = true;
			}
		}
		
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		boolean containsHTML = false;
		if(input == null || !input.contains("<")) 
		{
			return containsHTML;
		}
		int firstOpen = input.indexOf("<");
		int firstClose = input.indexOf(">",firstOpen);
		int secondOpen = -9;
		int secondClose = -9;
		String tagText = "";
		
		//Check bad tags
		if(input.contains("<>") || input.indexOf("< >") > -1)
		{
			containsHTML = false;
		}
		//Check singleton
		if(input.toUpperCase().contains("<P>") || input.toLowerCase().contains("<br>"))
		{
			containsHTML = true;
		}
		//Check others
		else if(firstClose > firstOpen)
		{
			//others
			tagText = input.substring(firstOpen + 1,  firstClose).toLowerCase();
			secondOpen = input.toLowerCase().indexOf("</" + tagText, firstClose);
		}
		
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		return false;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		for (int index = 0; index < shoppingList.size(); index++)
		{
			if (shoppingItem.contains(shoppingList.get(index)))
			{
				return true;
			}
			
		}
		
		return false;
		
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		if (exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		return false;
	}

	public boolean keyboardMashChecker(String input)
	{
		if (input.contains("sdf"))
		{
			return true;
		}
		else if (input.contains("SDF"))
		{
			return true;
		}
		else if (input.contains("dfg"))
		{
			return true;
		}
		else if (input.contains("cvb"))
		{
			return true;
		}
		else if (input.contains(",./"))
		{
			return true;
		}
		else if (input.contains("kjh"))
		{
			return true;
		}
		else if (input.contains("DFG"))
		{
			return true;
		}
		else if (input.contains("CVB"))
		{
			return true;
		}
		else if (input.contains("KJH"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return null;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		return null;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
