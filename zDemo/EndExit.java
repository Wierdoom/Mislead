public class EndExit extends Exit {
   
   boolean confirm;
   Player player;
   
   public EndExit(Room side1, Room side2, Player p) {
      super(side1, side2);
      confirm = false;
      player = p;
   }
   
   public void Travel() {
      if (open && confirm) {
         if (player.getInventory().has("cylinder") && player.getInventory().find("camera").getInterestingPhoto()) {
            Io.out("You got out with a swaggin' artifact and a photograph of a damn neat thing. Swiggity swooty you got the booty!");
            end.gameOver(true);
         }
         else if (player.getInventory().has("cylinder")) {
            Io.out("You got out with a neat thing. Woo!");
            end.gameOver(true);
         }
         else {
            Io.out("You got out but didn't manage to find anything. Oh well, at least you're alive.");
            end.gameOver(false);
         }
      else if (open) {
         Io.out("Are you sure to want to leave this place? Type that again if you are.");
         confirm = true;
      }
      else {
         Io.out("You can't go through here yet.");
      }
   }
}