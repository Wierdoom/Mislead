// Superclass for game objects
public class Thing {

	public Thing(String name, String desc) {
		this.visible = true;
		this.name = name;
		this.desc = desc;
		Game.getParser().addNoun(name);
	}
	public Thing(String name, String desc, String adj) {
		this.visible = true;
		this.name = name;
		this.desc = desc;
		this.adj = adj;
		Game.getParser().addNoun(name);
	}
	public Thing(String name, String desc, boolean visible){
		this.visible = visible;
		this.name = name;
		this.desc = desc;
		Game.getParser().addNoun(name);
	}
	public Thing(String name, String desc,boolean visible, String adj) {
		this.visible = visible;
		this.name = name;
		this.desc = desc;
		this.adj = adj;
		Game.getParser().addNoun(name);
	}
	boolean visible; // If false, does not appear in wordlist searches (is not present in the game)
	String name; // We have one name.
	String desc; // Description
	String adj; //Accompanying adjective
	
	//1 VERB
	
	public void look(){
		Io.out(desc);
		// Synonym: "examine", "x"
	}
	
	public void get(){
		Io.out("This isn't something you can pick up and carry.");
		// Synonym: "take", "t"
	}
	public void drop(){
		Io.out("You can't drop what you can't carry!");
		// Synonym: "d", error this properly for two-noun case
	}
	
	public void open(){
		Io.out("You'd need to break it open first.");
		// Synonym: "shut"
	}
	public void close(){
		Io.out("You won't be able to close that.");
		// Synonym: "shut"
	}
	public void drink(){
		Io.out("You'd probably need a juicer to drink that.");
		// Synonym: "quaff" "imbibe"
	}
	public void eat(){
		Io.out("Didn't anyone tell you not to eat strange objects?");
	}
	public void hit(){
		Io.out("Thud!");
		// Synonym: strike, punch, kick(?)
	}
	public void read(){
		Io.out("There's nothing written on the "+name);
	}
	public void go(){
		Io.out("You walk a bit closer to the "+name);
	}
	public void enter(){
		Io.out("You can't fit inside the "+name);
	}
	public void lock(){
		Io.out("You don't see a lock on that.");
	}
	public void unlock(){
		Io.out("You don't see a lock on that.");
	}
	
//TWO OBJECT VERBS
	
	public void look(Thing o){
		Io.out("Try just looking at it instead.");
		// Synonym: "examine", "x"
	}
	
	public void get(Thing o){
		Io.out("This isn't something you can pick up and carry.");
		// Synonym: "take", "t"
	}
	public void open(Thing o){
		Io.out("You'd need to break it open first.");
		// Synonym: "shut"
	}
	public void close(Thing o){
		Io.out("You won't be able to close that.");
		// Synonym: "shut"
	}
	public void drink(Thing o){
		Io.out("You'd probably need a juicer to drink that.");
		// Synonym: "quaff" "imbibe"
	}
	public void eat(Thing o){
		Io.out("Didn't anyone tell you not to eat strange objects?");
	}
	public void hit(Thing o){
		Io.out("Thud!");
		// Synonym: strike, punch, kick(?)
	}
	public void read(Thing o){
		Io.out("There's nothing written on the "+name);
	}
	public void go(Thing o){
		Io.out("You walk a bit closer to the "+name);
	}
	public void enter(Thing o){
		Io.out("You can't fit inside the "+name);
	}
	public void lock(Thing o){
		Io.out("You don't see a lock on that.");
	}
	public void unlock(Thing o){
		Io.out("You don't see a lock on that.");
	}
	

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	// Checks to see if a given name matches this thing's.
	// We use it for iterating through thinglists.
	public boolean match(String str){
		return name.equals(str);
	}
	public String toString(){return name;}
}
