package ui;

import interfaces.DataIntroduction;
import vehicles.Vehicle;

import java.util.ArrayList;

public interface WorkshopMenu {
    ArrayList<Vehicle> workshopVehicles = new ArrayList<>();
    static void runMenu() {
        int option;
        do {
            gui();
            option = DataIntroduction.introduceOption();
            handleOption(option);
        } while (option != 0);
    }
    static void gui() {
        System.out.println("====== MENÚ  TALLER ======");
        System.out.println("==== ESCULL UNA OPCIÓ ====");
        System.out.println("==========================");
        System.out.println("1. ");
        System.out.println("0. EXIT");
    }
    static void handleOption(int option) {
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
