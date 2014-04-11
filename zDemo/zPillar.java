public class zPillar extends Thing {
   
	private boolean fallen;
	private yBasinCenter centerMed;
   
   public zPillar() {
      super("pillar", "desc");
      fallen = false;
   }
   
   public void pull() {
	     fall();
	   }
   public void push() {
	     fall();
	   }
   public void hit() {
     fall();
   }
   
   
   private void fall(){
	   if (centerMed.isFlooded()){
	   Io.out("After some effort, the pillar comes loose, floating to the surface.");
	   
	   }
	   else if (centerMed.isWet()){
		   Io.out("With some effort, the pillar cracks on its foundation, tumbling into the water of the basin. It floats!");
	   }
	   else {
		   Io.out("The pillar cracks on its foundation and tumbles into the basin.");
	   }
	   fallen = true;
	   this.setVisible(false);
   }

public boolean isFallen() {
	return fallen;
}


// Won't exist at construction, so make sure to give it
public void setCenterMed(yBasinCenter centerMed) {
	this.centerMed = centerMed;
}
}