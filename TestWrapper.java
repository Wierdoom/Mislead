//  Test wrapper for simple console gameplay.
// Contains three rooms, with a thing "snake" (with no behaviour) in the third one.
public class TestWrapper {

	public static void main(String[] args){
		Parser prs = new Parser();
		Game.setParser(prs);
		Player pl = new Player();
		Game.setPlayer(pl);
		Room r1, r2, r3;
		r1 = new Room("First Room","The first of many. The only exit lies to the north. Water trickles in from somewhere far above.","A bare room. The only exit is to the north.");
		r2 = new Room("Second Room","A vaulted corridor. Fresh moss carpets the walls and floor - this whole place seems oddly alive. A corridor runs to the south, leading to a massive door to the north.","A corridor running from the south that sits before a tremendous door.");
		r3 = new Room("Third Room","The legendary third room, which many adventurers have sought. Of course, you always told yourself you'd be the last. There is a SNAKE here.","The legendary third room. There is a SNAKE here.");
		new Exit(r1,r2,"ns");
		new Exit(r2,r3,"ns");
		Thing snake = new Thing("snake","The world-serpent, Jormungand, whose ancient flesh supports the firmament of the world.");
		Carryable liver = new Carryable("liver", "It's a fucking liver, bro.", "It's a fucking liver, dude.");
      Door gate = new Door("door","A tremendous stone door sits between you and passage further north.",r2.getNorth());
		gate.setOpenState(false);
		r3.getContents().add(snake);
      r2.getContents().add(liver);
		r1.enter();
		String in;
		while ( !(in=Io.in()).equals("quit")){
			prs.parse(in);
		}
	}
}
