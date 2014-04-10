// An exit connects two rooms and exists in both.
// If it's the kind of exit you interact with (like, a door) it might have a fronting thing
// Otherwise, it's probably not.

// When you type "north", you're really calling ( (player.location).north ).go!

public class Exit{
	public Exit(Room side1, Room side2) {
		this.side1 = side1;
		this.side2 = side2;
		open = true;
		
	}
	public Exit(Room side1, Room side2, String str) {
		this.side1 = side1;
		this.side2 = side2;
		open = true;
		switch (str){
		case "ns":
			side1.setNorth(this);
			side2.setSouth(this);
			break;
		case "sn":
			side2.setNorth(this);
			side1.setSouth(this);
			break;
		case "ew":
			side1.setEast(this);
			side2.setWest(this);
			break;
		case "we":
			side2.setEast(this);
			side1.setWest(this);
			break;
		case "ud":
			side1.setUp(this);
			side2.setDown(this);
			break;
		case "du":
			side2.setUp(this);
			side1.setDown(this);
			break;
		}
		
	}
	private Room side1, side2;
	private boolean open;
	private String closedReason; //If it's closed,
	// this is the text that gets printed when you fail to travel across
	
	public void travel(){
		if (open){
		if (Game.player().getLocation()==side1){side2.enter();}
		else if (Game.player().getLocation()==side2){side1.enter();}
		// else, that is not how exits work.
		}
		else{Io.out(closedReason);}
	}
	// Shuts a door for given closedReason, which is printed when you fail to travel through.
	public void close(String closedReason) {
		open = false;
		this.closedReason = closedReason;
	}
	// Reopens an exit.
	public void open(){
		open = true;
	}
	public Room getSide1() {
		return side1;
	}
	public void setSide1(Room side1) {
		this.side1 = side1;
	}
	public Room getSide2() {
		return side2;
	}
	public void setSide2(Room side2) {
		this.side2 = side2;
	}
}
