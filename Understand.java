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
               Time.increment();
					break;
				case "get":
					th1.get(th2);
               Time.increment();
					break;
				case "open":
					th1.open(th2);
               Time.increment();
					break;
				case "close":
					th1.close(th2);
               Time.increment();
					break;
				case "drink":
					th1.drink(th2);
               Time.increment();
					break;
				case "eat":
					th1.eat(th2);
               Time.increment();
					break;
				case "hit":
					th1.hit(th2);
               Time.increment();
					break;
				case "read":
					th1.read(th2);
               Time.increment();
					break;
				case "go":
					th1.go(th2);
               Time.increment();
					break;
				case "enter":
					th1.enter(th2);
               Time.increment();
					break;
				case "lock":
					th1.lock(th2);
               Time.increment();
					break;
				case "unlock":
					th1.unlock(th2);
               Time.increment();
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
         Time.increment();
			break;
		case "south":
			Game.player().south();
         Time.increment();
			break;
		case "east":
			Game.player().east();
         Time.increment();
			break;
		case "west":
			Game.player().west();
         Time.increment();
			break;
		case "up":
			Game.player().up();
         Time.increment();
			break;
		case "down":
			Game.player().down();
         Time.increment();
			break;
		case "look":
			Game.player().getLocation().describe(true);
         Time.increment();
			break;
		case "i":
			Io.out(Game.player().getInventory().list());
         Time.increment();
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
         Time.increment();
			break;
		case "get":
			th.get();
         Time.increment();
			break;
		case "drop":
			th.drop();
         Time.increment();
			break;
		case "open":
			th.open();
         Time.increment();
			break;
		case "close":
			th.close();
         Time.increment();
			break;
		case "drink":
			th.drink();
         Time.increment();
			break;
		case "eat":
			th.eat();
         Time.increment();
			break;
		case "hit":
			th.hit();
         Time.increment();
			break;
		case "read":
			th.read();
         Time.increment();
			break;
		case "go":
			th.go();
         Time.increment();
			break;
		case "enter":
			th.enter();
         Time.increment();
			break;
		case "lock":
			th.lock();
         Time.increment();
			break;
		case "unlock":
			th.unlock();
         Time.increment();
			break;
		default:
			System.out.println("Unknown command " + verb);
			break;
		}
	}
}
