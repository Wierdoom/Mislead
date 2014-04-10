// Water is a specific sort of thing that's
// 1. NOT VISIBLE
// 2. THINGS REFERENCE TO DETERMINE WHERE THEY ARE
// 3. KILLS YOU IF YOU SPEND TOO LONG UNDER IT

// rooms call enter / leave-water

public class zWater extends Thing {

	
// water-level ranges from 1 to 4
int level;
//breathcount ranges from 1-4 (4 is death)
int breathCount;

//true if you're in the water
boolean in;
	
	public zWater() {
		super("water", "",false);
		setVisible(false);
		breathCount = 0;
		level = 1;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	// Function for going below water
	public void enterWater(){
		if(!in){
		in = true;
		schedule(5);
		
		
		Thing torch = Game.player().getInventory().find("torch");
		if (torch instanceof zTorch){
			// We have promised that the torch is indeed the zTorch, so we're good
			((zTorch) torch).extinguish();
		}
		}
	}
	
	// Call this function when you're swimming in the water.
	// Torches go out, but you don't need to worry about breathing.
	public void swim(){
		Thing torch = Game.player().getInventory().find("torch");
		if (torch instanceof zTorch){
			// We have promised that the torch is indeed the zTorch, so we're good
			((zTorch) torch).extinguish();
		}
	}
	
	public void leaveWater(){
		if (in){
		in = false;
		if (breathCount >2){
			Io.out("As you reach the surface of the water, you sputter as you fill your lungs with fresh air.");
			unschedule();
		}
		else{
			Io.out("You take a welcome breath of air as you surface.");
			unschedule();
		}
		breathCount = 0;
		}
	}
	
	public void tick(){
		if(breathCount++>3){
			drown();
		}
		else if (breathCount>1){
			Io.out("You're running out of breath.");
			schedule(5);
		}
		else{
			Io.out("This would be easier with a scuba tank, but you can hold your breath for now.");
			schedule(5);
		}
	}
	private void drown(){
		//end the game by drowning
	}
}