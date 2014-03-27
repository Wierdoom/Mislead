//The class of items you can pick up and carry.
//TODO: add get() functionality for taking from room and putting in inventory
public class Carryable extends Thing {

	public Carryable(String name, String desc, boolean visible) {
		super(name, desc, visible);
	}

	public Carryable(String name, String desc) {
		super(name, desc);
		// TODO Auto-generated constructor stub
	}
	public void drop() { //method applies to Thing object
		if (Game.player().getInventory().has(this)) {
			Game.player().getLocation().add(this);
			Game.player().getInventory().remove(this);
			Io.out(this.getName() + " was dropped in this room.");
		} else {
			Io.out("You can't drop what you don't have.");
		}
	}
}
