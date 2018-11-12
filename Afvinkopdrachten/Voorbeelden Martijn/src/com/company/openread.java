package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class openread extends JFrame
        implements ActionListener {

    private JButton openButton, saveButton;
    private JFileChooser fileChooser;
    private JTextField nameField;
    private JTextArea textArea;
    private BufferedReader inFile;

    public static void main(String[] args) {
        try {
            //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");

            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
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


        openread frame = new openread();
        frame.setSize(400, 350);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        openButton = new JButton("open");
        window.add(openButton);
        openButton.addActionListener(this);

        saveButton = new JButton("save");
        window.add(saveButton);
        saveButton.addActionListener(this);

        nameField = new JTextField(25);
        window.add(nameField);

        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(200,200));
        window.add(textArea);
    }

    public void readFile() {


        try {
            inFile = new BufferedReader(new FileReader(nameField.getText()));
            textArea.setText("");
            String line;
            while ((line = inFile.readLine()) != null) {
                textArea.append(line + "\n");
            }
            inFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(openread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(openread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void actionPerformed(ActionEvent event) {
        File selectedFile;
        int reply;
        if (event.getSource() == saveButton) {
            fileChooser = new JFileChooser();
            reply = fileChooser.showSaveDialog(this);
            if (reply == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                nameField.setText(selectedFile.getName());
            }
        }
        if (event.getSource() == openButton) {
            fileChooser = new JFileChooser();
            reply = fileChooser.showOpenDialog(this);
            if (reply == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                nameField.setText(selectedFile.getName());
                readFile();
            }
        }
    }
}