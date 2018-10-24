package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    JTextField inputField;
    JLabel inputLabel;
    JButton button1;

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setSize(300, 200);
        frame.setTitle("afvink7");
        frame.createGUI();
        frame.show();

    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        inputLabel = new JLabel("InputField: ");
        window.add(inputLabel);

        inputField = new JTextField(" ");
        window.add(inputField);

        button1 = new JButton("Klik hier!");
        window.add(button1);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = this.inputField.getText();

        try{
            if(e.getSource() == button1){

            }
        } catch (){

        }

    }
}
