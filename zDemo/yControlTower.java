public class yControlTower extends WaterRoom {

	private zRain rain;

   public yControlTower(zWater water, zRain rain) {
		super("Control Tower", "A strange sight - at the top of the spiral staircase is a circular room full of chains and strange machines. There's a firebox on one side that smells of mustard, connected to a machine with a long lever. Outside, a window looks out onto the pouring rain and the clearcut jungle.", "The control room. Stairs lead downwards. A machine with a lever and a firebox sits next to a window.", "", "","",water);
		this.rain = rain;
		zFirebox firebox = new zFirebox();
		zControlLever lever = new zControlLever(rain);
		firebox.setLever(lever);
		//zMachine machine = new zMachine(Part octagon);
		add(lever);
		add(firebox);
      //add(machine);
   }
   
   public void describe(boolean full){
	   super.describe(full);
	   if(rain.isOpenToRain()){Io.out("The basin's lid has been opened, and rain pours in.");}
	   else{Io.out("Out the window, you can see a broad, man-made pool that swells with rainwater. Looks like it's right over the basin.");}
   }
}