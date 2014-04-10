
public class Player extends Thing {
	private Room location;
	private Inventory inventory;

	public Player() {
		super("self", "You check yourself out a little. Lookin' good!", true);
		inventory = new Inventory();
	}

	public Room getLocation() {
		return location;
	}

	public void setLocation(Room location) {
		this.location = location;
	}

	public Inventory getInventory() {
		return inventory;
	}
	
	// Methods for the player travelling in the six directions.
	// Fails - but without a room-specific message - if there's no exit in that direction.
	public void north(){
		Exit destination = location.getNorth();
		if (destination!=null){destination.travel();}
		else{Io.out("At least from here, there's no way further north.");}
	}
	public void south(){
		Exit destination = location.getSouth();
		if (destination!=null){destination.travel();}
		else{Io.out("At least from here, there's no way further south.");}
	}
	public void west(){
		Exit destination = location.getWest();
		if (destination!=null){destination.travel();}
		else{Io.out("At least from here, there's no way further west.");}
	}
	public void east(){
		Exit destination = location.getEast();
		if (destination!=null){destination.travel();}
		else{Io.out("At least from here, there's no way further east.");}
	}
	public void up(){
		Exit destination = location.getUp();
		if (destination!=null){destination.travel();}
		else{Io.out("At least from here, there's no way up.");}
	}
	public void down(){
		Exit destination = location.getDown();
		if (destination!=null){destination.travel();}
		else{Io.out("There's no way down.");}
	}
   
   //Need to add a way to pause execution until a key is pressed
   public void gameEnd(String circ) {
      Io.out(circ);
      Io.out(Game.getTime().getTime() + "moves taken");
      
   }
	
}
