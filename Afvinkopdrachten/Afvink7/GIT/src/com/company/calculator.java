package com.company;

/**
 * Naam: Valerie Verhalle
 * Toepassing/funcite:
 * Auteur:
 * Datum:
 * Versie:
 */

public class calculator {
    static final String[] ONE = {"A", "R", "N", "D", "C", "Q", "E", "G", "H", "I", "L", "K", "M", "F", "P", "S", "T",
            "W", "Y", "V"};

    /**
     *
     * @param seq; aminozuur sequetnie
     * @return oneCode; de eenletterige aminozuur code
     * @throws NotAnAA
     */
    public static String checkaa(String seq) throws NotAnAA {
        String oneCode = "";

        for (int j = 0; j < seq.length(); j++) {
            char c = seq.charAt(j);

            for (int i = 0; i < ONE.length; i++) {
                if (ONE[i].equalsIgnoreCase(String.valueOf(c))) {
                    oneCode += ONE[i];
                }
            }
        }

        if (oneCode.length()!= (seq.length())) {
            throw new NotAnAA("ongeldig aminozuur!");
        }

        return oneCode;
    }
}

class NotAnAA extends Exception {
    public NotAnAA() {
        super();
    }

    public NotAnAA(String err) {
        super(err);
    }
}
