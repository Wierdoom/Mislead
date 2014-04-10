// The inventory is a special thinglist that travels around with the player.
// It prints its contents in a specific way

public class Inventory extends Thinglist{
	
	public String list(){
		String list="";
		for (int i=0; i<contents.size();i++){
			list=list+contents.get(i)+"\n";
		}
		
		return list;
	}
}

	