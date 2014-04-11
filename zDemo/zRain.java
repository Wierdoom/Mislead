//Rain is a sort of thing that's:
//1. Not visible
//2. Scheduled whenever rain is falling in the basin
//3. Fills the basin up with water

public class zRain extends Thing {

	private boolean openToRain; // Boolean that's true if the basin is open
	private boolean rainCanGather; // Boolean that's true if the drainway is closed
	private zWater water; // Pointer to the water object

	public zRain(zWater water) {
		super("rain", "", false);
		this.water = water;
	}

	// True if rain is gathering in the basin
	private boolean raining(){
		return openToRain&&rainCanGather;
	}
	
	// Called when entering a room where it can rain.
	public void rainOnPlayer() {
		
		if(openToRain){
		Io.out("Nonstop rain beats down from above.");
		Thing torch = Game.player().getInventory().find("torch");
		if (torch instanceof zTorch){
			// We have promised that the torch is indeed the zTorch, so we're good
			((zTorch) torch).extinguish();
		}
		}
	}
	
	// Schedule the rain when the valve is opened OR the drainway is closed
	public void tick(){
		if (raining()){
			water.raiseLevel();
			Room loc = Game.player().getLocation();
			if (loc instanceof WaterRoom){
				((WaterRoom) loc).waterRise();
			}
			schedule(6);
		}
	}

	public boolean isOpenToRain() {
		return openToRain;
	}

	public void setOpenToRain(boolean openToRain) {
		this.openToRain = openToRain;
		//TODO have this schedule / unschedule the rain appropriately
	}

	public boolean isRainCanGather() {
		return rainCanGather;
	}

	public void setRainCanGather(boolean rainCanGather) {
		this.rainCanGather = rainCanGather;
		//TODO have this schedule / unschedule the rain appropriately
	}
	
	
	
}

