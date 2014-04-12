//buffer room for tower
public class yTowerRoom extends WaterRoom {
   public yTowerRoom(zWater water, Boolean exit) {
      super("Tower Room","A circular room with a stairway along the wall that leads upwards. It leads further up.","One of the rooms in the tower; there's a staircase leading up.",""," Water laps at the lower stairs."," The rising water has flooded the room.",water);
      if(exit){
      setLongDescription(getLongDescription()+" An archway leads to the west.");
      setShortDescription(getShortDescription()+" An archway leads to the west.");
      }
   }
}
   
