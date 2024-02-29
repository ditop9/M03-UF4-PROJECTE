package location;

import app.App;
import interfaces.DataIntroduction;
import ui.WorkshopMenu;
import vehicles.Car;
import vehicles.Motorcycle;
import vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Workshop extends Location {
    private final List<Vehicle> availableVehiclesWorkshop = new ArrayList<>();
    private String name;

    public List<Vehicle> getAvailableVehiclesWorkshop() {
        return availableVehiclesWorkshop;
    }

    public String getName() {
        return name;
    }

    public Workshop(String cityLocation, String countryLocation, int workersAmount, String name) {
        super(cityLocation, countryLocation, workersAmount);
        this.name = name;
    }

    @Override
    public void addNewVehicle(Vehicle v) {
        availableVehiclesWorkshop.add(v);
    }

    public void introduceCar(Workshop w) {
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
                    WorkshopMenu.runMenu(w);
                }
            } else {
                System.out.println("ERROR: NO ÉS UN TIPUS DE COMBUSTIBLE VÀLID");
                WorkshopMenu.runMenu(w);
            }
        } else {
            System.out.println("ERROR: NO ÉS UNA MATRÍCULA DISPONIBLE");
            WorkshopMenu.runMenu(w);
        }
    }

    public void showAvailableVehicles(){
        for (int i = 0; i < availableVehiclesWorkshop.size(); i++) {
            System.out.println((i + 1) + ". " + availableVehiclesWorkshop.get(i));
        }
    }
    public void repairVehicle(int index) {
        if (!App.concessionaires.isEmpty()) {
            App.showAvailableLocations(App.concessionaires);
            System.out.println("ESCULL UN CONCESSIONARI ON ENVIAR EL COTXE REPARAT");
            int concessionaireIndex = DataIntroduction.introduceInteger();
            Concessionaire concessionaire = (Concessionaire) App.chooseLocation(App.concessionaires, concessionaireIndex - 1);
            if (concessionaire != null) {
                concessionaire.getAvailableVehiclesConcessionaire().add(availableVehiclesWorkshop.get(index));
                availableVehiclesWorkshop.remove(index);
                System.out.println("EL COTXE S'HA ENVIAT REPARAT CORRECTAMENT");
            } else System.out.println("ERROR: NO ES TROBA EL CONCESSIONARI");
        } else System.out.println("ERROR: NO ES TROBEN CONCESSIONARIS DISPONIBLES");
    }
    @Override
    public String toString() {
        return "Concessionari: " + "\n" +
                "Nom: " + name + "\n" +
                super.toString();
    }
}
