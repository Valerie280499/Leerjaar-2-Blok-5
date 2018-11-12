package pizzademo;

public abstract class Product {

    protected double prijs;
    private String naam;
    

    public double getPrijs() {
        return prijs;
    }

    public abstract void setPrijs(double prijs); 
    

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

}
