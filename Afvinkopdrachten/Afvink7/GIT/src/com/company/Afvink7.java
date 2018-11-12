package com.company;

/**
 * Naam: Afvinkopdracht 7
 * Toepassing/funcite: Het visualiseren van een aminozuur sequentie
 * Auteur: Valerie Verhalle
 * Datum: 31-10-2018
 * Versie: 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Afvink7 extends JFrame implements ActionListener {
    private JTextField textField1;

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;

    private JButton openButton;
    private JButton drawButton;

    private JTextArea textArea1;
    private JTextArea textArea2;

    private JFileChooser fileChooser;
    private BufferedReader inFile;
    private String filePath;

    private JPanel panel = new JPanel();

    /**
     *
     * @param args
     * funcite: setting van frame
     *
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }

        Afvink7 frame = new Afvink7();
        frame.setSize(450, 500);
        frame.setTitle("afvink7");
        frame.createGUI();
        frame.show();

    }

    /**
     * funcite; aanmaken van GUI en initialiseren van de objecten
     */
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() {});

        openButton = new JButton("Open here a oneCoded protein file");
        window.add(openButton);
        openButton.addActionListener(this);

        label1 = new JLabel("Bestandsnaam: ");
        window.add(label1);
        textField1 = new JTextField("");
        window.add(textField1);

        label2 = new JLabel("Input Seq: ");
        window.add(label2);
        textArea2 = new JTextArea("");
        window.add(textArea2);

        label3 = new JLabel("informatie: ");
        window.add(label3);
        textArea1 = new JTextArea("");
        window.add(textArea1);

        drawButton = new JButton("let's draw something");
        window.add(drawButton);
        drawButton.addActionListener(this);

        panel.setPreferredSize(new Dimension(400, 50));
        panel.setBackground(Color.WHITE);
        window.add(panel);
    }

    /**
     * funcite source van de button
     * achterhalen; of er wordt een file
     * geopend of er wordt een visualisatie gemaakt
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e){
        File selectedFile;
        int reply;

        if (e.getSource() == openButton) {
            fileChooser = new JFileChooser();
            reply = fileChooser.showOpenDialog(this);
            if (reply == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                filePath = selectedFile.getAbsolutePath();
                textField1.setText(selectedFile.getName());
                readFile();
            }
        }
        else if (e.getSource() == drawButton){
            String line = textArea2.getText();
            Graphics paper = panel.getGraphics();
            DrawSomething(line, paper);
        }
        

    }

    /**
     * funcite inlezen van het geselecteerde file.
     */
    private void readFile() {

        try {
            inFile = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = inFile.readLine()) != null) {
                this.textArea2.setText(calculator.checkaa(line));
                Hydrofobiciteit(line);
            }
            inFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotAnAA notAnAA){
            notAnAA.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ongeldig aminozuur aanwezig!.");
            this.textArea2.setText("ongeldig aminozuur aanwezig!");
        }
    }

    private void Hydrofobiciteit(String line){
        textArea1.append("Aantal Aminozuren: " + hydrofobiciteit.count(line) + "\n");
        textArea1.append("Percentage hydroob(ROOD): " + hydrofobiciteit.HYDROFOOB(line) + "\n");
        textArea1.append("Percentage hydrofiel(BLAUW) :" + hydrofobiciteit.HYDROFIEL(line) + "\n");
        textArea1.append("Percentage neutraal(GROEN): " + hydrofobiciteit.NEUTRAAL(line) + "\n");
    }

    private void DrawSomething(String line, Graphics paper) {
        DrawSomething.paper(line, paper);
    }

}