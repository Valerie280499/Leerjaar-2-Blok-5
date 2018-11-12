/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.oefentoets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martijn van der Bruggen (c) Hogeschool van Arnhem en Nijmegen
 */
public class UitwerkingHBI5aT {

    /**
     * @param args the command line arguments
     */
    private static BufferedReader inFile1;
    private static BufferedReader inFile2;

    public static String vergelijkBestanden(String f1, String f2) throws NotIPI {
        String regel1, regel2;
        String[] kolommen1;
        String[] kolommen2;
        String retInfo = "";
        try {
            inFile1 = new BufferedReader(new FileReader(f1));
            inFile2 = new BufferedReader(new FileReader(f2));
            while ((regel1 = inFile1.readLine()) != null) {
                regel2 = inFile2.readLine();
                if (!regel1.equals(regel2)) {
                    System.out.println("Regel 1" + regel1);
                    System.out.println("Regel 2" + regel2);
                    kolommen1 = regel1.split("\t");
                    kolommen2 = regel2.split("\t");

                    for (int i = 0; i < 4; i++) {
                        if (!kolommen1[i].equals(kolommen2[i])) {
                            retInfo += "Fout in kolom ";
                            retInfo += Integer.toString(i+1);
                        }

                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UitwerkingHBI5aT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UitwerkingHBI5aT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArrayIndexOutOfBoundsException a){
            throw new NotIPI();
        }
        System.out.println("uitwerking "+retInfo);
        return retInfo;
    }

    
}
