package location;

import app.App;
import interfaces.DataIntroduction;
import ui.ConcessionaireMenu;
import ui.Home;
import vehicles.Car;
import vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Concessionaire extends Location implements ConcessionaireMenu {
    private final List<Vehicle> availableVehiclesConcessionaire = new ArrayList<>();
    private String mainBrand;
    private boolean sellSecondHandVehicle;

    public void setMainBrand(String mainBrand) {
        this.mainBrand = mainBrand;
    }

    public void setSellSecondHandVehicle(boolean sellSecondHandVehicle) {
        this.sellSecondHandVehicle = sellSecondHandVehicle;
    }

    public List<Vehicle> getAvailableVehiclesConcessionaire() {
        return availableVehiclesConcessionaire;
    }

    public Concessionaire(String cityLocation, String countryLocation, int workersAmount, String mainBrand, boolean sellSecondHandVehicle) {
        super(cityLocation, countryLocation, workersAmount);
        this.mainBrand = mainBrand;
        this.sellSecondHandVehicle = sellSecondHandVehicle;
    }

    @Override
    public void addNewVehicle(Vehicle v) {
        availableVehiclesConcessionaire.add(v);
    }

    public void addCar(Concessionaire c) {
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
    public void showAvailableVehicles() {
        for (int i = 0; i < availableVehiclesConcessionaire.size(); i++) {
            System.out.println((i + 1) + ". " + availableVehiclesConcessionaire.get(i));
        }
    }
    public void sellVehicle(Concessionaire concessionaire) {
        if (availableVehiclesConcessionaire.isEmpty()) {
            showAvailableVehicles();
            System.out.println("QUIN VEHICLE VOLS VENDRE?");
            int index = DataIntroduction.introduceInteger();
            try {
                availableVehiclesConcessionaire.remove(index);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR: NO ES TROBA AQUEST COTXE");
                ConcessionaireMenu.runMenu(concessionaire);
            }
            System.out.println("VEHICLE VENUT");
        }
    }
    public void deleteSelfConcessionaire(Concessionaire c) {
        System.out.println("ATENCIÓ ESTÀS A PUNT D'ELIMINAR EL CONCESSIONARI\n" +
                "AQUESTA ACCIÓ ÉS DEFINITIVA I IRREVERSIBLE\n" +
                "ESTÀS SEGUR?/A\n" +
                "1. ELIMINAR\n" +
                "2. NO ELIMINAR");
        int deleteOption = DataIntroduction.introduceInteger();
        if (deleteOption == 1) {
            System.out.println("ESTÀS SEGUR?");
            Random random = new Random();
            int password = random.nextInt();
            System.out.println("INTRODUEIX EL NÚMERO: " + password + " PER CONTINUAR");
            int confirmation = DataIntroduction.introduceInteger();
            if (password == confirmation) {
                int concessionaireIndex = searchConcessionaireById(getId());
                App.concessionaires.remove(concessionaireIndex);
                Home.runMenu();
            } else {
                System.out.println("ERROR: ELS VALORS NO EREN IGUALS");
            }
        } else ConcessionaireMenu.runMenu(c);
    }
    public static int searchConcessionaireById(int id) {
        for (int i = 0; i < App.concessionaires.size(); i++) {
            if (id == App.concessionaires.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public void repairVehicle(int index) {
        if (!App.workshops.isEmpty()) {
            App.showAvailableLocations(App.workshops);
            System.out.println("ESCULL UN TALLER ON REPARAR EL COTXE");
            int workshopIndex = DataIntroduction.introduceInteger();
            Workshop workshop = (Workshop) App.chooseLocation(App.workshops, workshopIndex - 1);
            if (workshop != null) {
                workshop.getAvailableVehiclesWorkshop().add(availableVehiclesConcessionaire.get(index));
                availableVehiclesConcessionaire.remove(index);
                System.out.println("EL COTXE S'HA ENVIAT A REPARAR CORRECTAMENT");
            } else System.out.println("ERROR: NO ES TROBA EL TALLER");
        } else System.out.println("ERROR: NO ES TROBEN TALLERS DISPONIBLES");
    }

    @Override
    public String toString() {
        return "Concesionari: \n" +
                "Marca principal: " + mainBrand + "\n" +
                (sellSecondHandVehicle? "Venen vehicles de segona mà":"No venen vehicles de segona mà") + "\n" +
                super.toString();
    }
}
