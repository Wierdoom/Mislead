public class Understand {
// A call to understand(thing, String) interprets a 3 word verb string
// Into a function, and performs that function
// Of given thing th.
	
	static void understand(String verb, Thing th1, Thing th2){
		if (th2 == null){understand(verb,th1);}
		else{
			switch(verb){
				case "look":
					th1.look(th2);
					break;
				case "get":
					th1.get(th2);
					break;
				case "open":
					th1.open(th2);
					break;
				case "close":
					th1.close(th2);
					break;
				case "drink":
					th1.drink(th2);
					break;
				case "eat":
					th1.eat(th2);
					break;
				case "hit":
					th1.hit(th2);
					break;
				case "read":
					th1.read(th2);
					break;
				case "go":
					th1.go(th2);
					break;
				case "enter":
					th1.enter(th2);
					break;
				case "lock":
					th1.lock(th2);
					break;
				case "unlock":
					th1.unlock(th2);
					break;
				default:
					System.out.println("Unknown command " + verb);
					break;
			}
		}
	}
	
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
		if(th==null){understand(verb);}
		else{
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
	}
	
	
}
