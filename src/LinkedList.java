public class LinkedList {
	//Attributes
	Node front;
	int count;
	//Constructor
	public LinkedList(){
		front = null;
		count = 0;
	}
	//Add a node with String d to the front of the list
	public void addtoFront(int t, Thing th){
		Node n=new Node(t, th, front);
		front=n;
		count++;
	}
	//get size of the list
	public int size(){
		return count;
	}
	//Check if the list is empty
	public boolean isEmpty(){
		return (front==null);
	}
	//Clear the list
	public void clear(){
		front=null;
		count=0;
	}
	//Get the content of the first node (front node)
	public int getFrontData(){
		return front.getTime();
	}
	//Get the reference to the first (front) node
	public Node getFrontNode(){
		return front;
	}
	//enumerate - scan the list and print the contents
	public void enumerate(){//Beware of NullPointer Exceptions
		Node curr=front;
		if (!isEmpty()){
			while (curr!=null){
				System.out.print(curr);
				curr=curr.getNext();
			}
		}
		else {
			System.out.println("List is empty.");
		}
	}
	//Remove the first node (if the list is not 
	//empty = make first node point to next in the list_
	public void removeFront(){
		if (!isEmpty()){
			front=front.getNext();
			count--;
		}
	}
	//Add a node with String d to the end of the list
	public void addtoEnd(int t, Thing th){
		Node n=new Node(t, th, null);
		if (isEmpty()){
			front=n;
			count++;
		}
		else{
			Node curr=front;
			while (curr.getNext()!=null){
				curr=curr.getNext();
			}
			curr.setNext(n);
			count++;
		}
	}
	//Remove the last node
	public void removeLast(){
		if (isEmpty()){
			System.out.println("Caanot remove - empty list");
		}
		else if (front.getNext()==null){ //Only 1 node
			front=null;
		}
		else {
			Node curr=front;
			while (curr.getNext().getNext()!=null){
				curr=curr.getNext();
			}
			curr.setNext(null);
			count--;
		}
	}
	//search for given string and return the index
	//of the node (1st occurrence) or -1 if not found
	public int contains(int t){
		Node curr=front;
		boolean isFound=false;
		int index=-1;
		while (curr!=null && isFound==false){
			index++;
			if (curr.getTime()==(t)){
				isFound=true;
			}
			curr=curr.getNext();
		}
		return index;
	}
	//Add a node at the given index
	public void add(int index, int t, Thing th){
		if (index==0){
			addtoFront(t, th);
		}
		else if (index<0||index>=size()){
			System.out.println("Out of bounds");
		}
		else if (index==size()-1){
			addtoEnd(t, th);
		}
		else {
			Node curr=front;
			for (int i=0; i<index-1; i++){
				curr.getNext();
			}
			Node n=new Node (t, th, curr.getNext());
			curr.setNext(n);
		}
		count++;
	}
	//Remove a node at a given index
	public void remove(int index){
		if (index<0||index>=size()){
			System.out.println("Out of bounds");
		}
		else if(index==0){
			removeFront();
		}
		else if(index==size()-1){
			removeLast();
		}
		else {
			Node curr=front;
			for (int i=0; i<index-1; i++){
				curr=curr.getNext();
				curr.setNext(curr.getNext().getNext());
				count--;
			}
		}
	}
	//return the reference for the Node at a given index
	public Node getNode (int index){
		Node curr=front;
		if (index<size()&&index>=0){
			for (int i=0; i<index; i++){
				curr=curr.getNext();
			}
		}
		else {
			curr=null;
		}
		return curr;
	}
	//sets the value of the node at the given index to t
	public void set(int index, int t, Thing th){
		Node curr=front;
		if (index<size()&&index>=0){
			for (int i=0; i<index; i++){
				curr=curr.getNext();
			}
			curr.setTime(t);
			curr.setThing(th);
		}
		else {
			System.out.println("Index error or out of bounds");
		}
	}
	//Searches through the list for specified thing object
	public int searchFor(Thing th) {
      		Node curr = front;

      		int index = 0;
      		if (curr != null){
      		if (th.equals(front.thing)) {
         		return 0;
      		} else {
         		while (!curr.thing.equals(th) && !curr.thing.equals(null)) {
            		index++;
            		curr= curr.next;
         		}
      		}
         		if (curr.equals(null)) {
         			index = -1;
         		}
      		}
      		return index;
   	}
      
		public void addPreservingOrder(int value, Thing timer){
			Node newNode = new Node(value,timer);
			Node curr1, curr2;
			curr1 = front;
			
			//If the list is empty, we simply add the new node.
			if(front == null||front.getTime()>value){
				newNode.setNext(front);
				front = newNode;
				
			}
			//If the list is not empty, we move two pointers forward
			// until the second pointer is either to somewhere
			// non-existent, or higher-time valued than the node we are adding.
			// When this occurs, we splice the new node in between the two pointers.
			else{
				curr2 = curr1.getNext();
				while(curr2!=null&&curr2.getTime()<value){
					curr1=curr2;
					curr2=curr1.getNext();
				}
				newNode.setNext(curr2);
				curr1.setNext(newNode);
			
				
			}
		}
}
