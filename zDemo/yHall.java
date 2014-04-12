
public class yHall extends Room {

	private zPalm palm;
	
	public yHall() {
		super("Great Hall", "A tremendous stone statue, the solemn, round face of some "
				+ "ancient official, priest, king or deity rises above the long "
				+ "stone hall. One of his palms is "
				+ "outstretched.", "A great stone statue overlooks the hall, his palm outstretched."
						+ "There seems to be some mechanism built into the statue. A stairs down are"
						+ "to the south.");
		// TODO Auto-generated constructor stub
		
		//Putting the sapphire cylinder on the statue's palm
		zCylinder cylinder = new zCylinder();
		palm = new zPalm(cylinder);
		cylinder.setPalm(palm);
		add(cylinder);
		add(palm);
	}

	
	public void describe(boolean full){
		Io.out(getName());
		String result = "";
		if(full){
			result = getLongDescription();
		}
		else{
			result = getShortDescription();
		}
			if(palm.getHeld() instanceof zCylinder){
				result = result+" The outstretched palm holds a brilliant carved sapphire cylinder";
				
			}
			else if(palm.getHeld() instanceof zCamera){
				result = result+" The outstretched palm holds your camera. It keeps you safe for now.";
			}
		if(full){
			result = result + "The floor has a slight curve to it, creating a trough running "
					+ "through the middle of it leading to the staircase. The careful eye"
					+ "notes a seam on the tremendous, round statue head, and gaps in the"
					+ "surface where stone cogs seem to show. Some ancient machine"
					+ "is at play here, and it somehow seems oddly familiar."
					+ "Departure is along a staircase down to the south.";}
		Io.out(result);
		}
			
		}
