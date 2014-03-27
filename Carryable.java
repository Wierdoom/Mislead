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
	
	//NOTE: we should likely implement behaviour for describing items in a room.
	// Items that don't belong, removing things from description if taken, etc...
	public void drop() { //method applies to Thing object
		if (Game.player().getInventory().has(this)) {
			Game.player().getLocation().add(this);
			Game.player().getInventory().remove(this);
			Io.out(this.getName() + " was dropped in this room.");
		} else {
			Io.out("You can't drop what you don't have.");
		}
	}
	public void get(){
		if (Game.player().getLocation().getContents().has(this)){
			Game.player().getInventory().add(this);
			Game.player().getLocation().getContents().remove(this);
			Io.out("Taken.");
		}
		else{Io.out("No point in getting it now.");}
	}
}
