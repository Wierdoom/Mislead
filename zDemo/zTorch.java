
public class zTorch extends Carryable {

	private boolean lit;
	private String litdesc;
	
	public zTorch() {
		super("torch", "A length of wood coated in a strange bluish tar that smells of mustard, like that which fills the firepit.", "A torch is here.");
		lit = false;
		litdesc = "The bluish tar on the end of this torch burns with an unabating, smokeless flame.";
	}

	// If the torch is lit, describe it as so in its description
	public void look(){
		if(lit){Io.out(desc+litdesc);}
		else{Io.out(desc);}
	}
	
	//Can't drop the torch when it's lit
	public void drop(){
		if(lit){Io.out("You've gotten attached to your light source, honestly.");}
		else{super.drop();}
	}
	//Using the torch on the firepit lights the torch
	
	public void use(Thing o){
		if (o instanceof zFirepit){
		light();
		}
		else{
			Io.out("You rub a bit of the tar on the "+o.getName()+", to no effect.");
		}
	}
	
	public void eat(){
		if(lit){Io.out("Fire-eaters do their tricks with low-temperature flames. This isn't one of those.");}
		else{Io.out("You try a taste of the tar, and -- nope, not mustard.");}
	}
	
	public void light(){
		if(!lit){
		Io.out("The tar catches flame quickly.");
		lit = true;}
	}
	
	public void extinguish(){
		if(lit){
		Io.out("The water puts out the flame with a hiss of steam - still no smoke.");
		lit = false;}
	}
	
	public boolean isLit() {
		return lit;
	}

	public void setLit(boolean lit) {
		this.lit = lit;
	}

	
}
