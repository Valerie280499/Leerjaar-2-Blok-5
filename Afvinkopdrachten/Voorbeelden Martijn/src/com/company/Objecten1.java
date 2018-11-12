package com.company;

public class Objecten1 {
    public static void main(String[] args) {

        Student stud1;         //declaratie
        stud1 = new Student("wouter"); //initialisatie - creatie van een object van het type student
        stud1.setLeeftijd(18);

        Student stud2 = new Student("Lex");
        stud2.setLeeftijd(18);

        Student stud3 = new Student("Piet",40);
        stud3.info();
    }
}