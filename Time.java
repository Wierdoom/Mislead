//Time is a variable that is incremented using the Increment method whenever a "successful" action occurs.



public class Time {
private int time;

  public Time(){
    time=0;
  }
  public void Increment(){
    time++;}
public int getTime() {
	return time;
}
  
}

// Implement + add a linked list for timers
// Each node contains a thing (that has a thing.tick() ) and the time it happens at
// 1. Check the top of the list for whether that thing happens on the current time
// 2. If you pop something off, check it again (simultaneous events might occur)
// 3. Oh, also, have the f'n for adding a timer to the list hunt down and put it in the proper
// place. (no way to do this but iterating through)