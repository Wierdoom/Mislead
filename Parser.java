
public class Parser {

	//Using space as a delimiter, returns an array of up to 4 strings
	// being the first four words in given input
	public String[] chopUp(String str){
		String[] blocks = new String[4];
		blocks = str.split(" ");
		return blocks;
	}
	
	public void parse(String[] blocks){
		scan(blocks[0],'v');
		scan(blocks[1],'o');
      if (!blocks[2] == null) {
         scan(blocks[2], 'q');
		}
      if (!blocks[3] == null) {
         scan(blocks[3], 'w');
      }
   }

// Scans a wordlist chosen based on assumed word meaning 
	private void scan(String str, char c){
      
   }
//TODO
}