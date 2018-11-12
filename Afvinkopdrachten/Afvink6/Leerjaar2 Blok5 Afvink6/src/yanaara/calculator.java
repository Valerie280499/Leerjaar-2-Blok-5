package yanaara;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.IntArrayData;

public class calculator {
    static final String[] ONE = {"A", "R", "N", "D", "C", "Q", "E", "G", "H", "I", "L", "K", "M", "F", "P", "S", "T",
            "W", "Y", "V"};

    static final String[] APOLAIR = {"A", "F", "I", "L", "M", "P", "W", "V"};
    static final String[] POLAIR = {"R", "N", "D", "C", "Q", "E", "G", "H", "K", "S", "T", "Y"};

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
            throw new NotAnAA("ongeldig aminozuur 2!");
        }
        count(oneCode);
        apolair(oneCode);
        polair(oneCode);

        return oneCode;
    }

    public static String count (String oneCode){
        String count = Integer.toString(oneCode.length());
        return count;
    }

    public static String apolair(String oneCode){
        String apolair_list = "";

        for (int j = 0; j < oneCode.length(); j++) {
            char c = oneCode.charAt(j);

            for (int i = 0; i < APOLAIR.length; i++) {
                if (APOLAIR[i].equalsIgnoreCase(String.valueOf(c))) {
                    apolair_list += APOLAIR[i];
                }
            }

        }
        String apolair_count = Integer.toString((apolair_list.length()*100)/oneCode.length());
        return apolair_count;
    }

    public static String polair(String oneCode){
        String polair_list = "";


        for (int j = 0; j < oneCode.length(); j++) {
            char c = oneCode.charAt(j);

            for (int i = 0; i < POLAIR.length; i++) {
                if (POLAIR[i].equalsIgnoreCase(String.valueOf(c))) {
                    polair_list += POLAIR[i];
                }
            }

        }
        String polair_count = Integer.toString((polair_list.length()*100)/oneCode.length());
        return polair_count;
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



