//Production demo game for Mislead.

public class zDemo {

	public static void main(String[] args){
		
//Initialise the game
Game game = new Game();
Io.setGame(game);	
	
//Create the water and the rain
	
zWater water = new zWater();
	
//Create the first few rooms
	

	
	
//ENTRYWAY
yEntryway entryway = new yEntryway(); 	


//ANTECHAMBER
yAntechamber antechamber = new yAntechamber(water);
new Exit(entryway,antechamber,"ew");

//START THE GAME

Io.out("A few days ago, a friend of yours doing research in the area complained to you- A logging company, ZexCo, doing some clear-cutting in the area stumbled upon an archaeological find- just from what you heard of the stonework alone, it's World Heritage Site material, and rumor is that it goes deeper still.");
Io.out("But it seems like they've been pouring a lot of effort into hushing it up. If the place ends up protected, they'll lose prime logging land.");
Io.out("So you're trespassing. If you can bring evidence back - serious handheld evidence - of the value of this place, UNESCO will come booming in and ZexCo will get booted out.");
Io.out("Well, I mean, you hope.");
Io.out("You clutch your camera and forge onwards through the brush...");
Game.player().getInventory().add(new zCamera());
entryway.enter();
	}

}



