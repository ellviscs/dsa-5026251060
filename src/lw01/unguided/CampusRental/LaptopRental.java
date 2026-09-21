package lw01.unguided.CampusRental;

public class LaptopRental extends Rental{
    public LaptopRental(String id, int days, int units) {
        super(id, days, units);
    }

    @Override 
    public int calculateCharge(){
        return 40000 * getDays() + 10000;
    }

    @Override 
    public String label(){
        return "Laptop";
    }
}
