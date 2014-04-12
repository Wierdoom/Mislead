
public class zFirebox extends Thing {

	boolean lit;
	
	//reference to the lever
	zControlLever lever;
	// reference to the other machine when ready
	
	public zFirebox() {
		super("firebox", "A squat iron-box barely lit by the light from the window."
				+ " Filled with a strange blue-glistening tar, it smells deeply of mustard.");
		lit = false;
	}
	
	public void light(){
		if (!lit){
		lit = true;
		Io.out("As you touch your torch to the firebox, the strange tar catches with roaring fire.");
		Io.out("After a moment, there's a faint hum and a low grinding from the machines that surround you.");
		setDesc("A firebox that burns with a roaring, smokeless flame.");
		lever.setActive(true);
		}
	}
	// if you hit it with the torch, try using the torch on it
	public void hit(zTorch t){
		t.use(this);
	}
	

	

	public boolean isLit() {
		return lit;
	}
}

