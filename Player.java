
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
	
}
