public class yBasinCenter extends WaterRoom {

   boolean rainwell;
   zPart octagon;
   
   public yBasinCenter(zWater water) {
      super("Basin", "long desc", "short desc", "dry", "wet", "flood", water);
      rainwell = false
      octagon = new zPart();
      this.add(octagon);
      octagon.setVisible(false);
   }
   
   public enter() {
      if (rainwell) {
         rain(); //This needs to exist.
      }
      super();
   }
     
   public void setRainwell(boolean b) {
      rainwell = b;
   }
   
   public boolean getRainwell() {
      return rainwell;
   }
}