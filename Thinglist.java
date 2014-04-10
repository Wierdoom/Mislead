import java.util.ArrayList;

public class Thinglist {
	// A thinglist is a list of things - the objects in an area, the objects in the inventory,
	// The list of directions, and so on. We use thinglist.find to match a word to an object
	// By iterating through relevant thinglists.

	ArrayList<Thing> contents = new ArrayList<Thing>();
	
	// Returns first object in thinglist with name equal to str. If it comes across an object
	// that isn't visible, it stops -and fails-. If item isn't found, also fails.
	public Thing find(String str){
		Thing result = null;
		boolean looking = true;
		for (int i=0;i<contents.size()&&looking; i++){
			if (contents.get(i)!=null){
				if (contents.get(i).match(str)){
					looking = false;
					if (contents.get(i).isVisible()){result = contents.get(i);}
			}
			}
		}
		return result;
	}

	public boolean has(String name){
		boolean found = false, looking = true;
		for (int i=0;i<contents.size()&&looking; i++){
			if (contents.get(i)!=null){
				if (contents.get(i).match(name)){
					looking = false;
					if (contents.get(i).isVisible()){found = true;}
					}
				}
			}
		return found;
	}
	
	// True if thinglist has thing, and thing-to-find isn't null
	public boolean has(Thing th){
		return contents.contains(th)&&(th!=null);
	}
	
	public void add(Thing th){
		contents.add(th);
	}
	public void remove(Thing th){
		contents.remove(th);
	}
   
   public void printObjects() {
      for (int i = 0; i < contents.size(); i++) {
         Io.out(contents.get(i).getName());
         if (contents.get(i).getPicked() == true) {
            Io.out(contents.get(i).getDescPicked());
         }
         else {
            Io.out(contents.get(i).getDesc());
         }
      }
   }
}
