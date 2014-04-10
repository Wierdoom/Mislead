
public class zCamera extends Carryable {

	public zCamera() {
		super("camera", "A waterproof camera. It isn't your best one, but you'd be a fool to bring your best one in this rain. You can PHOTOGRAPH things as long as you have it.", "Your camera is here.");
	}

	public void use(){
		Io.out("You take a photo of the area. If there's anything of particular interest, try PHOTOGRAPHing it.");
	}
	public void use (Thing o){
		o.photograph();
	}
}
