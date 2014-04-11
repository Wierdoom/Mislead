// There are two approaches to the Great Hall, that connect it to the basin.
// (They're mostly an excuse to take it out of the water mechanics.)
// They're pretty similar.
public class yHallApproach extends Room {

	private zWater water;
	
	public yHallApproach(int number){
		super("Hall Approach", "", "");
		String longDescription ="", shortDescription ="";
		if (number==1){
			longDescription=longDescription+"Past the far edge of the basin on the third level, the stone "
					+ "passage quickly ascends, climbing steep, shallow steps somewhere beneath the earth. "
					+ "You can hear the rain still pounding overhead, and traces of it seep through the "
					+ "ceiling, falling in low rivulets. The stairs continue climbing to your west,"
					+ " whereas east leads back down to the basin.";
			shortDescription = shortDescription +"Stone stairs, sharply ascending. They continue to the west"
					+ " - east leads back down to the basin.";}
		if (number==2){
			longDescription = longDescription+ "Still the stairs climb, bending to the"
					+ " right, getting steeper and steeper. There are the first "
					+ "traces of icons on the walls around you -- depicting humans "
					+ "bowed in solemn silence, and always above them, throughout "
					+ "the designs, the constant piercing lines of pouring rain. "
					+ "Up to the north, the stairs seem to reach a room of some sort. "
					+ "East leads further down the stairs.";
			shortDescription = shortDescription+ "Stone steps spiral onwards. "
					+ "North enters some sort of room, east leads back down the "
					+ "staircase.";
		}
		setLongDescription(longDescription);
		setShortDescription(shortDescription);
		
		
	}
	
	// Takes you out of the water
	public void enter(){
		super.enter();
		if (water!=null){water.leaveWater();}
	}

	public void setWater(zWater water) {
		this.water = water;
	}

}
