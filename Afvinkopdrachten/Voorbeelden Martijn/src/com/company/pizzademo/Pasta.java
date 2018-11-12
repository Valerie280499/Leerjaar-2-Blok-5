package pizzademo;

public class Pasta extends Product {

    @Override
    public void setPrijs(double prijs) {
        if (prijs < 0) {
            System.out.println("Prijs moet boven de 0 liggen!");
        } else if (prijs > 50) {
            System.out.println("Prijs is te hoog voor pasta!");
        } else {
            this.prijs = prijs;
        }
    }

}
