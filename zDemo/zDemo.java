//Production demo game for Mislead.

public class zDemo {

	public static void main(String[] args){
		
//Initialise the game
Game game = new Game();
Io.setGame(game);	
	
//Create the water and the rain
	
zWater water = new zWater();
water.setLevel(2);
zRain rain = new zRain(water);
	
//Create the first few rooms
	

	
	
//ENTRYWAY
yEntryway entryway = new yEntryway(); 	


//ANTECHAMBER
yAntechamber antechamber = new yAntechamber(water);
yDescent descent = new yDescent(water);
new Exit(entryway,antechamber,"ew");
new Exit(antechamber,descent,"du");




//BASIN

zPillar pillar = new zPillar();
yBasinCenter center1 = new yBasinCenter(water,rain,pillar);
center1.setFloodHeight(3); center1.setWetHeight(2);
yBasinCenter center2 = new yBasinCenter(water,rain,pillar);
center2.setFloodHeight(4); center2.setWetHeight(3);
yBasinSide side1 = new yBasinSide(water, rain, 1);
yBasinSide side2 = new yBasinSidePillars(water, rain);
yBasinSide side3 = new yBasinSide(water, rain, 3);
yBasinSide side4 = new yBasinSide(water, rain, 4);

yTowerRoom tower1 = new yTowerRoom(water,true);
yTowerRoom tower2 = new yTowerRoom(water,true);
yTowerRoom tower3 = new yTowerRoom(water,false);

pillar.setCenterMed(center1);
side2.add(pillar);

new Exit(descent,side1,"ew");
new PitExit(side1,center1,"ew");
new PitExit(side2,center1,"we");
new PitExit(side3,center2,"ew");
new PitExit(side4,center2,"we");
new SwimExit(center1,center2);

new Exit(side2,tower1,"ew");
new Exit(side4,tower2,"ew");

new Exit(tower1,tower2,"ud");
new Exit(tower2,tower3,"ud");

//CONTROL ROOM
yControlTower controlroom = new yControlTower(water,rain);
new Exit(tower3,controlroom,"ud");

//TOP FLOOR, halls and approach

yHall hall = new yHall();
yHallApproach approach1 = new yHallApproach(1);
approach1.setWater(water); // so it can call leaveWater();
yHallApproach approach2 = new yHallApproach(2);

new Exit(approach1,approach2,"we");
new Exit(approach2,hall,"ns");
new Exit(approach1,side3,"ew");

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



