import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;


public class Parser {

private ArrayList<String> nounList;
private ArrayList<String> verbList;
private ArrayList<String> prepositionList;
	
	public Parser(){
		String[] verbSet = {"look","get","drop","open","close","drink","eat","hit","read","go","enter","lock","unlock","north","south","east","west","up","down","i","use","photograph"};
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
			if (isVerb(nextWord)){Understand.understand(nextWord,object,secondary);}
			else if (isPreposition(nextWord)){secondary=object; object=null;}
			else if (isNoun(nextWord)){object=findObject(nextWord);}
			else {valid = false;
				Io.out("[Couldn't find valid command in line "+in+" ]");}
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

	private Thing findObject(String word){
		Thing target = null;
		target = Game.player().getInventory().find(word);
		if (target==null){target = Game.player().getLocation().getContents().find(word);}
		return target;
	}
	
	public void addNoun (String noun){
		nounList.add(noun);
	}
	
	}