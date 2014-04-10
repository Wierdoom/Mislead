public class Room {
	public Room(String name, String longDescription, String shortDescription) {
		this.name = name;
		this.longDescription = longDescription;
		this.shortDescription = shortDescription;
		visited = false;
		contents = new Thinglist();
		carryables = new Thinglist();
	}
	private Thinglist contents;
   private Thinglist carryables;
	private String name, longDescription, shortDescription;
	boolean visited;
	private Exit north, south, west, east, down, up;
	
	public Thinglist getContents() {
		return contents;
	}
	public void enter(){
		Game.player().setLocation(this);
		describe(!visited);
		visited=true;
	}
	public void describe(boolean full){
		Io.out(name);
		if(full){Io.out(longDescription);}
		else{Io.out(shortDescription);}
      Io.out("\nObjects:\n");
      contents.printObjects();
	}
	// Adds given thing to room's contents
	public void add(Thing th){
      if (th.getCarryable()) {
         carryables.add(th);
      }
      else {
		   contents.add(th);
      }
	}
   
   // Removes a given Thing from a room's contents
   public void remove(Thing th) {
      if (th.getCarryable()) {
         carryables.remove(th);
      }
      else {
         contents.remove(th);
      }
   }
	
	public Exit getNorth() {
		return north;
	}
	public void setNorth(Exit north) {
		this.north = north;
	}
	public Exit getSouth() {
		return south;
	}
	public void setSouth(Exit south) {
		this.south = south;
	}
	public Exit getWest() {
		return west;
	}
	public void setWest(Exit west) {
		this.west = west;
	}
	public Exit getEast() {
		return east;
	}
	public void setEast(Exit east) {
		this.east = east;
	}
	public Exit getDown() {
		return down;
	}
	public void setDown(Exit down) {
		this.down = down;
	}
	public Exit getUp() {
		return up;
	}
	public void setUp(Exit up) {
		this.up = up;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
   public Thinglist getCarryables() {
      return carryables;
   }
}
