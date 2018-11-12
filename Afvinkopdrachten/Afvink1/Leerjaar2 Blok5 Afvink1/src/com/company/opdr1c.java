import javax.swing.*;
import java.awt.*;

public class opdr1c extends JFrame{
  private JTextField textField;
  public static void main(String[] args) {
    opdr1c frame = new opdr1c();
    frame.setSize(300,200); // Standaard = .setSize(0,0) 
    frame.createGUI();
    frame.setVisible(true); // Standaard = setVisible(false)
  }
  
  private void createGUI() {
    setDefaultCloseOperation(EXIT_ON_CLOSE); // Anders blijft het programma op de achtergrond lopen tot je ctrl-alt-delete typt
    Container window = this.getContentPane();
    window.setLayout(new FlowLayout());
    textField = new JTextField("Hello World!");
    window.add(textField);
  }
}