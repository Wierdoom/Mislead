
public class Room {
	private Thinglist contents;
	private Exit north, south, west, east, down, up;
	
	public Thinglist getContents() {
		return contents;
	}
	public void enter(){
		Game.player().setLocation(this);
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
