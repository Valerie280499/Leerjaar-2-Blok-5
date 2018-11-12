package com.company;

/**
 * Naam:
 * Toepassing/funcite:
 * Auteur:
 * Datum:
 * Versie:
 */

public class hydrofobiciteit {
    static final String[] HYDROFOOB = {"A", "L", "F", "W", "V", "Y"};
    static final String[] HYDROFIEL = {"R", "D", "E", "K", "N", "Q", "S", "T"};
    static final String[] NEUTRAAL = {"M", "C", "I", "G", "P", "H"};

    public static String count (String oneCode){
        String count = Integer.toString(oneCode.length());
        return count;
    }

    public static String HYDROFOOB(String oneCode){
        String hydrofoob_list = "";

        for (int j = 0; j < oneCode.length(); j++) {
            char c = oneCode.charAt(j);

            for (int i = 0; i < HYDROFOOB.length; i++) {
                if (HYDROFOOB[i].equalsIgnoreCase(String.valueOf(c))) {
                    hydrofoob_list += HYDROFOOB[i];
                }
            }

        }
        String hydrofoob_perc = Integer.toString((hydrofoob_list.length()*100)/oneCode.length());
        return hydrofoob_perc;
    }

    public static String HYDROFIEL(String oneCode){
        String hydrofiel_list = "";


        for (int j = 0; j < oneCode.length(); j++) {
            char c = oneCode.charAt(j);

            for (int i = 0; i < HYDROFIEL.length; i++) {
                if (HYDROFIEL[i].equalsIgnoreCase(String.valueOf(c))) {
                    hydrofiel_list += HYDROFIEL[i];
                }
            }

        }
        String hydrofiel_perc = Integer.toString((hydrofiel_list.length()*100)/oneCode.length());
        return hydrofiel_perc;
    }

    public static String NEUTRAAL(String oneCode){
        String neutraal_list = "";


        for (int j = 0; j < oneCode.length(); j++) {
            char c = oneCode.charAt(j);

            for (int i = 0; i < NEUTRAAL.length; i++) {
                if (NEUTRAAL[i].equalsIgnoreCase(String.valueOf(c))) {
                    neutraal_list += NEUTRAAL[i];
                }
            }

        }
        String neutraal_perc = Integer.toString((neutraal_list.length()*100)/oneCode.length());
        return neutraal_perc;
    }

}




