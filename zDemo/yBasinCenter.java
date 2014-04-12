public class yBasinCenter extends WaterRoom {

   zRain rain;
   zPillar pillar;
   
   public yBasinCenter(zWater water, zRain rain, zPillar pillar) {
      super("Basin Center", "The center of a vast stone basin that extends below and above you.", "The center of a vast stone basin that extends below and above you.", "", " Water spans between two ledges to the west and east", " Passages to the east and west are flooded - somewhere, far above, is the surface.", water);
      this.rain = rain;
      this.pillar = pillar;
   }
   
   public void enter() {
      rain.rainOnPlayer();
      super.enter();
      if (!pillar.isFallen()&&isWet()){
    	  water.swim();}
      }

	public void describe(boolean full){
		super.describe(full);
		if(pillar.isFallen()&&isWet()){
			Io.out("A floating pillar bridges between the two ledges.");}
		if(rain.isOpenToRain()){
			Io.out("The roof of the basin has opened, letting the pouring rain come down onto you.");
		}
	}
		
}