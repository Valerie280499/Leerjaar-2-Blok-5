package com.company;

/**
 * Naam:
 * Toepassing/funcite:
 * Auteur:
 * Datum:
 * Versie:
 */

import javax.swing.*;
import java.awt.*;

public class DrawSomething {
    static final String[] HYDROFOOB = {"A", "L", "F", "W", "V", "Y"};
    static final String[] HYDROFIEL = {"R", "D", "E", "K", "N", "Q", "S", "T"};
    static final String[] NEUTRAAL = {"M", "C", "I", "G", "P", "H"};

    public static Graphics paper (String line, Graphics paper){

        int lengte;
        int start = 0;
        int einde = 0;

        lengte = line.length();
        int plus = 400/lengte;

        for (int j = 0; j < line.length(); j++) {
            char c = line.charAt(j);

            for (String aHYDROFOOB : HYDROFOOB) {
                if (aHYDROFOOB.equalsIgnoreCase(String.valueOf(c))) {
                    paper.setColor(Color.RED);
                    paper.fillRect(start, 0, einde + plus, 50);
                    start = start + plus;
                }
            }
            for (String aHYDROFIEL : HYDROFIEL){
                if (aHYDROFIEL.equalsIgnoreCase(String.valueOf(c))) {
                    paper.setColor(Color.BLUE);
                    paper.fillRect(start, 0, einde + plus, 50);
                    start = start + plus;
                }
            }

            for (String aNEUTRAAL : NEUTRAAL){
                if (aNEUTRAAL.equalsIgnoreCase(String.valueOf(c))) {
                    paper.setColor(Color.GREEN);
                    paper.fillRect(start, 0, einde + plus, 50);
                    start = start + plus;
                }
            }
        }
    return paper;
    }
}
