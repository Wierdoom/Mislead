//TODO

public class yControlTower extends WaterRoom {
   public yControlTower(zWater water, zRain rain) {
		super("Control Tower", "Control room (long)", "Control room (short)", "dry", "wet","flood",water);
		zFirebox firebox = new zFirebox();
      zControlLever lever = new zControlLever(rain);
      //zMachine machine = new zMachine(Part octagon);
      add(lever);
		add(firebox);
      //add(machine);
   }
}