package ui;

import interfaces.DataIntroduction;
import location.Concessionaire;

public interface ConcessionaireMenu extends Home {
    static void runMenu(Concessionaire concessionaire) {
        int option;
        do {
            gui();
            option = DataIntroduction.introduceInteger();
            handleOption(option, concessionaire);
        } while (option != 0);
    }
    static void gui() {
        System.out.println("=== MENÚ CONCESSIONARI ===");
        System.out.println("==== ESCULL UNA OPCIÓ ====");
        System.out.println("==========================");
        System.out.println("1. INTRODUIR NOU VEHICLE");
        System.out.println("2. MOSTRAR ELS VEHICLES");
        System.out.println("0. EXIT");
    }
    static void handleOption(int option, Concessionaire concessionaire) {
        switch (option) {
            case 1:
                Home.introduceVehicleUi();
                introduceVehicleMenu(concessionaire);
                break;
            case 2:
                concessionaire.showAvailableVehicles(concessionaire);
                break;
            case 3:
                break;
            case 0:
                System.out.println("TORNANT AL MENÚ");
                runMenu(concessionaire);
                break;
            default:
                System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");
        }
    }
    static void introduceVehicleMenu(Concessionaire concessionaire) {
        int option = DataIntroduction.introduceInteger();
        switch (option) {
            case 1:
                concessionaire.introduceCar(concessionaire);
                break;
            case 0:
                runMenu(concessionaire);
                break;
        }
    }
}
