// TODO: water level handling

public class yBasinEntry extends WaterRoom {
   public yBasinEntry(zWater water) {
      super("Basin", "long desc", "short desc", "dry", "wet", "flood", water);
      zPillar pillar = new zPillar(this);
      zPart octagon = new zPart();
      octagon.setVisible(false);
   }
   
   public zPillar getPillar() {
      return pillar;
   }
}