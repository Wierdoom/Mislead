//TODO

public class yControlTower extends WaterRoom {
   public yControlTower(zWater water) {
		super("Control Tower", "Control room (long)", "Control room (short)", "dry", "wet","flood",water);
		zFirepit fireplace = new zFirepit();
      zControlLever lever = new zControlLever(machine);
      zMachine machine = new zMachine(Part octagon);
      add(lever);
		add(fireplace);
      add(machine);
   }
}