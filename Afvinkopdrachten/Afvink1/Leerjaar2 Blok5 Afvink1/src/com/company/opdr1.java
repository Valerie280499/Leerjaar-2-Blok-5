package com.company;
import javax.swing.*;
import java.awt.*;

// opdr 1b

//public class opdr1 {
//
//    public static void main(String[] args) {
//                System.out.println("Hello World");
//            }
//        }

//opdr1d

public class opdr1 extends JFrame{
    private JTextField textField;
    public static void main(String[] args) {
        opdr1 frame = new opdr1();
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