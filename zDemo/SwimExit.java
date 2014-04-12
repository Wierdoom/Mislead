
public class SwimExit extends Exit {

		public SwimExit(WaterRoom side1, WaterRoom side2) {
		super(side1, side2, "ud");
		// TODO Auto-generated constructor stub
	}
		
		public boolean isOpen(){
			if(!((WaterRoom) getSide1()).isFlooded()){
				close("You can see more that way, but there's no way to climb there.");
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
