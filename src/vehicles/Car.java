package vehicles;

public class Car extends Vehicle {
    private String type;
    public Car(String plate, char fuel, int horsePower) {
        super(plate, fuel, 4, horsePower);
    }

}
