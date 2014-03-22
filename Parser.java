
public class Parser {

	//Using space as a delimiter, returns an array of up to 4 strings
	// being the first four words in given input
	public String[] chopUp(String str){
		String[] blocks = new String[4];
		blocks = str.split(" ");
		return blocks;
	}
	
	//Parses the given blocks and runs them through the understand method
	public void parse(String[] blocks){
		Thing target = null;
		target=Game.player().getInventory().find(blocks[1]);
		if (target!=null){target=Game.player().getLocation().getContents().find(blocks[1]);}
		
		Understand.understand(blocks[0], target);
    
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