
public class Understand {
// A call to understand(thing, String) interprets a verb string
// Into a function, and performs that function
// Of given thing th.
	static void understand(Thing th, String verb){
		switch(verb){
		case "get":
			th.get();
			break;
		case "open":
			th.open();
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
		default:
			break;
		}
	}
}
