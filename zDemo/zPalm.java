
public class zPalm extends Thing {

	private Thing held;
	private boolean problem;
	
	public zPalm(Thing treasure) {
		super("palm", "The outstretched palm of the statue of some great figure, shown dressed in raiments utterly unknown to your tradition.");
		held = treasure;
		problem = false;
	}

	public void look(){
		String result = desc;
		if (held!=null){result = result+" Sitting in the stone palm is the "+held+".";}
	}
	
	public void push(){
		Io.out("It shifts a little, pushing against some counterweight somewhere.");
	}
	public void pull(){
		Io.out("It rises a bit as you pull it, pushed by some counterweights somewhere.");
	}
	
	public void photoSuccess(){
		if(held!=null){
		held.photoSuccess();}
		else{
			Io.out("You snap a photo of the statue's palm, rising on some ancient mechanism.");
		}
	}
	
	public void tick(){
		if(held == null){
			if(!problem){
				problem=true;
				Io.out("Unburdened - and exactly as you expected - the empty hand begins rising upwards.");
				Io.out("Ominous noises issue as the statue's head begins cracking.");
				schedule(2);
			}
			else{
				//if player is still in room
				if(Game.player().getLocation() instanceof yHall){
				Io.out("With a sudden crash, the statue's head comes rolling off its shoulders, propelled by a mechanical hammer into you. The second-last thing that goes through your head is how utterly baffled historians would be at this find.");
				Io.out("The last is a giant rock.");}
				//if player left room
				else{
				Io.out("With terrible speed, the statue's head comes rolling down the stairs at you, flattening you.");
				Io.out("Just like in that one American movie, with Harrison Ford.");
				}
				flatten();
			}
		}
	}
	
	// Kill the player.
	private void flatten(){
      end.gameOver(false);
   }

	public Thing getHeld() {
		return held;
	}

	public void setHeld(Thing held) {
		this.held = held;
		if (held!=null){
			unschedule();
			problem = false;
		}
	}
}
	
