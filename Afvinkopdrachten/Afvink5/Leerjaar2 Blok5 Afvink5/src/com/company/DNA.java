package com.company;

public class DNA extends Sequentie{
    protected static int counterDNA = 0;
    public DNA(String s) {
        setSequentie(s);
    }

    @Override
    public void setSequentie(String ntseq) {
        if (!ntseq.matches("[ATGC]*")){
            System.out.println("Dit is geen DNA: ");
            getSequentie(ntseq);

        } else{
            this.ntseq= ntseq;
            counterDNA+=1;
        }

    }
}
