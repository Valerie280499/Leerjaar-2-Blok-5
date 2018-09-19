// afvink2 VVerhalle
package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class H2O extends JFrame implements ActionListener {
    JTextField xas;
    JTextField yas;
    JButton button;
    JButton removebutton;
    JPanel panel;

    public static void main(String[] args) {
        H2O frame = new H2O();
        frame.setSize(500, 500);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        xas = new JTextField("type je xas");
        //xas.setSize(15,15);
        window.add(xas);
        yas = new JTextField("type je yas");
        //xas.setSize(15,15);
        window.add(yas);

        button = new JButton ("Teken een watermolecuul");
        window.add(button);
        button.addActionListener(this);

        removebutton = new JButton("Clear panel");
        window.add(removebutton);
        removebutton.addActionListener(this);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(400,400));
        window.add(panel);
        panel.setBackground(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button = (JButton) e.getSource();

        if (button != removebutton){
            //coalesceEvents().getSource();
            Graphics paper = panel.getGraphics();
            String s1 = xas.getText();
            int x = Integer.parseInt(s1);

            String s2 = yas.getText();
            int y = Integer.parseInt(s2);

            paper.drawLine(146+x, 146+y, 211+x, 200+y);
            paper.drawLine(146+x, 300+y, 210+x, 249+y);
            paper.setColor(Color.red);
            paper.fillOval(200+x,200+y, 50, 50);
            paper.setColor(Color.blue);
            paper.fillOval(125+x,125+y,25,25);
            paper.setColor(Color.blue);
            paper.fillOval(120+x, 295+y, 25, 25);
        }

        else{
            panel.removeAll();
            panel.updateUI();
            }
    }
}
