package com.company.oefentoets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Oefentoets extends JFrame implements ActionListener {
    private JButton button1;
    private JButton button2;

    private JTextField textField1;
    private JTextField textField2;

    private TextArea textArea;

    private JFileChooser fileChooser;

    private String filePath1;
    private String filePath2;
    private String mistake = "";

    int count;

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;

    private static BufferedReader inFile1;
    private static BufferedReader inFile2;

    private JPanel jPanel = new JPanel();

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

        Oefentoets frame = new Oefentoets();
        frame.setSize(850, 500);
        frame.setTitle("oefentoets");
        frame.createGUI();
        frame.show();

    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() {
        });

        button1 = new JButton("open file1");
        window.add(button1);
        button1.addActionListener(this);

        button2 = new JButton("open file2");
        window.add(button2);
        button2.addActionListener(this);

        textField1 = new JTextField("filename 1");
        window.add(textField1);

        textField2 = new JTextField("filename 2");
        window.add(textField2);

        textArea = new TextArea("");
        window.add(textArea);

        jPanel.setPreferredSize(new Dimension(700, 50));
        jPanel.setBackground(Color.WHITE);
        window.add(jPanel);

        label1 = new JLabel("Identieke code");
        label1.setForeground (Color.MAGENTA);
        window.add(label1);

        label2 = new JLabel("Verschil in kolom 1");
        label2.setForeground(Color.blue);
        window.add(label2);

        label3 = new JLabel("verschil in kolom 2");
        label3.setForeground(Color.yellow);
        window.add(label3);

        label4 = new JLabel("verschil in kolom 3");
        label4.setForeground(Color.green);
        window.add(label4);

        label5 = new JLabel("verschil in kolom 4");
        label5.setForeground(Color.red);
        window.add(label5);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File selectedFile;
        int reply1;
        int reply2;

        if (e.getSource() == button1) {

            fileChooser = new JFileChooser();
            reply1 = fileChooser.showOpenDialog(this);
            if (reply1 == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                filePath1 = selectedFile.getAbsolutePath();
                textField1.setText(selectedFile.getName());
            }
        } else if (e.getSource() == button2) {
            fileChooser = new JFileChooser();
            reply2 = fileChooser.showOpenDialog(this);
            if (reply2 == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                filePath2 = selectedFile.getAbsolutePath();
                textField2.setText(selectedFile.getName());
            }

            try {
                openfile(filePath1, filePath2);
                drawsomething();

            } catch (NotIPI notIPI) {
                notIPI.printStackTrace();
                JOptionPane.showMessageDialog(null, "ongeldig bestand");
            }
        }
    }

    public String openfile(String filePath1, String filePath2) throws NotIPI {
        String line1, line2;
        String[] kolom1;
        String[] kolom2;
        String Info = "";
        count = 0;

        try {

            inFile1 = new BufferedReader(new FileReader(filePath1));
            inFile2 = new BufferedReader(new FileReader(filePath2));

            while ((line1 = inFile1.readLine()) != null) {
                line2 = inFile2.readLine();
                count++;

                if (!line1.equals(line2)) {
                    kolom1 = line1.split("\t");
                    kolom2 = line2.split("\t");

                    for (int i = 0; i < 4; i++) {
                        if (!kolom1[i].equals(kolom2[i])) {

                            Info += "\n Fout in regel: ";
                            Info += Integer.toString(count);
                            Info += "\n Fout in kolom: ";
                            Info += Integer.toString(i+1);
                            Info += "\n";
                            textArea.append(Info);
                            textArea.append("file 1:  " + line1 + "\n");
                            textArea.append("file 2:  " + line2 + "\n\n");
                            Info = "";

                            mistake += Integer.toString(i +1);
                            //System.out.println("fout "+mistake);
                        } else {
                            mistake += Integer.toString(0);
                            //System.out.println("niet fout "+ mistake);
                        }
                    }
                }
            } if (mistake ==""){
                textArea.append("Je bestanden zijn 100% identiek!");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UitwerkingHBI5aT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UitwerkingHBI5aT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArrayIndexOutOfBoundsException a) {
            throw new NotIPI();
        }
        return Info;
    }

    private void drawsomething(){

        Graphics paper = jPanel.getGraphics();
        int lengte;
        int start =0;
        int einde=0;
        lengte = mistake.length();
        int plus = 700/ lengte;

        for (int j = 0; j < mistake.length(); j++) {
            System.out.println(mistake.charAt(j));
            if (mistake.charAt(j) == '0') {
                paper.setColor(Color.MAGENTA);
                paper.fillRect(start,0,einde+plus,50);
                start = start + plus;
            }
            if (mistake.charAt(j) == '1') {
                paper.setColor(Color.blue);
                paper.fillRect(start,0,einde+plus,50);
                start = start + plus;
            }
            if (mistake.charAt(j) == '2') {
                paper.setColor(Color.yellow);
                paper.fillRect(start,0,einde+plus,50);
                start = start + plus;
            }
            if (mistake.charAt(j) == '3') {
                paper.setColor(Color.green);
                paper.fillRect(start,0,einde+plus,50);
                start = start + plus;
            }
            if (mistake.charAt(j) == '4') {
                paper.setColor(Color.RED);
                paper.fillRect(start,0,einde+plus,50);
                start = start + plus;
        }
        System.out.println(mistake);

    }
    }
}