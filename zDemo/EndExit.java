public class EndExit extends Exit {
   
   boolean confirm;
   
   public EndExit(Room side1, Room side2) {
      super(side1, side2);
      confirm = false;
   }
   
   public void Travel() {
      if (isOpen() && confirm) {
         if (Game.player().getInventory().has("cylinder") && Game.player().getInventory().find("camera").getInterestingPhoto()) {
            Io.out("You got out with a swaggin' artifact and a photograph of a damn neat thing. Swiggity swooty you got the booty!");
            Game.end.gameOver(true);
         }
         else if (Game.player().getInventory().has("cylinder")) {
            Io.out("You got out with a neat thing. Woo!");
            Game.end.gameOver(true);
         }
         else {
            Io.out("You got out but didn't manage to find anything. Oh well, at least you're alive.");
            Game.end.gameOver(false);
         }}
      else if (isOpen()) {
         Io.out("Are you sure to want to leave this place? Type that again if you are.");
         confirm = true;
      }
      else {
         Io.out("You can't go through here yet.");
      }
   }
}