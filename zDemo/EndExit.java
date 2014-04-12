public class EndExit extends Exit {
   
   boolean confirm;
   
   public EndExit(Room side1, Room side2) {
      super(side1, side2);
      confirm = false;
   }
   
   public void travel() {
      if (isOpen() && confirm) {
         if (Game.player().getInventory().has("camera")) {
            if (Game.player().getInventory().has("cylinder") && ((zCamera) Game.player().getInventory().find("camera")).isInterestingPhoto()) {
               Io.out("Camera full of photos and with a strange sapphire cylinder tucked away, you forge your way back along the logging trail...");
               Io.out("Surrounded by pouring rain.");
               Io.out("Somebody's going to call this the find of the century.");
               Io.out("And whatever the mystery of this place is... it's going to be a mystery on protected land.");
               Game.end.gameOver(true);
            }
            else if (((zCamera) Game.player().getInventory().find("camera")).isInterestingPhoto()) {
               Io.out("Camera full of choice photos, you start your voyage back to the city. Once they're published, ZexCo will be falling over themselves to position themselves as proud to honor your nation's heritage.");
               Io.out("Or, well, however they decide to backtrack on it.");
               Game.end.gameOver(true);
            }
            else {
            	Io.out("You leave the tunnel behind, forging back towards the trail.");
                Game.end.gameOver(false);
            }
         }
         else if (Game.player().getInventory().has("cylinder")) {
            Io.out("With the sapphire cylinder clutched in your hand, you prepare to make the trek back to civilization.");
            Io.out("It's a pity you had to leave your camera behind, but your find will definitely wow a museum or two. Hell, the Americans might even get involved.");
            Game.end.gameOver(true);
         }
         else {
            Io.out("You leave the tunnel behind, forging back towards the trail.");
            Game.end.gameOver(false);
         }}
      else if (isOpen()) {
         Io.out("You hesitate. Slipping in here is a once in a lifetime chance. You might not be able to return - then again, you might have gotten all you can.");
         confirm = true;
      }
      else {
         Io.out("You can't go through here yet.");
      }
   }
}