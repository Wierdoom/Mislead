
public class Drop extends Thing {

	public Drop(String name, String desc, boolean visible) {
		super(name, desc, visible);
		// TODO Auto-generated constructor stub
	}

	public Drop(String name, String desc) {
		super(name, desc);
		// TODO Auto-generated constructor stub
	}
	public void dropItem() { //method applies to Thing object
		if (Game.player().getInventory().has(this)) {
			Game.player().getInventory().remove(this);
			Game.player().getLocation().add(this);
			Io.out(this.getName() + " was dropped in this room.");
		} else {
			Io.out("You can't drop what you don't have.");
		}
	}
}
