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
      textArea.setCaretPosition(textArea.getDocument().getLength());
      textField.setText("");
      textArea.setCaretPosition(textArea.getDocument().getLength());
   }  
   
   public String a(String str){
      String article = "a";
      if(str.substring(0,1).matches("[aeiouAEIOU]")){article = "an";}
      return article + " " + str;
   }   
         
   
   public static void main(String[] args){
      new Game();
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
