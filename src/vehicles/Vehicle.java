package vehicles;


public abstract class Vehicle {
    private String plate;
    private final int tireQuantity;
    private char fuel;
    private int horsePower;
    private String type;

    public char getFuel() {
        return fuel;
    }

    public String getPlate() {
        return plate;
    }

    public Vehicle(String plate, char fuel, int tireQuantity, int horsePower, String type) {
        this.plate = plate;
        this.fuel = fuel;
        this.tireQuantity = tireQuantity;
        this.horsePower = horsePower;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Matrícula: " + plate + "\n" +
                "Quantitat de rodes: " + tireQuantity + "\n" +
                "Tipus de combustible: " + fuel + "\n" +
                "Potència: " + horsePower + "\n" +
                "Tipus: " + type + "\n" +
                "_____________________________";
    }
}