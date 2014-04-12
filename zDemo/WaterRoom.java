
public class WaterRoom extends Room {

protected zWater water;
private int wetHeight;
private int floodHeight;

//descriptions for each of three water states
private String dryDesc, wetDesc, floodDesc;
private String dryDescShort, wetDescShort, floodDescShort;
private String dry, wet, flood;
	
	public WaterRoom(String name, String longDescription,
			String shortDescription, String dry, String wet, String flood, zWater water) {
		super(name, longDescription, shortDescription);
		wetHeight = 5; // puts out of bounds
		floodHeight = 5; // puts out of bounds
		this.water = water;
		
		this.dry = dry;
		dryDesc = longDescription+" "+dry;
		dryDescShort = shortDescription+" "+dry;
		
		this.wet = wet;
		wetDesc = longDescription+" "+wet;
		wetDescShort = shortDescription+" "+wet;
		
		this.flood = flood;
		floodDesc = longDescription+" "+flood;
		floodDescShort = shortDescription+" "+flood;
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
		if(full){
			if(isFlooded()){Io.out(floodDesc);}
			else if(isWet()){Io.out(wetDesc);}
			else {Io.out(dryDesc);}
		}
		else{
			if(isFlooded()){Io.out(floodDescShort);}
			else if(isWet()){Io.out(wetDescShort);}
			else {Io.out(dryDescShort);}
		}
		
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

	public void setWetDesc(String wetDesc) {
		this.wetDesc = getLongDescription()+wetDesc;
		this.wetDescShort = getShortDescription()+wetDesc;
	}
	public void setDryDesc(String dryDesc) {
		this.wetDesc = getLongDescription()+dryDesc;
		this.wetDescShort = getShortDescription()+dryDesc;
	}
	public void setFloodDesc(String floodDesc) {
		this.wetDesc = getLongDescription()+floodDesc;
		this.wetDescShort = getShortDescription()+floodDesc;
	}
	
	public void setLongDescription(String str){
		super.setLongDescription(str);
		setWetDesc(wet);
		setDryDesc(dry);
		setFloodDesc(flood);
	}
	public void setShortDescription(String str){
		super.setShortDescription(str);
		setWetDesc(wet);
		setDryDesc(dry);
		setFloodDesc(flood);
	}
}
