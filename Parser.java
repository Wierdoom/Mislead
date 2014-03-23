
public class Parser {

	// Performs a command based on given string.
	public void command(String str){
		parse(chopUp(str));
	}
	//Using space as a delimiter, returns an array of up to 4 strings
	// being the first four words in given input
	private String[] chopUp(String str){
		String[] blocks = new String[4];
		blocks = str.split(" ",4);
		
		// Make sure we get the whitespace out!
		for(int i=0;i<blocks.length;i++){blocks[i]=blocks[i].trim();}
		
		return blocks;
	}
	
	//Parses the given blocks and runs them through the understand method
	public void parse(String[] blocks){
		Thing target = null;
		
		if (blocks.length == 1){Understand.understand(blocks[0]);}
		else{
			// Look in inventory
			target=Game.player().getInventory().find(blocks[1]);
			
			//If it's not in the inventory, maybe it's in the room?
			if (target==null){target=Game.player().getLocation().getContents().find(blocks[1]);}
			
			// If you've found it, do something to it
			if (target!=null){Understand.understand(blocks[0], target);}
			else{Io.out(blocks[1]+" isn't something you can interact with right now.");}
		}
    
	/*	
		if (!(blocks[2] == null)) {
         //Code for 3 word cases
		}
      if (!(blocks[3] == null)) {
         //Code for 4 word cases
       
       // Commenting this out for now!
          */
      }
   }