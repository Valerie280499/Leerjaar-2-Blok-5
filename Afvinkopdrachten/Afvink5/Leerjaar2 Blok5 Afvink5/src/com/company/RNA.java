package com.company;

public class RNA extends Sequentie {
    protected static int counterRNA;

    public RNA(String s) {
        setSequentie(s);
    }

    @Override
    public void setSequentie(String ntseq) {
        if (!ntseq.matches("[AUGC]*")) {
            System.out.println("Dit is geen RNA:");
            getSequentie(ntseq);

        } else {
            this.ntseq = ntseq;
            counterRNA += 1;
        }
    }
}
