
public class yEntryway extends Room {

	public yEntryway(){
		super("Entryway","You had to buy a few people a few drinks to find this. Just off of a logging trail to the west, you can see a trapezoidal tunnel of black, carved stone stretching out to the east. The torrential rain roars a chorus as it hits along the canopy above and the ferns all around you.","The first glimpse of the complex is in a stone tunnel to the east. To the west, the logging trail you came from. Heavy rain - it hasn't stopped for a month - surrounds you.");
		Thing tunnel = new Thing("tunnel","The engravings along the entrance to the east are purely geometrical - no people depicted, no animals, no objects, just lines and hexagons. Unusual for the area.");
		getContents().add(tunnel);
	}
}
