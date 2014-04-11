public class zMachine extends Thing {
   
   boolean opendrain;
   
   public zMachine(Part p) {
      super("machine for the drainway", "blllaaaaaarg description");
      opendrain = false;
   }
   
   public void use(Part o) {
      if (o.getName().equals(p.getName())) {
         opendrain = true;
      }
   }
   
   public boolean getDrain() {
      return opendrain;
   }
}