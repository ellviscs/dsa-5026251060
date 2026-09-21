package lw01.unguided.CampusRental;

public abstract class Rental implements Chargeable {
    private String id;
    private int days;
    private int units;

    protected Rental(String id, int days, int units) {
        if (days <= 0) throw new IllegalArgumentException("Days must greater than 0");
        this.id = id;
        this.days = days;
        this.units = units;
    }

    public int getUnits() {
        return units;
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    @Override 
    public abstract int calculateCharge();
    public int calculateCharge(int units){
        if (units <= 0) throw new IllegalArgumentException("Units must greater than 0");
        return units * calculateCharge();
    }

    public String label() {
        return "Rental";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge(units);
    }
}
