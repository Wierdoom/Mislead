
public class Node {
	//Attributes
	int time;
	Thing thing; 
	Node next;
	//Constructor
	public Node (int ti, Thing th, Node n){
		time=ti;
		thing=th;
		next=n;
	}
	//Set and get Methods
	public void setTime(int t){
		time=t;
	}
	public void setThing(Thing th){
		thing=th;
	}
	public void setNext(Node n){
		next=n;
	}
	public int getTime(){
		return time;
	}
	public Thing getThing(){
		return thing;
	}
	public Node getNext(){
		return next;
	}
	//toString Method
	public String toString(){
		return time+", "+thing+"->";
	}
}
