package ui;

import interfaces.DataIntroduction;
import location.Workshop;

public interface WorkshopMenu {
    static void runMenu(Workshop workshop) {
        int option;
        do {
            gui(workshop);
            option = DataIntroduction.introduceInteger();
            handleOption(option, workshop);
        } while (option != 0);
    }
    static void gui(Workshop workshop) {
        System.out.println("TALLER: " + workshop.getName());
        System.out.println("====== MENÚ  TALLER ======");
        System.out.println("==== ESCULL UNA OPCIÓ ====");
        System.out.println("==========================");
        System.out.println("1. INTRODUIR NOU VEHICLE");
        System.out.println("2. MOSTRAR ELS VEHICLES");
        System.out.println("0. EXIT");
    }
    static void handleOption(int option, Workshop workshop) {
        switch (option) {
            case 1:

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
}
