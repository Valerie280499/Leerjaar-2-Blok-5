package com.company;
import javax.swing.*;
import java.awt.*;

public class MySecondGUI {

    public static void main (String[] args){
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(300,400));
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Dit is mijn Label");
        frame.add(label);

        JTextField veld = new JTextField("Dit is mijn veld");
        frame.add(veld);

        frame.setVisible(true);




    }
}
