//Time is a variable that is incremented using the Increment method whenever a "successful" action occurs.



public class Time {
private int time;
private LinkedList list;

  public Time(){
    time=0;
    list = new LinkedList();
  }
  public void increment(){
    time++;
    while((list.getFrontNode() != null)&&list.getFrontNode().getTime()==time){
    	list.getFrontNode().getThing().tick();
    	list.removeFront();
    }
  	
  		
  }
  public int getTime() {
    return time;
  }
  public LinkedList getList(){
    return list; 
  }
  
  
}

// Implement + add a linked list for timers
// Each node contains a thing (that has a thing.tick() ) and the time it happens at
// 1. Check the top of the list for whether that thing happens on the current time
// 2. If you pop something off, check it again (simultaneous events might occur)
// 3. Oh, also, have the f'n for adding a timer to the list hunt down and put it in the proper
// place. (no way to do this but iterating through)
