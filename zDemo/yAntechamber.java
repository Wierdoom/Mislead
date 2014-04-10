
public class yAntechamber extends WaterRoom {

	public yAntechamber(zWater water) {
		super("Antechamber", "A bath of warmth hits you as you descend into the earth, into a circular stone chamber bathed in the light of a roaring flame. A firepit fills the center of the room, set on a circular patch of dirt that the black stone tiles encircle. Torches line alcoves along the outer rim of the room - you consider taking one. The exit rises to the west.", "The circular antechamber, filled with a firepit. West leads out of the ruin.", "A stairwell on the far side leads down.", "The water that fills a stairwell on the far side of the room reflects with coruscating orange light.","",water);
		zTorch torch = new zTorch();
		zFirepit firepit = new zFirepit();
		add(torch);
		add(firepit);
		
		//test lighting the torch
		
	}
	
}
