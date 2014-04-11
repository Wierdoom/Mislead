public class zControlLever extends Thing {
   
   private zMachine machine; // Here for if the machine does what I think it does
   private yBasinCenter rainwell;
   
   public zControlLever(zMachine mach, yBasinCenter center) {
      machine = mach;
      super("lever", "description", "short description");
   }
   
   public void use() {
         rainwell.openWell();
         rainwell.getOctagon().setVisible(true);
   }
}