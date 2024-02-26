package ui;

import interfaces.DataIntroduction;
import location.Concessionaire;

public interface ConcessionaireMenu {
    static void runMenu(Concessionaire concessionaire) {
        int option;
        do {
            gui();
            option = DataIntroduction.introduceOption();
            handleOption(option, concessionaire);
        } while (option != 0);
    }
    static void gui() {
        System.out.println("=== MENÚ CONCESSIONARI ===");
        System.out.println("==== ESCULL UNA OPCIÓ ====");
        System.out.println("==========================");
        System.out.println("1. INTRODUIR NOU VEHICLE");
        System.out.println("0. EXIT");
    }
    static void handleOption(int option, Concessionaire concessionaire) {
        switch (option) {
            case 1:
                introduceVehicleMenu();
                introduceVehicle(concessionaire);
                break;
            case 2:
                break;
            case 3:
                break;
            case 0:
                System.out.println("TORNANT AL MENÚ");
                Home.runMenu();
                break;
            default:
                System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");
        }
    }
    static void introduceVehicleMenu() {
        System.out.println("=== ESCULL UNA OPCIÓ ===");
        System.out.println("1. INTRODUIR COTXE");
        System.out.println("2. INTRODUIR MOTO");
        System.out.println("3. INTRODUIR CAMIÓ");
        System.out.println("0. TORNAR AL MENÚ");
    }
    static void introduceVehicle(Concessionaire concessionaire) {
        int option = DataIntroduction.introduceOption();
        switch (option) {
            case 1:
                break;
            case 0:
                runMenu();
                break;
        }
    }
}
