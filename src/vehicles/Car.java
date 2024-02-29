package vehicles;

public class Car extends Vehicle {
    private int doorNumber;
    private int trunkCapacity;
    public Car(String plate, char fuel, int horsePower, String type, int doorNumber, int trunkCapacity) {
        super(plate, fuel, 4, horsePower, type);
        this.doorNumber = doorNumber;
        this.trunkCapacity = trunkCapacity;
    }

    @Override
    public String toString() {
        return "Cotxe: " + "\n" +
                super.toString();
    }
}
