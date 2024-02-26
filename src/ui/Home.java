package ui;

import interfaces.DataIntroduction;
import location.Concessionaire;

public interface Home {
    static void runMenu() {
        int option;
        do {
            gui();
            option = DataIntroduction.introduceOption();
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
        System.out.println("0. TANCAR APLICACIÓ");
    }
    static void handleOption(int option) {
        switch (option) {
            case 1:
                Concessionaire concessionaire = new;
                ConcessionaireMenu.runMenu(concessionaire);
                break;
            case 2:
                WorkshopMenu.runMenu();
                break;
            case 3:
                break;
            case 0:
                System.out.println("EL PPROGRAMA ES TANCA...");
                System.exit(0);
                break;
        }
    }
    static Concessionaire showAvailableConcessionaire() {
        for (int i = 0; i < App.getConcessionaires; i++) {

        }
    }
}
