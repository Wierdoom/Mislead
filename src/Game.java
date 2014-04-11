//The main location for editing the looks of the GUI
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame implements ActionListener {
   static private Player player;
   static private Parser parser;
   static private Time time;
   private boolean style = true;
   private int size;
   private Room room;
   private boolean u,d,n,s,w,e;
   private JPanel panel;
   private JTextField textField;
   private JTextArea textArea;
   private JLabel label;
   private JTextPane textPane;
   private JScrollPane scrollPane;
   
   // For gameover functionality.
   public static Game end;

   public Game(){
      panel = new JPanel();
      panel.setLayout(new BorderLayout());

      //Overhead Label placement/creating
      label = new JLabel("Mislead", SwingConstants.CENTER);
      panel.add(label, BorderLayout.PAGE_START);

      //Text entry field
      textField = new JTextField();
      textField.addActionListener(this);
      panel.add(textField, BorderLayout.PAGE_END);

      //Outputted text area
      textArea = new JTextArea();
      textArea.setEditable(false);
      textArea.setLineWrap(true);
      panel.add(textArea, BorderLayout.CENTER);

      //scrolling function
      scrollPane = new JScrollPane(textArea);
      scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      panel.add(scrollPane, BorderLayout.CENTER);

      //direction and objects
      textPane = new JTextPane();
      textPane.setEditable(false);
      panel.add(textPane, BorderLayout.LINE_END);

      //set the game's fonts
      label.setFont(new Font("monospaced", Font.BOLD, 17));
      textField.setFont(new Font("monospaced", 0, 16));
      textArea.setFont(new Font("monospaced", 0, 16));
      textPane.setFont(new Font("monospaced", 0, 14));
      setStyle();
      
      add(panel);
      setSize(600, 400);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);

      //Initialise sub-bits
      initialize();
      
      // For gameover functionality.
      end = this;
   }

   //what happens when the user pressed enter
   public void actionPerformed(ActionEvent e){
      String text = textField.getText();
      text = text.replaceAll("[^a-zA-Z /]", "");
      if(text.equals("")){}
      else if(text.charAt(0) == '/'){
         text = text.toLowerCase();
		   slash(text);
      }
      else{
      	textArea.append(text + "\n");
         text = text.toLowerCase();
      	parser.parse(text);
      }
      textField.setText("");
   }

   public void print(String str){
      textArea.append(str);
      textArea.setCaretPosition(textArea.getDocument().getLength());
 		updateDirections();

	}

   public void println(String str){
      textArea.append(str + "\n");
      textArea.setCaretPosition(textArea.getDocument().getLength());
      updateDirections();
	}

   //Activated the "game over" sequence. True is for victory, false is for failure
   public void gameOver(boolean status){
      textField.removeActionListener(this);
      textField.setEditable(false);
      textField.setFont(new Font("monospaced", Font.BOLD, size));
      if(status){
         textField.setForeground(Color.GREEN);
         textField.setText("YOU WON!");
      }
      else{
         textField.setForeground(Color.RED);
         textField.setText("-DARK SOULS-");
      }
   }

	//takes commands from the user
	public void slash(String cmd){
      cmd = cmd.substring(1);
      if (cmd.equals("quit") || cmd.equals("exit"))
         System.exit(1);
      else if(cmd.equals("small")){
         setSize(12);
      }   
      else if(cmd.equals("normal")){
         setSize(16);
      }   
      else if(cmd.equals("large")){
         setSize(20);
      }
      else if(cmd.equals("style")){
         setStyle();
      }   
	}
   
   //changes the style from black to white and vice versa
   public void setStyle(){
      if(style){
         label.setBackground(Color.WHITE);
         textField.setBackground(Color.WHITE);
         textArea.setBackground(Color.WHITE);
         textPane.setBackground(Color.WHITE);
         label.setForeground(Color.BLACK);
         textField.setForeground(Color.BLACK);
         textArea.setForeground(Color.BLACK);
         textPane.setForeground(Color.BLACK);
         label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
         textField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
         textArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
         textPane.setBorder(BorderFactory.createLineBorder(Color.GRAY));
         scrollPane.setBorder(BorderFactory.createLineBorder(Color.GRAY));
         label.setOpaque(false);
         textField.setOpaque(false);
         textArea.setOpaque(false);
         textPane.setOpaque(false);
         scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(15, 0));
         style = false;
      }
      else{
         label.setBackground(Color.BLACK);
         textField.setBackground(Color.BLACK);
         textArea.setBackground(Color.BLACK);
         textPane.setBackground(Color.BLACK);
         label.setForeground(Color.WHITE);
         textField.setForeground(Color.WHITE);
         textArea.setForeground(Color.WHITE);
         textPane.setForeground(Color.WHITE);
         label.setBorder(BorderFactory.createEmptyBorder());
         textField.setBorder(BorderFactory.createEmptyBorder());
         textArea.setBorder(BorderFactory.createEmptyBorder());
         textPane.setBorder(BorderFactory.createEmptyBorder());
         scrollPane.setBorder(BorderFactory.createEmptyBorder());
         label.setOpaque(true);
         textField.setOpaque(true);
         textArea.setOpaque(true);
         textPane.setOpaque(true);
         scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
         style = true;
      }
   }
   
   //sets the windows text size
   public void setSize(int s){
      label.setFont(new Font("monospaced", Font.BOLD, s+1));
      textField.setFont(new Font("monospaced", 0, s));
      textArea.setFont(new Font("monospaced", 0, s));
      textPane.setFont(new Font("monospaced", 0, s-2));
   }

	//updates the directions using the current room housing the player
	public void updateDirections(){
		room = player.getLocation();
		if (room!=null){
		if(room.getNorth() != null && room.getNorth().isOpen()){n = true;}
		else{n = false;}
		if(room.getSouth() != null && room.getSouth().isOpen()){s = true;}
		else{s = false;}
		if(room.getWest() != null && room.getWest().isOpen()){w = true;}
		else{w = false;}
		if(room.getEast() != null && room.getEast().isOpen()){e = true;}
		else{e = false;}
		if(room.getUp() != null && room.getUp().isOpen()){u = true;}
		else{u = false;}
		if(room.getDown() != null && room.getDown().isOpen()){d = true;}
		else{d = false;}
      label.setText(room.getName());

      
		textPane.setText(direct() + object());
		}
	}

	   //returns the available directions in a string
		public String direct(){

			String dir = "       \n";

			if(u){dir += " U ";}
			else {dir += "   ";}
			if(n){dir += "N\n";}
			else {dir += "\n";}

			if(w){dir += " W + ";}
			else {dir += "   + ";}
			if(e){dir += "E\n";}
			else {dir += "\n";}

			if(d){dir += " D ";}
			else {dir += "   ";}
			if(s){dir += "S\n";}
			else {dir += "\n";}

			return dir;
		}
      
      //returns a string of all object withing grasp(room and inventory)
      public String object(){ 
      String obj = "";
      room = player.getLocation();
      ArrayList<Thing> carry = room.getCarryables().getContents();
      ArrayList<Thing> content = room.getContents().getContents();
      Inventory inv = player.getInventory();
      
      for(int i = 0; i < carry.size(); i++)
         obj += carry.get(i).getName() + "\n";
      obj += "\n";
      for(int i = 0; i < content.size(); i++)   
         obj += content.get(i).getName() + "\n";
      obj += "\n" + inv.list();   
      return obj;
      }     


public static Player player() {
	return player;
}

public static void setPlayer(Player player) {
	Game.player = player;
}

public static Parser getParser() {
	return parser;
}

public static void setParser(Parser parser) {
	Game.parser = parser;
}

public static Time getTime() {
	return time;
}

public static void setTime(Time time) {
	Game.time = time;
}
public static void initialize(){
	time = new Time();
	parser = new Parser();
	player = new Player();
}
}
