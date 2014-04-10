// The class of items you can pick up and carry.
public class Carryable extends Thing {

   // Constructors. Gives a carryable a name, description, secondary description, and visibility state.
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
	
	// Takes an item in the player's inventory and drops it into the room.
   // Returns an error if the item does not exist in their inventory.
	public void drop() { //method applies to Thing object
		if (Game.player().getInventory().has(this)) {
			Game.player().getLocation().add(this);
			Game.player().getInventory().remove(this);
			Io.out(this.getName() + " was dropped in this room.");
		}
      
      else {
			Io.out("You can't drop what you don't have.");
		}
	}
   
   // Takes a carryable item in the room and adds it to the player's inventory.
   // Returns an error if the item does not exist in the room.
	public void get(){
		if (Game.player().getLocation().getContents().has(this)){
			Game.player().getInventory().add(this);
			Game.player().getLocation().getContents().remove(this);
			Io.out("Took " + this.getName());
         isPicked = true;
		}
		else{Io.out("No point in getting it now.");}
	}
   
   // Returns whether or not the object can be carried.
   public boolean getCarryable() {
      return isCarryable;
   }

}
