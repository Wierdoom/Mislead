public class Door extends Thing {

	public Door(String name, String desc, Exit exit) {
		super(name, desc);
		backs = exit;
		backs.getSide1().add(this);
		backs.getSide2().add(this);
		// TODO Auto-generated constructor stub
		// TODO - add to relevant thinglists!
	}
	private boolean locked, open;
	// Consider implementing bool keyKnown, s.t unlocking is only automatic if you know you have the key
	private Exit backs;

	private String openDesc = "It lies open now.";
	private String closedDesc = "";
	private String onOpen = "You open the door.";
	private String onClose = "You close the door.";
	
	private String doorStopsYou = "The door is shut."; // printed when door stops you
	
	public void look(){
		Io.out(super.getDesc()+" "+(open?openDesc:closedDesc));
	}
	
	public void open(){
		if (!locked&&!open){open=true; backs.open(); Io.out(onOpen);}
	}
	public void close(){
		if (open){open=false; backs.close(doorStopsYou); Io.out(onClose);}
		else{Io.out("It's open already.");}
	}
	
	public void setOpenState(boolean o){
		if(o){open=true; backs.open();}
		else{open=false; backs.close(doorStopsYou);}
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public String getOpenDesc() {
		return openDesc;
	}
	public void setOpenDesc(String openDesc) {
		this.openDesc = openDesc;
	}
	public String getClosedDesc() {
		return closedDesc;
	}
	public void setClosedDesc(String closedDesc) {
		this.closedDesc = closedDesc;
	}
	public String getOnOpen() {
		return onOpen;
	}
	public void setOnOpen(String onOpen) {
		this.onOpen = onOpen;
	}
	public String getOnClose() {
		return onClose;
	}
	public void setOnClose(String onClose) {
		this.onClose = onClose;
	}
	public String getDoorStopsYou() {
		return doorStopsYou;
	}
	public void setDoorStopsYou(String doorStopsYou) {
		this.doorStopsYou = doorStopsYou;
	}
	
	//Methods for incase the player tries to be crafty
	public void get(){
		Io.out("This is indeed a fine door, but you will need more than your own physical strength to remove it from its place.");
		// Synonym: "take", "t"
	}
	public void drop(){
		Io.out("Since the door is not in your possesssion, you are unable to drop it.");
		// Synonym: "d", error this properly for two-noun case
	}
	public void drink(){
		Io.out("The door is much too solid to be imbibed.");
		// Synonym: "quaff" "imbibe"
	}
	public void eat(){
		Io.out("As clever as you think it might be to eat your way through, you realize your teeth and metabolism will be unable to handle the strain.");
	}
}
