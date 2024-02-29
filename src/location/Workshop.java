package location;

import app.App;
import interfaces.DataIntroduction;
import ui.Home;
import ui.WorkshopMenu;
import vehicles.Car;
import vehicles.Vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    public void setName(String name) {
        this.name = name;
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
                    System.out.println("INTRODUEIX EL NÚMERO DE PORTES");
                    int doorQuantity = DataIntroduction.introduceInteger();
                    if (doorQuantity > 0 && doorQuantity < 6) {
                        System.out.println("INTRODUIEX LA CAPACITAT DEL MALETER EN LITRES");
                        int trunkCapacity = DataIntroduction.introduceInteger();
                        if (trunkCapacity != -1) {
                            Car car = new Car(plate, fuel, horsePower, type, doorQuantity, trunkCapacity);
                            addNewVehicle(car);
                        } else {
                            System.out.println("ERROR: NO ÉS UNA CAPACITAT VÀLIDA");
                            WorkshopMenu.runMenu(w);
                        }
                    } else {
                        System.out.println("ERROR: NO ÉS UN NÚMERO DE PORTES VÀLID");
                        WorkshopMenu.runMenu(w);
                    }
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
    public void deleteSelfWorkshop(Workshop w) {
        if (Home.verifyDeletion()) {
            int concessionaireIndex = searchWorkshopById(getId());
            App.workshops.remove(concessionaireIndex);
            Home.runMenu();
        } else WorkshopMenu.runMenu(w);
    }
    public static int searchWorkshopById(int id) {
        for (int i = 0; i < App.workshops.size(); i++) {
            if (id == App.workshops.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString() {
        return "Taller: " + "\n" +
                "Nom: " + name + "\n" +
                super.toString();
    }
}
