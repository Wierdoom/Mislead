//The main location for editing the looks of the GUI
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame implements ActionListener {
   static private Player player;
   static private Parser parser;
   static private Time time;
   private JPanel panel;
   private JTextField textField;
   private JTextArea textArea;
   private JLabel label;
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
      
      //set the games fonts and colors
      label.setFont(new Font("monospaced", Font.BOLD, 16));
      textField.setFont(new Font("monospaced", 0, 16));
      textArea.setFont(new Font("monospaced", 0, 16));
      
      add(panel);
      
      
      setSize(600, 400);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
         
   }  
   
   public void actionPerformed(ActionEvent e){
      String text = textField.getText();
      textArea.append(text + "\n");
      textField.setText("");
      parser.parse(text);
   }  
   
   public void print(String str){
      textArea.append(str);
      textArea.setCaretPosition(textArea.getDocument().getLength());
   }
   
   public void println(String str){
      textArea.append(str + "\n"); 
      textArea.setCaretPosition(textArea.getDocument().getLength());
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
}       
