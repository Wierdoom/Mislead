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
					Game.getTime().increment();
					break;
				case "get":
					th1.get(th2);
					Game.getTime().increment();
					break;
				case "open":
					th1.open(th2);
					Game.getTime().increment();
					break;
				case "close":
					th1.close(th2);
					Game.getTime().increment();
					break;
				case "drink":
					th1.drink(th2);
					Game.getTime().increment();
					break;
				case "eat":
					th1.eat(th2);
					Game.getTime().increment();
					break;
				case "hit":
					th1.hit(th2);
					Game.getTime().increment();
					break;
				case "read":
					th1.read(th2);
					Game.getTime().increment();
					break;
				case "go":
					th1.go(th2);
					Game.getTime().increment();
					break;
				case "enter":
					th1.enter(th2);
					Game.getTime().increment();
					break;
				case "lock":
					th1.lock(th2);
					Game.getTime().increment();
					break;
				case "unlock":
					th1.unlock(th2);
					Game.getTime().increment();
					break;
				case "use":
					th1.use(th2);
					Game.getTime().increment();
					break;
				case "photograph":
					th1.photograph(th2);
					Game.getTime().increment();
				default:
					Io.out("Unknown command " + verb);
					break;
			}
		}
	}
	
	// Understands a one word command
	static void understand(String verb){
		switch(verb){
		case "north":
			Game.player().north();
			Game.getTime().increment();
			break;
		case "south":
			Game.player().south();
			Game.getTime().increment();
			break;
		case "east":
			Game.player().east();
			Game.getTime().increment();
			break;
		case "west":
			Game.player().west();
			Game.getTime().increment();
			break;
		case "up":
			Game.player().up();
			Game.getTime().increment();
			break;
		case "down":
			Game.player().down();
			Game.getTime().increment();
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
			Game.getTime().increment();
			break;
		case "get":
			th.get();
			Game.getTime().increment();
			break;
		case "drop":
			th.drop();
			Game.getTime().increment();
			break;
		case "open":
			th.open();
			Game.getTime().increment();
			break;
		case "close":
			th.close();
			Game.getTime().increment();
			break;
		case "drink":
			th.drink();
			Game.getTime().increment();
			break;
		case "eat":
			th.eat();
			Game.getTime().increment();
			break;
		case "hit":
			th.hit();
			Game.getTime().increment();
			break;
		case "read":
			th.read();
			Game.getTime().increment();
			break;
		case "go":
			th.go();
			Game.getTime().increment();
			break;
		case "enter":
			th.enter();
			Game.getTime().increment();
			break;
		case "lock":
			th.lock();
			Game.getTime().increment();
			break;
		case "unlock":
			th.unlock();
			Game.getTime().increment();
			break;
		case "use":
			th.use();
			Game.getTime().increment();
		case "photograph":
			th.photograph();
			Game.getTime().increment();
		default:
			Io.out("Unknown command " + verb);
			break;
		}
	}
}
	
}
