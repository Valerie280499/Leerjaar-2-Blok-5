package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Afvinkopdracht_5 extends JFrame implements ActionListener {
    JTextField textfield1;
    JTextField textfield2;
    JButton button1;
    JButton button2;
    JPanel panel;

    public static void main(String[] args) {
        Afvinkopdracht_5 frame = new Afvinkopdracht_5();
        frame.setSize(100, 200);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        textfield1 = new JTextField("1 of 3 letterige A.A. code");
        window.add(textfield1);

        button1 = new JButton("Translate 1 to 3");
        window.add(button1);
        button1.addActionListener(this);

        button2 = new JButton("Translate 3 to 1");
        window.add(button2);
        button2.addActionListener(this);

        textfield2 = new JTextField(" ", 12);
        window.add(textfield2);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String input = textfield1.getText();

        try {
            if (event.getSource() == button1){
                textfield2.setText(Translator.one2three(input));
            }
            } catch (NotAnAA notAnAA) {
                notAnAA.printStackTrace();
                textfield2.setText("ongeldig aminozuur");
        }

        try {
            if (event.getSource() == button2){
                textfield2.setText(Translator.three2one(input));
            }
        } catch (NotAnAA notAnAA) {
            notAnAA.printStackTrace();
            textfield2.setText("ongedlig aminozuur");
        }
    }

}





