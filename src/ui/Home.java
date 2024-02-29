package ui;

import interfaces.DataIntroduction;
import location.Concessionaire;
import app.App;
import location.Location;
import location.Workshop;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public interface Home {
    static void runMenu() {
        int option;
        do {
            gui();
            option = DataIntroduction.introduceInteger();
            handleOption(option);
        } while (option != 0);
    }
    static void gui() {
        System.out.println("===== MENÚ PRINCIPAL =====");
        System.out.println("__________________________");
        System.out.println("==== ESCULL UNA OPCIÓ ====");
        System.out.println("==========================");
        System.out.println("1. MENÚ CONCESSIONARI");
        System.out.println("2. MENÚ TALLER");
        System.out.println("3. AFEGIR NOU CONCESSIONARI");
        System.out.println("4. AFEGIR NOU TALLER");
        System.out.println("5. ELIMINAR UN CONCESSIONARI");
        System.out.println("6. ELIMINAR UN TALLER");
        System.out.println("0. TANCAR APLICACIÓ");
    }
    static void handleOption(int option) {
        switch (option) {
            case 1:
                runConcessionaireMenu();
                break;
            case 2:
                runWorkshopMenu();
                break;
            case 3:
                addNewConcessionaire();
                break;
            case 4:
                addNewWorkshop();
                break;
            case 5:
                deleteLocation(App.concessionaires);
                break;
            case 6:
                deleteLocation(App.workshops);
                break;
            case 0:
                System.out.println("EL PPROGRAMA ES TANCA...");
                System.exit(0);
                break;
            default:
                System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");
        }
    }
    static void deleteLocation(List<?> locations) {
        if (!locations.isEmpty()) {
            App.showAvailableLocations(locations);
            System.out.println("0. EXIT");
            int locationIndex = DataIntroduction.introduceInteger();
            if (locationIndex != 0 && locationIndex != -1 && verifyDeletion()) {
                locations.remove(locationIndex);
            } else runMenu();
        } else {
            System.out.println("ERROR: NO ES TROBEN LOCALS DISPONIBLES");
            runMenu();
        }
    }
    static void addNewConcessionaire() {
        Scanner sc = new Scanner(System.in);
        System.out.println("INTRODUEIX LA CIUTAT");
        String city = sc.nextLine();
        System.out.println("INTRODUEIX EL PAÍS");
        String country = sc.nextLine();
        System.out.println("INTRODUEIX LA QUANTITAT DE TRBALLADORS");
        int workers = DataIntroduction.introduceInteger();
        if (workers != -1) {
            System.out.println("INTRODUEIX LA MARCA PRINCIPAL");
            String mainBrand = sc.nextLine();
            System.out.println("VEN VEHICLES DE SEGONA MARCA?");
            boolean secondHand = DataIntroduction.introduceBoolean();
            Concessionaire concessionaire = new Concessionaire(city, country, workers, mainBrand, secondHand);
            App.concessionaires.add(concessionaire);
        } else {
            System.out.println("ERROR: NO ÉS UN CARÀCTER VÀLID");
            runMenu();
        }
    }
    static void addNewWorkshop() {
        Scanner sc = new Scanner(System.in);
        System.out.println("INTRODUEIX LA CIUTAT");
        String city = sc.nextLine();
        System.out.println("INTRODUEIX EL PAÍS");
        String country = sc.nextLine();
        System.out.println("INTRODUEIX LA QUANTITAT DE TRBALLADORS");
        int workers = DataIntroduction.introduceInteger();
        if (workers != -1) {
            System.out.println("INTRODUEIX EL NOM DEL TALLER");
            String workshopName = sc.nextLine();
            Workshop workshop = new Workshop(city, country, workers, workshopName);
            App.workshops.add(workshop);
        } else {
            System.out.println("ERROR: NO ÉS UN CARÀCTER VÀLID");
            runMenu();
        }
    }
    static void introduceVehicleUi() {
        System.out.println("=== ESCULL UNA OPCIÓ ===");
        System.out.println("1. INTRODUIR COTXE");
        System.out.println("2. INTRODUIR MOTO");
        System.out.println("3. INTRODUIR CAMIÓ");
        System.out.println("0. TORNAR AL MENÚ");
    }
    static void runConcessionaireMenu() {
        if (!App.concessionaires.isEmpty()) {
            App.showAvailableLocations(App.concessionaires);
            System.out.println("0. EXIT");
            int concessionaireIndex = DataIntroduction.introduceInteger();
            if (concessionaireIndex != 0) {
                Concessionaire concessionaire = (Concessionaire) App.chooseLocation(App.concessionaires ,concessionaireIndex - 1);
                if (concessionaire != null) {
                    ConcessionaireMenu.runMenu(concessionaire);
                } else {
                    System.out.println("ERROR: NO ES TROBA EL CONCESSIONARI");
                }
            } else Home.runMenu();
        } else System.out.println("ERROR: NO ES TROBEN CONCESSIONARIS DISPONIBLES");
    }
    static void runWorkshopMenu() {
        if (!App.workshops.isEmpty()) {
            App.showAvailableLocations(App.workshops);
            System.out.println("0. EXIT");
            int workshopIndex = DataIntroduction.introduceInteger();
            if (workshopIndex != 0) {
                Workshop workshop = (Workshop) App.chooseLocation(App.workshops ,workshopIndex - 1);
                if (workshop != null) {
                    WorkshopMenu.runMenu(workshop);
                } else {
                    System.out.println("ERROR: NO ES TROBA EL TALLER");
                }
            } else Home.runMenu();
        } else System.out.println("ERROR: NO ES TROBEN TALLERS DISPONIBLES");
    }
    static boolean verifyDeletion() {
        System.out.println("""
                ATENCIÓ ESTÀS A PUNT D'ELIMINAR EL LOCAL
                AQUESTA ACCIÓ ÉS DEFINITIVA I IRREVERSIBLE
                ESTÀS SEGUR?/A
                1. ELIMINAR
                2. NO ELIMINAR""");
        int deleteOption = DataIntroduction.introduceInteger();
        if (deleteOption == 1) {
            System.out.println("ESTÀS SEGUR?");
            Random random = new Random();
            int password = random.nextInt();
            System.out.println("INTRODUEIX EL NÚMERO: " + password + " PER CONTINUAR");
            int confirmation = DataIntroduction.introduceInteger();
            if (password == confirmation) {
                return true;
            } else {
                System.out.println("ERROR: ELS VALORS NO EREN IGUALS");
                return false;
            }
        } else return false;
    }
}
