package com.company;

public class Main {

    public static void main(String[] args) {
        DNA dna1= new DNA("AUG");
        DNA dna2= new DNA("ATC");
        DNA dna3= new DNA("AGG");
        DNA dna4= new DNA("GAC");
        
        RNA rna1= new RNA("AUG");
        RNA rna2= new RNA("ATG");
        RNA rna3= new RNA("AGU");

        System.out.println("Aantal DNA sequenties: " + DNA.counterDNA);
        System.out.println("Aantal RNA sequenties: " + RNA.counterRNA);
    }

}
