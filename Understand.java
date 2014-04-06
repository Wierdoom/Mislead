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
               Time.checkTick();
					break;
				case "get":
					th1.get(th2);
               Time.increment();
               Time.checkTick();
					break;
				case "open":
					th1.open(th2);
               Time.increment();
               Time.checkTick();
					break;
				case "close":
					th1.close(th2);
               Time.increment();
               Time.checkTick();
					break;
				case "drink":
					th1.drink(th2);
               Time.increment();
               Time.checkTick();
					break;
				case "eat":
					th1.eat(th2);
               Time.increment();
               Time.checkTick();
					break;
				case "hit":
					th1.hit(th2);
               Time.increment();
               Time.checkTick();
					break;
				case "read":
					th1.read(th2);
               Time.increment();
               Time.checkTick();
					break;
				case "go":
					th1.go(th2);
               Time.increment();
               Time.checkTick();
					break;
				case "enter":
					th1.enter(th2);
               Time.increment();
               Time.checkTick();
					break;
				case "lock":
					th1.lock(th2);
               Time.increment();
               Time.checkTick();
					break;
				case "unlock":
					th1.unlock(th2);
               Time.increment();
               Time.checkTick();
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
         Time.checkTick();
			break;
		case "south":
			Game.player().south();
         Time.increment();
         Time.checkTick();
			break;
		case "east":
			Game.player().east();
         Time.increment();
         Time.checkTick();
			break;
		case "west":
			Game.player().west();
         Time.increment();
         Time.checkTick();
			break;
		case "up":
			Game.player().up();
         Time.increment();
         Time.checkTick();
			break;
		case "down":
			Game.player().down();
         Time.increment();
         Time.checkTick();
			break;
		case "look":
			Game.player().getLocation().describe(true);
         Time.increment();
         Time.checkTick();
			break;
		case "i":
			Io.out(Game.player().getInventory().list());
         Time.increment();
         Time.checkTick();
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
         Time.checkTick();
			break;
		case "get":
			th.get();
         Time.increment();
         Time.checkTick();
			break;
		case "drop":
			th.drop();
         Time.increment();
         Time.checkTick();
			break;
		case "open":
			th.open();
         Time.increment();
         Time.checkTick();
			break;
		case "close":
			th.close();
         Time.increment();
         Time.checkTick();
			break;
		case "drink":
			th.drink();
         Time.increment();
         Time.checkTick();
			break;
		case "eat":
			th.eat();
         Time.increment();
         Time.checkTick();
			break;
		case "hit":
			th.hit();
         Time.increment();
         Time.checkTick();
			break;
		case "read":
			th.read();
         Time.increment();
         Time.checkTick();
			break;
		case "go":
			th.go();
         Time.increment();
         Time.checkTick();
			break;
		case "enter":
			th.enter();
         Time.increment();
         Time.checkTick();
			break;
		case "lock":
			th.lock();
         Time.increment();
         Time.checkTick();
			break;
		case "unlock":
			th.unlock();
         Time.increment();
         Time.checkTick();
			break;
		default:
			System.out.println("Unknown command " + verb);
			break;
		}
	}
}
