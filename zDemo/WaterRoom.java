
public class WaterRoom extends Room {

private zWater water;
private int wetHeight;
private int floodHeight;

//descriptions for each of three water states
private String dryDesc, wetDesc, floodDesc;
private String dryDescShort, wetDescShort, floodDescShort;
	
	public WaterRoom(String name, String longDescription,
			String shortDescription, String dry, String wet, String flood, zWater water) {
		super(name, longDescription, shortDescription);
		wetHeight = 5; // puts out of bounds
		floodHeight = 5; // puts out of bounds
		this.water = water;
		
		dryDesc = longDescription+" "+dry;
		dryDescShort = shortDescription+" "+dry;
		
		wetDesc = longDescription+" "+wet;
		wetDescShort = shortDescription+" "+wet;
		
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
			((SwimExit) getUp()).checkOpen();
		}
		if (getDown() instanceof SwimExit){
			((SwimExit) getDown()).checkOpen();
		}
	}
	
	public void describe(boolean full){
		if(isFlooded()){
			setLongDescription(floodDesc);
			setShortDescription(floodDescShort);		
		}
		else if(isWet()){
			setLongDescription(wetDesc);
			setShortDescription(wetDescShort);
		}
		else{
			setLongDescription(dryDesc);
			setShortDescription(dryDescShort);
		}
		super.describe(full);
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
}
