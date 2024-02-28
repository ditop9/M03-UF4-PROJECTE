package vehicles;

public class Car extends Vehicle {
    private String type;
    public Car(String plate, char fuel, int horsePower, String type) {
        super(plate, fuel, 4, horsePower);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Cotxe: " + "\n" +
                "Tipus: " + type + "\n" +
                super.toString();
    }
}
