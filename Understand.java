public class Understand {
// A call to understand(thing, String) interprets a 3 word verb string
// Into a function, and performs that function
// Of given thing th.
	
	// Understands a one word command
	static void understand(String verb){
		switch(verb){
		case "north":
			Game.player().north();
			break;
		case "south":
			Game.player().south();
			break;
		case "east":
			Game.player().east();
			break;
		case "west":
			Game.player().west();
			break;
		case "up":
			Game.player().up();
			break;
		case "down":
			Game.player().down();
			break;
		case "look":
			Game.player().getLocation().describe(true);
			break;
		case "i":
			Io.out(Game.player().getInventory().list());
			break;
		default:
			System.out.println("Unknown command " + verb);
			break;
		}
	}
	
	
	// Understands a two word command
	static void understand(String verb, Thing th){
		switch(verb){
		case "look":
			th.look();
			break;
		case "get":
			th.get();
			break;
		case "open":
			th.open();
			break;
		case "close":
			th.close();
			break;
		case "drink":
			th.drink();
			break;
		case "eat":
			th.eat();
			break;
		case "hit":
			th.hit();
			break;
		case "read":
			th.read();
			break;
		case "go":
			th.go();
			break;
		case "enter":
			th.enter();
			break;
		case "lock":
			th.lock();
			break;
		case "unlock":
			th.unlock();
			break;
		default:
			System.out.println("Unknown command " + verb);
			break;
		}
	}
	
	//Understand a 3 word command
	static void understand(String verb, Thing th1, String word) {
		//shrek is dreck
	}
	
	//Understand a 4 word command
	static void understand(String verb, Thing th1, String word, Thing th2){
		//are you farquad
	}
}
