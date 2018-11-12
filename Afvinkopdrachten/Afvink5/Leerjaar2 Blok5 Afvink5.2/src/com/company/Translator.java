package com.company;

public class Translator {

    static final String[] ONE   = {"A", "R", "N", "D", "C", "Q", "E", "G", "H", "I", "L", "K", "M", "F", "P", "S", "T", "W", "Y", "V"};
    static final String[] THREE = { "ALA", "ARG", "ASN", "ASP", "CYS", "GLN", "GLU", "GLY",
            "HIS", "ILE", "LEU", "LYS", "MET", "PHE", "PRO", "SER", "THR", "TRP", "TYR", "VAL"
    };

    public static String one2three(String symbol) throws NotAnAA {
        String threeCode = "";

        for (int j = 0; j < symbol.length(); j++){
            char c = symbol.charAt(j);
            System.out.println(c);

            for (int i = 0; i < ONE.length; i++){
                if (ONE[i].equalsIgnoreCase(String.valueOf(c))) {
                    threeCode += THREE[i] + '-';
                }
            }
        }

        if (threeCode.equals("")){
            throw new NotAnAA ("Dit is een niet bestaand aminozuur: "+ symbol);
        }

        return threeCode;
    }

    public static String three2one (String symbol) throws NotAnAA {
        String oneCode = "";
        String aa = "";

        for (int j = 0; j < symbol.length(); j++){
            char c = symbol.charAt(j);
            aa += c;

            System.out.println(c);

            for (int i = 0; i < THREE.length; i++){
                if (THREE[i].equalsIgnoreCase(aa)) {
                    oneCode += ONE[i] + '-';
                    aa = "";
                }
            }
        }

        if (oneCode.equals("")){
            throw new NotAnAA ("Dit is een niet bestaand aminozuur: "+ symbol);
        }

        return oneCode;
    }
    }

/**
 * Class met custom exception
 *  @Author Martijn van der Bruggen
 *  @Date   21-November-2008
 * Deze class staat in hetzelfde bestand als translator
 * Merk op dat deze class niet public is, hetgeen voorwaardelijk is om in een
 * bestand met een andere naam te staan.
 * Custom exceptions overerven altijd van Exception
 */

class NotAnAA extends Exception {
    /**
     * Overschrijven van de constructor van Exception
     */

    public NotAnAA() {
        /**
         * call van de constructor van de super class: Exception
         */
        super();
    }

    public NotAnAA(String err) {
        super(err);
    }
}