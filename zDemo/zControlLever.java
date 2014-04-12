//Lever that opens and closes the rainwell, manipulating the rain object.

public class zControlLever extends Thing {
   
   private zRain rain;
   private boolean position;
   private boolean active;
   
   public zControlLever(zRain rain) {
      super("lever", "The lever of some strange machine.", "The lever of some strange machine");
      active = false;
      position = false;
      this.rain = rain;
   }
   
   public void use() {
	   if(position){open();}
	   else{close();}
   }

   public void push(){open();}
   public void pull(){close();}
   
   public void open(){
	   if (active){
		   if(!position){
			   rain.setOpenToRain(true);
			   Io.out("Through the window, you can see the roof of the basin open.");
			   position = true;
		   }
		   else{
			   Io.out("The basin lid is already open.");
		   }
	   }
	   else{
		Io.out("The lever won't budge.");   
	   }
   }

public void close(){
	   if (active){
		   if(position){
			   rain.setOpenToRain(false);
			   Io.out("Through the window, you can see the roof of the basin close.");
			   position = false;
		   }
		   else{
			   Io.out("The basin lid is already closed.");
		   }
	   }
	   else{
		Io.out("The lever won't budge.");   
	   }
}

public boolean isActive() {
	return active;
}

public void setActive(boolean active) {
	this.active = active;
}
}