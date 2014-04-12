public class EndExit extends Exit {
   
   boolean confirm;
   
   public EndExit(Room side1, Room side2) {
      super(side1, side2);
      confirm = false;
   }
   
   public void Travel() {
      if (isOpen() && confirm) {
         if (Game.player().getInventory().has("camera")) {
            if (Game.player().getInventory().has("cylinder") && Game.player().getInventory().find("camera").getInterestingPhoto()) {
               Io.out("You not only managed to get some interesting photos, but also escaped with an ancient artifact. This should be more than enough evidence for your employers.");
               Game.end.gameOver(true);
            }
            else if (Game.player().getInventory().find("camera").getInterestingPhoto()) {
               Io.out("You didn't manage to take anything with you save some pretty interesting photos that should prove useful when you return to your employers.");
               Game.end.gameOver(true);
            }
         }
         else if (Game.player().getInventory().has("cylinder")) {
            Io.out("You managed to escape with an amazing artifact from the complex. Snapping some more interesting photos would have been nice, but this cylinder should definitely be enough.");
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