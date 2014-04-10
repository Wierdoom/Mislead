//The main location for editing the looks of the GUI
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame implements ActionListener {
   static private Player player;
   static private Parser parser;
   static private Time time;
   private Room room;
   private boolean u,d,n,s,w,e;
   private JPanel panel;
   private JTextField textField;
   private JTextArea textArea;
   private JLabel label;
   private JTextPane textPane;
   private JScrollPane scrollPane;


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
      textPane.setEditable(true);
      panel.add(textPane, BorderLayout.LINE_END);

      //set the games fonts and colors
		Font font = new Font("Courier New", 0, 14);
      label.setFont(new Font("Courier New", Font.BOLD, 16));
      textField.setFont(font);
      textArea.setFont(font);
      textPane.setFont(font);

      add(panel);


      setSize(600, 400);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);

      //initialize sub-bits
      initialize();

   }

   public void actionPerformed(ActionEvent e){
      String text = textField.getText();
      text = text.replaceAll("[^a-zA-Z /]", "").toLowerCase();
      if(text.equals("")){}
      else if(text.charAt(0) == '/'){
		slash(text);
      }
      else{
      	textArea.append(text + "\n");
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

	//takes commands from the user
	public void slash(String cmd){
	}

	//updates the directions using the current room housing the player
	public void updateDirections(){
		room = player.getLocation();
		if (room!=null){
		if(room.getNorth() != null){n = true;}
		else{n = false;}
		if(room.getSouth() != null){s = true;}
		else{s = false;}
		if(room.getWest() != null){w = true;}
		else{w = false;}
		if(room.getEast() != null){e = true;}
		else{e = false;}
		if(room.getUp() != null){u = true;}
		else{u = false;}
		if(room.getDown() != null){d = true;}
		else{d = false;}

		textPane.setText(direct());
		}
	}

	//returns the availible directions in a string
		public String direct(){

			String dir = "\n       \n";

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
