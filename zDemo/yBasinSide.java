
public class yBasinSide extends WaterRoom {

	private zRain rain;
	
	public yBasinSide(zWater water, zRain rain, int number) {
		super("Basin Side", "A short stone ledge that overlooks a huge reservoir "
				+ "at the heart of the tunnel systems, a huge cylindrical"
				+ " basin wrought from dark stone.", 
				"A ledge overlooking the basin.", 
				" The water-level is far beneath the ledge, now.", " The water rises gently"
						+ " over the ledge, filling the basin.", " You swim through"
								+ " murky water.", water);
		this.rain = rain;
		String exitAppend = "";
		switch (number){
		case 1: case 3:
			exitAppend = "Stairs rise to the west. The basin is to the east.";
			break;
		case 2: case 4:
			exitAppend = "A short hall runs to the east. The basin is to the west.";
			break;
		}
		switch(number){
		case 1: case 2:
			setFloodHeight(3);
			setWetHeight(2);
			break;
		case 3: case 4:
			setFloodHeight(4);
			setWetHeight(3);
			break;
		}
		
		setLongDescription(getLongDescription()+exitAppend);
		setShortDescription(getShortDescription()+exitAppend);
		}
	
	public void describe(boolean full){
		super.describe(full);
		if (rain.isOpenToRain()){
			Io.out("Torrential rain pours down onto the basin from above.");
		}
	}

}
