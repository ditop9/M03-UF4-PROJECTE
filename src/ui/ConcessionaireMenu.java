package ui;

import interfaces.DataIntroduction;
import location.Concessionaire;

import java.util.Scanner;

public interface ConcessionaireMenu extends Home {
    static void runMenu(Concessionaire c) {
        int option;
        do {
            gui();
            option = DataIntroduction.introduceInteger();
            handleOption(option, c);
        } while (option != 0);
    }
    static void gui() {
        System.out.println("=== MENÚ CONCESSIONARI ===");
        System.out.println("==== ESCULL UNA OPCIÓ ====");
        System.out.println("==========================");
        System.out.println("1. INTRODUIR NOU VEHICLE");
        System.out.println("2. MOSTRAR ELS VEHICLES");
        System.out.println("3. VENDRE UN VEHICLE");
        System.out.println("4. MANDAR UN VEHICLE A REPARAR");
        System.out.println("5. EDITAR INFORMACIÓ CONCESSIONARI");
        System.out.println("6. ELIMINAR EL CONCESSIONARI");
        System.out.println("0. EXIT");
    }
    static void handleOption(int option, Concessionaire c) {
        switch (option) {
            case 1:
                Home.introduceVehicleUi();
                introduceVehicleMenu(c);
                break;
            case 2:
                if (!c.getAvailableVehiclesConcessionaire().isEmpty()) {
                    c.showAvailableVehicles();
                } else System.out.println("ERROR: NO ES TROBEN VEHICLES DISPONIBLES");
                break;
            case 3:
                c.sellVehicle(c);
                break;
            case 4:
                if (!c.getAvailableVehiclesConcessionaire().isEmpty()) {
                    c.showAvailableVehicles();
                    System.out.println("ESCULL UN COTXE A REPARAR");
                    int index = DataIntroduction.introduceInteger();
                    if (index != -1) {
                        try {
                            c.repairVehicle(index - 1);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("ERROR: NO ES TROBA EL VEHICLE");
                            ConcessionaireMenu.runMenu(c);
                            break;
                        }
                    } else {
                        System.out.println("ERROR: NO ÉS UN CARÀCTER VÀLID");
                        ConcessionaireMenu.runMenu(c);
                        break;
                    }
                } else {
                    System.out.println("ERROR: NO ES TROBEN VEHICLES REGISTRATS");
                    ConcessionaireMenu.runMenu(c);
                    break;
                }
                break;
            case 5:
                changeInformationMenu();
                int changeInformationOption = DataIntroduction.introduceInteger();
                changeInformation(changeInformationOption, c);
                break;
            case 6:
                c.deleteSelfConcessionaire(c);
                break;
            case 0:
                System.out.println("TORNANT AL MENÚ");
                Home.runMenu();
                break;
            default:
                System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");
        }
    }
    static void introduceVehicleMenu(Concessionaire c) {
        int option = DataIntroduction.introduceInteger();
        switch (option) {
            case 1:
                c.addCar(c);
                break;
            case 2:
                c.addMotorcycle(c);
                break;
            case 0:
                runMenu(c);
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
        System.out.println("4. MARCA PRINCIPAL");
        System.out.println("5. VENEN COTXES SEGONA MÀ");
        System.out.println("0. EXIT");
    }
    static void changeInformation(int option,Concessionaire c) {
        Scanner sc = new Scanner(System.in);
        switch (option) {
            case 1:
                System.out.println("INTRODUIEX LA NOVA CIUTAT");
                c.setCityLocation(sc.nextLine());
                break;
            case 2:
                System.out.println("INTRODUEIX EL NOU PAÍS");
                c.setCountryLocation(sc.nextLine());
                break;
            case 3:
                System.out.println("INTRODUEIX LA QUANTITAT DE TREBALLADORS");
                int newWorkers = DataIntroduction.introduceInteger();
                if (newWorkers != -1) {
                    c.setWorkersAmount(newWorkers);
                } else System.out.println("ERROR: NO ÉS UN CARÀCTER VÀLID");
                break;
            case 4:
                System.out.println("INTRODUEIX LA MARCA PRINCIPAL");
                c.setMainBrand(sc.nextLine());
                break;
            case 5:
                System.out.println("VENEN COTXES DE SEGONA MÀ?");
                c.setSellSecondHandVehicle(DataIntroduction.introduceBoolean());
                break;
            case 0:
                ConcessionaireMenu.runMenu(c);
            default:
                System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");
                ConcessionaireMenu.runMenu(c);
        }
    }
}
