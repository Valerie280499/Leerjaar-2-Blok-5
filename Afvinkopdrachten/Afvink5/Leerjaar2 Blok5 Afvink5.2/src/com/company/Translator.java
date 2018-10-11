/** 
 *  Translator voor de opdracht One2Three
 *  Gebruik deze code ongewijzigd om een 
 *  vertaler te maken van de eenletterige code
 *  voor een aminozuur naar de drieletterige
 *  code van een aminozuur.
 *  @Author Martijn van der Bruggen
 *  @Date   21-November-2008
 * 
 * 7-december-2012 Toevoeging extra commentaar ten aanzien van opzet
 * 
 */

package com.company;

public class Translator {

    /** 
    *  Declaratie en initialisatie van arrays
    *  Met opzet niet de meest effectieve datastructuur gekozen
    *  maar wel een inzichtelijke datastructuur
    */
    
    static final String[] ONE   = {"A", "R", "N", "D", "C", "Q", "E", "G", "H", "I", "L", "K", "M", "F", "P", "S", "T", "W", "Y", "V"};
    static final String[] THREE = { "ALA", "ARG", "ASN", "ASP", "CYS", "GLN", "GLU", "GLY",
                                    "HIS", "ILE", "LEU", "LYS", "MET", "PHE", "PRO", "SER",
                                    "THR", "TRP", "TYR", "VAL"
                                   };

    public static String one2three(String symbol) throws NotAnAA {
        
        String threeCode = "";
        
        for (int i = 0; i < ONE.length; i++) {
            
            if (ONE[i].equals(symbol)) {
                
                threeCode = THREE[i];
                
            }
        }

        if (threeCode.equals("")) {
            
            throw new NotAnAA("Dit is een niet bestaand aminozuur: "+symbol);
        }

        return threeCode;
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
