
public class zFirepit extends Thing {

	public zFirepit() {
		super("firepit", "A tremendous smokeless flame burns in the firepit. The base of it is filled with a bluish tar with a mustardy scent. It was burning even before you got here - did someone light it?");
	}


	
	// If you hit the firepit with the torch, light the torch.
	public void hit(zTorch t){
		t.light();
	}
	
	}

