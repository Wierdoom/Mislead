public class yBasinCenter extends WaterRoom {

   zRain rain;
   zPillar pillar;
   
   public yBasinCenter(zWater water, zRain rain, zPillar pillar) {
      super("Basin Center", "long desc", "short desc", "dry", "wet", "flood", water);
      this.rain = rain;
      this.pillar = pillar;
   }
   
   public void enter() {
      rain.rainOnPlayer();
      super.enter();
      if (!pillar.isFallen()&&isWet()){
    	  water.swim();}
      }

	public void describe(Boolean full){
		super.describe(full);
		if(pillar.isFallen()&&isWet()){
			Io.out("...If it weren't for the pillar you're standing on, that is.");}
		if(rain.isOpenToRain()){
			Io.out("The roof of the basin has open, letting the pouring rain come down onto you.");
		}
	}
		
}