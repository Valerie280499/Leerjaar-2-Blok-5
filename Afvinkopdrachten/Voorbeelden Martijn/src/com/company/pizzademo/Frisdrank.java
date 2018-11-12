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
public class Frisdrank extends Product{
    
  @Override
  public void setPrijs(double prijs) {
        if (prijs < 0) {
            System.out.println("Prijs moet boven de 0 liggen!");
        } else if (prijs > 5) {
            System.out.println("Prijs is te hoog voor frisdrank");
        } else {
            this.prijs = prijs;
        }
    }

    
}
