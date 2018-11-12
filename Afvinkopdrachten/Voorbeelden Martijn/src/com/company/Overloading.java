package com.company;

public class Overloading{
    private static int increase(int x) {
        return x + 1;
    }

    private static int increase(int x, int getal) {
        return x + getal;
    }

    private static float increase(float x) {
        return x + 0.1f;
    }

    private static double increase(double x) {
        return x + 0.5;
    }

    public static void main(String[] args) {
        System.out.println(increase(7));
        System.out.println(increase(7.0f));
        System.out.println(increase(7.0));
        System.out.println(increase(7, 9));
    }
}