
public class WaterRoom extends Room {

protected zWater water;
private int wetHeight;
private int floodHeight;

//descriptions for each of three water states
private String dry, wet, flood;
	
	public WaterRoom(String name, String longDescription,
			String shortDescription, String dry, String wet, String flood, zWater water) {
		super(name, longDescription, shortDescription);
		wetHeight = 5; // puts out of bounds
		floodHeight = 5; // puts out of bounds
		this.water = water;
		
		this.dry = dry;
		this.wet = wet;
		this.flood = flood;

	}

	public void enter(){
		if(isFlooded()){
			water.enterWater();
		}
		else{
			water.leaveWater();
		}
		super.enter();
		if (getUp() instanceof SwimExit){
			((SwimExit) getUp()).isOpen();
		}
		if (getDown() instanceof SwimExit){
			((SwimExit) getDown()).isOpen();
		}
	}
	
	/*
	public void describe(boolean full){
		Io.out(getName());
		if(full){Io.out(getLongDescription());}
		else{Io.out(getShortDescription());}
	}
	*/
	
	
	
	public void describe(boolean full){
		super.describe(full);
		if(isFlooded()){Io.out(flood);}
		else if(isWet()){Io.out(wet);}
		else {Io.out(dry);}
		}
		
	
	//Called on a room when the water rises in it, dunking you into the water.
	public void waterRise(){
		if(water.getLevel()==floodHeight){
			Io.out("The rising water fills the room, forcing you to swim.");
			water.enterWater();}
		if(water.getLevel()==wetHeight){
			Io.out("Rising water seeps into the room, steadily climbing.");
		}
		}

	public int getWetHeight() {
		return wetHeight;
	}

	public void setWetHeight(int wetHeight) {
		this.wetHeight = wetHeight;
	}

	public int getFloodHeight() {
		return floodHeight;
	}

	public void setFloodHeight(int floodHeight) {
		this.floodHeight = floodHeight;
	}
	
	// Checks each of the water states of the room
	public boolean isFlooded(){
		return water.getLevel()>=floodHeight;
	}
	public boolean isWet(){
		return water.getLevel()>=wetHeight&&water.getLevel()<floodHeight;
	}
	public boolean isDry(){
		return water.getLevel()<wetHeight;
	}


	public void setDry(String dry) {
		this.dry = dry;
	}

	public void setWet(String wet) {
		this.wet = wet;
	}

	public void setFlood(String flood) {
		this.flood = flood;
	}
}
