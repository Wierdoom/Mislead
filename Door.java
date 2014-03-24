
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
	// Consider distinguishing between doors that lock and doors that don't lock
	// (maybe with a LockedDoor extends Door?)
	private Exit backs;
	private Thing key;
	private String openDesc = "It lies open now.";
	private String closedDesc = "";
	private String onOpen = "You open the door.";
	private String onClose = "You close the door.";
	private String onLock = "You lock the door.";
	private String onUnlock = "You unlock the door.";
	private String doorStopsYou = "The door is shut."; // printed when door stops you
	
	public void look(){
		Io.out(super.getDesc()+" "+(open?openDesc:closedDesc));
	}
	
	public void open(){
		if (!locked&&!open){open=true; backs.open(); Io.out(onOpen);}
		else if(Game.player().getInventory().has(key)&&!open){unlock(); open();}
	}
	public void close(){
		if (open){open=false; backs.close(doorStopsYou); Io.out(onClose);}
		else{Io.out("It's open already.");}
	}
	public void lock(){
		if (!locked){
			if (Game.player().getInventory().has(key)){setLocked(true); Io.out(onUnlock);}
			else{Io.out("You don't see a way of locking it right now.");}
		}
		else {Io.out("It's locked.");}
	}
	public void unlock(){
		if (locked){
			if (Game.player().getInventory().has(key)){setLocked(false); Io.out(onLock);}
			else{Io.out("You aren't carrying a key that fits.");}
		}
		else {Io.out("It's unlocked.");}
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
}
