package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.*;

// opdracht 2a

//public class opdr2 {
//    public static void opdr2(String[] args)
//    {
//        Random generate = new Random();
//        String[] name = {"Valerie", "Bram", "Sophie", "Anne", "Michelle", "Teun", "Rick", "Evander"};
//
//        System.out.println("Hello " + name[generate.nextInt(8)]);
//    }
//}

//opdracht 2b

public class opdr2 extends JFrame {
    private JTextField textField;
    public static void main(String[] args) {
        opdr2 frame = new opdr2();
        frame.setSize(300,200); // Standaard = .setSize(0,0)
        frame.createGUI();
        frame.setVisible(true); // Standaard = setVisible(false)
    }

    private void createGUI() {
        Random generate = new Random();
        String[] name = {"Valerie", "Bram", "Sophie", "Anne", "Michelle", "Teun", "Rick", "Evander"};


        setDefaultCloseOperation(EXIT_ON_CLOSE); // Anders blijft het programma op de achtergrond lopen tot je ctrl-alt-delete typt
        Container window = this.getContentPane();
        window.setLayout(new FlowLayout());

        textField = new JTextField("Hello " + name[generate.nextInt(8)]);
        window.add(textField);
    }
}