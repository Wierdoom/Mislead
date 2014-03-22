// An exit connects two rooms and exists in both.
// If it's the kind of exit you interact with (like, a door) it might be in a thinglist
// Otherwise, it's probably not.

// When you type "north", you're really calling ( (player.location).north ).go!

public class Exit {
	private Room side1, side2;
}
