package vehicles;


public abstract class Vehicle {
    private String plate;
    private final int tireQuantity;
    private char fuel;
    private int horsePower;

    public char getFuel() {
        return fuel;
    }

    public String getPlate() {
        return plate;
    }

    public Vehicle(String plate, char fuel, int tireQuantity, int horsePower) {
        this.plate = plate;
        this.fuel = fuel;
        this.tireQuantity = tireQuantity;
        this.horsePower = horsePower;
    }
}