/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzademo;

/**
 *
 * @author martijn
 */
public class Pizza extends Product {

    private double diameter;

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public void setPrijs(double prijs) {
        if (prijs < 0) {
            System.out.println("Prijs moet boven de 0 liggen!");
        } else if (prijs > 25) {
            System.out.println("Prijs is te hoog voor een pizza!");
        } else {
            this.prijs = prijs;
        }
    }

}
