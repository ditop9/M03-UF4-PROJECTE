package location;

import interfaces.DataIntroduction;
import ui.ConcessionaireMenu;
import vehicles.Car;
import vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Concessionaire extends Location implements ConcessionaireMenu {
    private final List<Vehicle> availableVehicles = new ArrayList<>();
    private String mainBrand;
    private boolean sellSecondHandVehicle;
    public Concessionaire(String cityLocation, String countryLocation, int workersAmount, String mainBrand, boolean sellSecondHandVehicle) {
        super(cityLocation, countryLocation, workersAmount);
        this.mainBrand = mainBrand;
        this.sellSecondHandVehicle = sellSecondHandVehicle;
    }

    @Override
    public void addNewVehicle(Vehicle v) {
        availableVehicles.add(v);
    }

    public void introduceCar(Concessionaire c) {
        Scanner sc = new Scanner(System.in);
        String plate = DataIntroduction.introducePlate();
        if (plate != null) {
            char fuel = DataIntroduction.introduceFuelType();
            if (fuel != '0') {
                System.out.println("INTRODUEIX LA POTÈNCIA");
                int horsePower = DataIntroduction.introduceInteger();
                if (horsePower != -1) {
                    System.out.println("INTRODUEIX EL TIPUS DE COTXE \n" +
                            "EXEMPLE: SEDAN, ESPORTIU...");
                    String type = sc.nextLine();
                    Car car = new Car(plate, fuel, horsePower, type);
                    addNewVehicle(car);
                } else {
                    System.out.println("ERROR: NO ÉS UN VALOR VÀLID");
                    ConcessionaireMenu.runMenu(c);
                }
            } else {
                System.out.println("ERROR: NO ÉS UN TIPUS DE COMBUSTIBLE VÀLID");
                ConcessionaireMenu.runMenu(c);
            }
        } else {
            System.out.println("ERROR: NO ÉS UNA MATRÍCULA DISPONIBLE");
            ConcessionaireMenu.runMenu(c);
        }
    }
    public void showAvailableVehicles(Concessionaire c) {
        for (int i = 0; i < availableVehicles.size(); i++) {
            System.out.println((i + 1) + ". " + availableVehicles.get(i));
        }
    }

    @Override
    public String toString() {
        return "Concesionari: \n" +
                "Marca principal: " + mainBrand + "\n" +
                (sellSecondHandVehicle? "Venen vehicles de segona mà":"No venen vehicles de segona mà") + "\n" +
                super.toString();
    }
}
