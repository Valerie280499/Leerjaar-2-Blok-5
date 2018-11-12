package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFirstGUI extends JFrame implements ActionListener {
    JTextField text;
    JButton button;
    JPanel panel;

    public static void main(String[] args) {
        MyFirstGUI frame = new MyFirstGUI();
        frame.setSize(500, 500);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        text = new JTextField("Type een cijfer");
        window.add(text);
        //text.setBackground(Color.red);
        button = new JButton ("Klik hier");
        window.add(button);
        button.addActionListener(this);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(400,400));
        window.add(panel);
        panel.setBackground(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setBackground(Color.red);
        Graphics paper = panel.getGraphics();
        String s = text.getText();
        int x = Integer.parseInt(s);
        paper.drawLine(100+x, 100, 200+x, 200);
    }
}