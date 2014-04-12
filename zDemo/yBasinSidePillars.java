
public class yBasinSidePillars extends yBasinSide {

	public yBasinSidePillars(zWater water, zRain rain) {
		super(water, rain, 2);
		setLongDescription(getLongDescription()+"The remains of black pillars, pitted, pumice-like, stand here - three of them.");
		setWet("Even the largest fragments of the pillars that once stood here float and shift easily on the standing water.");
		setDry("Fragments of the pillars litter the ground.");
		setFlood("Murky water rises all around.");
	}
	
	public void describe(boolean full){
		super.describe(full);
		if (getContents().has("pillar")){
			Io.out("Of four great pillars that stood here, one remains. Its squared black surface is aerated and pitted, its base almost worn away.");
		}
	}

}
