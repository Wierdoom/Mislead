
public class zCylinder extends Carryable {

private boolean onStatue;
private zPalm palm;
	
	public zCylinder() {
		super("cylinder", "A cylinder carved of brilliant, clear sapphire, with carved facets running deep inside the piece. A magnificent work of art.", "The sapphire cylinder is lying here.");
	}

	public boolean isOnStatue() {
		return onStatue;
	}

	public void setOnStatue(boolean onStatue) {
		this.onStatue = onStatue;
	}
	
	public void get(){
		if(onStatue){
			Io.out("The statue's palm begins rising with a click as you take the brilliant gem cylinder.");
			palm.setHeld(null);
			onStatue = false;
			palm.schedule(2);
		}
		super.get();
	}
	
	//TODO find the camera and call camera.bigScoop() on it
	public void photoSuccess(){
		
	}
	
	public void put(Thing o){
		if(o instanceof zPalm){
			if(((zPalm) o).getHeld() !=null){
				Io.out("There's already something there.");
			}
			else{
			Io.out("You set the cylinder back on the palm, stopping the mechanism.");
			((zPalm) o).setHeld(this);
			drop();
			onStatue = true;
			}
		}
		else{super.put(o);}
	}

	//We need to be able to schedule the palm's event, so we point back to it
	public void setPalm(zPalm palm) {
		this.palm = palm;
		onStatue = true;
	}
}
	
