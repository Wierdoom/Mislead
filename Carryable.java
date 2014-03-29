//The class of items you can pick up and carry.
//TODO: add get() functionality for taking from room and putting in inventory
public class Carryable extends Thing {

   // Extra Attributes
   boolean isPicked;
   boolean isCarryable;
   String descPicked;

	public Carryable(String name, String desc, String descPick, boolean visible) {
		super(name, desc, visible);
      isPicked = false;
      descPicked = descPick;
      isCarryable = true;
	}

	public Carryable(String name, String desc, String descPick) {
		super(name, desc);
      isPicked = false;
      descPicked = descPick;
      isCarryable = true;
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
			Io.out("Took " + this.getName());
         isPicked = true;
		}
		else{Io.out("No point in getting it now.");}
	}
   
   public boolean getCarryable() {
      return isCarryable;
   }
   
   public boolean getPicked() {
      return isPicked;
   }
}
