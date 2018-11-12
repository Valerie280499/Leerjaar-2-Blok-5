package com.company;

import java.nio.channels.NotYetBoundException;

public class exceptionhandeling {
    public static void main (String[] args){
        Boolean b = null;

        try {
            b = controleDNA("ATGACAGATAGAC");
        } catch (NumberInSeqExc numberInSeqExc) {
            numberInSeqExc.printStackTrace();
        }

        System.out.println(b);
    }

    public static Boolean controleDNA(String sequence) throws NumberInSeqExc {
        if(sequence.matches(".*\\d+.*")){
            System.out.println("nummer in string");
            throw new NumberInSeqExc();
        }
        if (sequence.matches("[ATGC]+")){
            return true;
        }
        return false;
    }
}

class NumberInSeqExc extends Exception{
    NumberInSeqExc(){
        super();
    }
    NumberInSeqExc(String message){
        super(message);
    }
}