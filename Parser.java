
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
		Understand.understand(Thinglist.find(blocks[0]), blocks[0]);
      if (!blocks[2] == null) {
         //Code for 3 word cases
		}
      if (!blocks[3] == null) {
         //Code for 4 word cases
      }
   }
}