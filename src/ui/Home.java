package ui;

import interfaces.DataIntroduction;
import location.Concessionaire;
import app.App;
import location.Workshop;

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
        System.out.println("0. TANCAR APLICACIÓ");
    }
    static void handleOption(int option) {
        switch (option) {
            case 1:
                if (!App.concessionaires.isEmpty()) {
                    App.showAvailableLocations(App.concessionaires);
                    int concessionaireIndex = DataIntroduction.introduceInteger();
                    Concessionaire concessionaire = (Concessionaire) App.chooseLocation(App.concessionaires ,concessionaireIndex - 1);
                    if (concessionaire != null) {
                        ConcessionaireMenu.runMenu(concessionaire);
                    } else {
                        System.out.println("ERROR: NO ES TROBA EL CONCESSIONARI");
                        break;
                    }
                } else System.out.println("ERROR: NO ES TROBEN CONCESSIONARIS DISPONIBLES");
                break;
            case 2:
                if (!App.workshops.isEmpty()) {
                    App.showAvailableLocations(App.workshops);
                    int workshopIndex = DataIntroduction.introduceInteger();
                    Workshop workshop = (Workshop) App.chooseLocation(App.workshops ,workshopIndex - 1);
                    if (workshop != null) {
                        WorkshopMenu.runMenu(workshop);
                    } else {
                        System.out.println("ERROR: NO ES TROBA EL TALLER");
                        break;
                    }
                } else System.out.println("ERROR: NO ES TROBEN TALLERS DISPONIBLES");
                break;
            case 3:
                break;
            case 0:
                System.out.println("EL PPROGRAMA ES TANCA...");
                System.exit(0);
                break;
            default:
                System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");;
        }
    }

}
