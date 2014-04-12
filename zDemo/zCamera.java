public class zCamera extends Carryable {

	// Flip this if you take a photo of something interesting
	boolean interestingPhoto;
	
	// Functionality for being a weight on the statue
	boolean onStatue;
	zPalm palm;
	
	public zCamera() {
		super("camera", "A waterproof camera. It isn't your best one, but you'd be a fool to bring your best one in this rain. You can PHOTOGRAPH things as long as you have it.", "Your camera is here.");
	}

	public void use(){
		Io.out("You take a photo of the area. If there's anything of particular interest, try PHOTOGRAPHing it.");
	}
	public void use (Thing o){
		o.photograph();
	}

	public boolean isInterestingPhoto() {
		return interestingPhoto;
	}

	public void bigScoop() {
		if(!interestingPhoto){
		this.interestingPhoto = true;
		Io.out("That photo should turn a few heads when you get it developed.");
		}
	}
	
	// Statue puzzle functionality
	
	public void get(){
		if(onStatue){
			Io.out("The statue's palm begins rising with a click as you take your camera back.");
			palm.setHeld(null);
			palm.schedule(2);
		}
		super.get();
	}

	public boolean isOnStatue() {
		return onStatue;
	}

	public void setOnStatue(boolean onStatue) {
		this.onStatue = onStatue;
	}

	
	public void put(Thing o){
		if(o instanceof zPalm){
			if(((zPalm) o).getHeld() !=null){
				Io.out("There's already something there.");
			}
			else{
			Io.out("You set the camera onto the palm, stopping the mechanism. Guess the weights match.");
			((zPalm) o).setHeld(this);
			drop();
			onStatue = true;
			}
		}
		else{super.put(o);}
	}

	
	public void setPalm(zPalm palm) {
		this.palm = palm;}
	
	//misc methods
	public void eat() {
		Io.out("You realize your camera is much too important to be used as a light snack.");
	}
	public void drink() {
		Io.out("The camera is not liquid enough to drink.");
	}
	public void enter(){
		Io.out("Your camera would need to be at least three times bigger to fit you inside of it.");
	}
   
   // Overrides the original photoSuccess method to flip the interestingPhoto boolean.
   public void photoSuccess(Thing that) {
		Io.out("You line up and snap a good photo of the " + that.getName() + ".");
      if (that.getName().equals("cylinder")) {
         bigScoop();
      }
	}
}
