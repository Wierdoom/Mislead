//An exit you can't enter unless side2 is at least partially full of water
public class PitExit extends Exit {

		public PitExit(WaterRoom side1, WaterRoom side2, String str) {
		super(side1, side2, str);
		// TODO Auto-generated constructor stub
	}
		
		public boolean isOpen(){
			if(((WaterRoom) getSide2()).isDry()){
				close("You'd fall right into the basin if you kept going that way!");
			}
			else{
				open();
			}
			return super.isOpen();
		}
		public void travel(){
			isOpen();
			super.travel();
		}

}
