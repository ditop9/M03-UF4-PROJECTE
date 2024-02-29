package ui;

import interfaces.DataIntroduction;
import location.Workshop;

import java.util.Scanner;

public interface WorkshopMenu extends Home {
    static void runMenu(Workshop w) {
        int option;
        do {
            gui(w);
            option = DataIntroduction.introduceInteger();
            handleOption(option, w);
        } while (option != 0);
    }
    static void gui(Workshop w) {
        System.out.println("TALLER: " + w.getName());
        System.out.println("====== MENÚ  TALLER ======");
        System.out.println("==== ESCULL UNA OPCIÓ ====");
        System.out.println("==========================");
        System.out.println("1. INTRODUIR NOU VEHICLE");
        System.out.println("2. MOSTRAR ELS VEHICLES");
        System.out.println("3. REPARAR UN VEHICLE");
        System.out.println("4. EDITAR INFORMACIÓ TALLER");
        System.out.println("5. ELIMINAR EL TALLER");
        System.out.println("0. EXIT");
    }
    static void handleOption(int option, Workshop w) {
        switch (option) {
            case 1:
                Home.introduceVehicleUi();
                introduceVehicleMenu(w);
                break;
            case 2:
                if (!w.getAvailableVehiclesWorkshop().isEmpty()) {
                    w.showAvailableVehicles();
                } else System.out.println("ERROR: NO ES TROBEN VEHICLES REGISTRATS");
                break;
            case 3:
                if (!w.getAvailableVehiclesWorkshop().isEmpty()) {
                    w.showAvailableVehicles();
                    System.out.println("ESCULL UN COTXE A REPARAR");
                    int index = DataIntroduction.introduceInteger();
                    if (index != -1) {
                        try {
                            w.repairVehicle(index - 1);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("ERROR: NO ES TROBA EL VEHICLE");
                            WorkshopMenu.runMenu(w);
                            break;
                        }
                    } else {
                        System.out.println("ERROR: NO ÉS UN CARÀCTER VÀLID");
                        WorkshopMenu.runMenu(w);
                        break;
                    }
                } else {
                    System.out.println("ERROR: NO ES TROBEN VEHICLES REGISTRATS");
                    WorkshopMenu.runMenu(w);
                    break;
                }
                break;
            case 4:
                changeInformationMenu();
                int changeInformationOption = DataIntroduction.introduceInteger();
                changeInformation(changeInformationOption, w);
                break;
            case 5:
                w.deleteSelfWorkshop(w);
                break;
            case 0:
                System.out.println("TORNANT AL MENÚ");
                Home.runMenu();
                break;
            default:
                System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");
        }
    }
    static void introduceVehicleMenu(Workshop w) {
        int option = DataIntroduction.introduceInteger();
        switch (option) {
            case 1:
                w.introduceCar(w);
                break;
            case 0:
                runMenu(w);
                break;
            default:
                System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");
                break;
        }
    }
    static void changeInformationMenu() {
        System.out.println("ESCULL LA INFORMACIÓ QUE VOLS CANVIAR");
        System.out.println("1. CIUTAT");
        System.out.println("2. PAÍS");
        System.out.println("3. TREBALLADORS");
        System.out.println("4. NOM TALLER");
        System.out.println("0. EXIT");
    }
    static void changeInformation(int option, Workshop w) {
        Scanner sc = new Scanner(System.in);
        switch (option) {
            case 1:
                System.out.println("INTRODUIEX LA NOVA CIUTAT");
                w.setCityLocation(sc.nextLine());
                break;
            case 2:
                System.out.println("INTRODUEIX EL NOU PAÍS");
                w.setCountryLocation(sc.nextLine());
                break;
            case 3:
                System.out.println("INTRODUEIX LA QUANTITAT DE TREBALLADORS");
                int newWorkers = DataIntroduction.introduceInteger();
                if (newWorkers != -1) {
                    w.setWorkersAmount(newWorkers);
                } else System.out.println("ERROR: NO ÉS UN CARÀCTER VÀLID");
                break;
            case 4:
                System.out.println("INTRODUEIX EL NOM DEL TALLER");
                w.setName(sc.nextLine());
                break;
            case 0:
                WorkshopMenu.runMenu(w);
            default:
                System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");
                WorkshopMenu.runMenu(w);
        }
    }
}
