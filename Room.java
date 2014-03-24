
public class Room {
	public Room(String name, String longDescription, String shortDescription) {
		this.name = name;
		this.longDescription = longDescription;
		this.shortDescription = shortDescription;
		visited = false;
		contents = new Thinglist();
	}
	private Thinglist contents;
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
	}
	// Adds given thing to room's contents
	public void add(Thing th){
		contents.add(th);
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
}
