/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yanaara;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class YANAARA extends JFrame implements ActionListener {
    JTextField input;
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;

    JLabel count;
    JLabel apolair;
    JLabel polair;

    JButton button1;

    public static void main(String[] args) {
        YANAARA frame = new YANAARA();
        frame.setSize(300, 200);
        frame.setTitle("YANAARA");
        frame.createGUI();
        frame.show();
    }

    public void createGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );

        input = new JTextField("Type hier je proteïne sequentie");
        window.add(input);

        button1 = new JButton("Klik hier");
        window.add(button1);
        button1.addActionListener( this);

        count = new JLabel("Aantal aminozuren: ");
        textField1 = new JTextField("Nog niks");
        window.add(count);
        window.add(textField1);

        apolair = new JLabel("percentage aplolaire aminozuren");
        textField2 = new JTextField("Nog niks");
        window.add(apolair);
        window.add(textField2);

        polair = new JLabel("percentage polaire aminozuren");
        textField3 = new JTextField("Nog niks");
        window.add(polair);
        window.add(textField3);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String input = this.input.getText();
        calculator code1 = new calculator();

        try {
            if (event.getSource() == button1) {
                this.input.setText(code1.checkaa(input));
                this.textField1.setText(code1.count(input));
                this.textField2.setText(code1.apolair(input));
                this.textField3.setText(code1.polair(input));
            }
        } catch (NotAnAA notAnAA) {
            notAnAA.printStackTrace();
            this.input.setText("ongeldig aminozuur 1!");
        }
    }
}
