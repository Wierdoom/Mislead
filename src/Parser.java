import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;


public class Parser {

private ArrayList<String> nounList;
private ArrayList<String> verbList;
private ArrayList<String> prepositionList;
	
	public Parser(){
		
		//List of all verbs. If you add a verb, it needs to go here! (And in Understand, and in Thing)
		String[] verbSet = {"look","get","drop","open","close","drink","eat","hit","read","go","enter","lock","push","pull","put","unlock","north","south","east","west","up","down","i","use","photograph"};
		String[] prepositionSet = {"on","with","using","at"}; // not complete, add as make sense
		nounList = new ArrayList<String>();
		verbList = new ArrayList<String>();
		prepositionList = new ArrayList<String>();
		verbList.addAll(Arrays.asList(verbSet));
		prepositionList.addAll(Arrays.asList(prepositionSet));
	}

	public void parse(String in){
		StringTokenizer tokens = new StringTokenizer(in," ");
		Thing object = null;
		Thing secondary = null;
		Stack<String> stack = new Stack<String>();
		while (tokens.hasMoreTokens()){stack.push(tokens.nextToken());}
		String nextWord;
		boolean valid = true;
		while(!stack.isEmpty()&&valid){
			nextWord = stack.pop();
			
			//If verb, performs action and stops interpreting the command
			if (isVerb(nextWord)){Understand.understand(nextWord,object,secondary);
				valid=false;}
			
			//If preposition, moves object into secondary object field
			else if (isPreposition(nextWord)){secondary=object; object=null;}
			
			//If noun, that's the target of the action, the object.
			//If it can't find the object in inventory or in environment,
			//Action fails with "can't see the x here" error".
			else if (isNoun(nextWord)){object=findObject(nextWord);
				if (object==null){
					Io.out("I don't see the "+nextWord+" here.");
					valid = false;
				}}
			//Stops if it sees a word it can't understand.
			else {valid = false;
				Io.out("I saw a word I don't understand in line "+in+" - Possibly an action this game doesn't require, or something in the description you won't need to interact with.");}
		}
	}
		
		
	private boolean isVerb(String word){
		return verbList.contains(word);
	}	

	private boolean isNoun(String word){
		return nounList.contains(word);
	}

	private boolean isPreposition(String word){
		return prepositionList.contains(word);
	}	

	// Finds an object by hunting in the inventory and in the player's room.
	private Thing findObject(String word){
		Thing target = null;
		target = Game.player().getInventory().find(word);
		if (target==null){target = Game.player().getLocation().getContents().find(word);}
		return target;
	}
	
	//Adds a noun to the nounList. Whenever the game has a new noun, call this!
	public void addNoun (String noun){
		nounList.add(noun);
	}
	
	}