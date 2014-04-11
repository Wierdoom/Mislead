public class zPillar extends Thing {
   
   private yBasinEntry entry;
   
   public zPillar(yBasinEntry b) {
      super("pillar thang", "desc", false);
      basin = b;
   }
   
   public void hit() {
      Io.out("The pillar falls over.");
      basin.setWetDesc("You're standing on the floating pillar.");
      this.setVisible(false);
   }
   
}