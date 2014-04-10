
public class SwimExit extends Exit {

		public SwimExit(WaterRoom side1, WaterRoom side2, String str) {
		super(side1, side2, "du");
		// TODO Auto-generated constructor stub
	}
		
		public void checkOpen(){
			if(!((WaterRoom) getSide2()).isFlooded()){
				close("You can see more that way, but there's no way to climb there.");
			}
			else{
				open();
			}
		}
		public void travel(){
			checkOpen();
			super.travel();
		}

}
