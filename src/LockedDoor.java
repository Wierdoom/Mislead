//Class for locked doors that can only be opened by certain keys
public class LockedDoor extends Door {
	// Consider implementing bool keyKnown, s.t unlocking is only automatic if you know you have the key
	
	
	private Thing key;
	private String onLock = "You lock the door.";
	private String onUnlock = "You unlock the door.";
	private String keyFail = "That doesn't fit the keyhole.";
	
	public LockedDoor(String name, String desc, Exit exit, Thing key){
		super(name,desc,exit);
		this.key = key;
		setLocked(true);
	}
	
	
	
	public void lock(){
		if (!isLocked()){
			Io.out("This requires a key.");
		}
		else {Io.out("It's already locked.");}
	}
	public void unlock(){
		if (isLocked()){
			Io.out("Unlock it with what?");
		}
		else {Io.out("It's already unlocked.");}
	}
	
	public void lock(Thing th){
		if (!isLocked()){
			
			if(th==key){
				Io.out(onLock);
				setLocked(true);}
			else{
			Io.out(keyFail);
			}}
		else {Io.out("It's already locked.");}
	}
		
		

	public void unlock(Thing th){
		if (isLocked()){
			
			if(th==key){
				Io.out(onUnlock);
				setLocked(false);}
			else{
			Io.out(keyFail);
			}}
		else {Io.out("It's already unlocked.");}
	}



	public void setKey(Thing key) {
		this.key = key;
	}



	public void setOnLock(String onLock) {
		this.onLock = onLock;
	}



	public void setOnUnlock(String onUnlock) {
		this.onUnlock = onUnlock;
	}



	public void setKeyFail(String keyFail) {
		this.keyFail = keyFail;
	}



	public Thing getKey() {
		return key;
	}
	
}
