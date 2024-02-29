package interfaces;

import app.App;
import location.Concessionaire;
import location.Workshop;
import vehicles.Car;
import vehicles.Motorcycle;
import vehicles.Vehicle;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface DataIntroduction {
    static int introduceInteger() {
        Scanner sc = new Scanner(System.in);
        int num;
        try {
            num = sc.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
        return num;
    }

    static String introducePlate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("INTRODUEIX LA MATRÍCULA");
        String plate = sc.nextLine();
        if (plate.matches("^(([A-Z]{2}\\d{4}[A-Z]{2})|([0-9]{4}[A-Z]{3}))$") && verifyDuplicatedPlate(plate)) {
            return plate;
        }
        return null;
    }

    static boolean verifyDuplicatedPlate(String plate) {
        for (Concessionaire concessionaire : App.concessionaires) {
            for (Vehicle v : concessionaire.getAvailableVehiclesConcessionaire()) {
                if (plate.equals(v.getPlate())) {
                    return false;
                }
            }
        }
        for (Workshop workshop : App.workshops) {
            for (Vehicle v : workshop.getAvailableVehiclesWorkshop()) {
                if (plate.equals(v.getPlate())) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean introduceBoolean() {
        int num;
        do {
            System.out.println("INTRODUEIX:\n1. TRUE\n2. FALSE");
            num = DataIntroduction.introduceInteger();
            if (num != 1 && num != 2) {
                System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");
            }
        } while (num != 1 && num != 2);
        return num == 1;
    }

    static char introduceFuelType() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ESCULL UN TIPUS DE COMBUSTIBLE");
        System.out.println("==============================");
        System.out.println("Gasolina, Diesel, Elèctric");
        System.out.println("|   G   |   D   |   E   |");
        char fuel = sc.next().charAt(0);
        if (Character.isLetter(fuel)) {
            fuel = Character.toUpperCase(fuel);
            if (fuel == 'G' || fuel == 'D' || fuel == 'E') {
                return fuel;
            } else return '0';
        } else return '0';
    }

    static void loadData() {
        Concessionaire c1 = new Concessionaire("Barcelona", "Spain", 22, "Volkswagen", true);
        Concessionaire c2 = new Concessionaire("Madrid", "Spain", 18, "Ford", false);
        Concessionaire c3 = new Concessionaire("Paris", "France", 30, "Renault", true);
        Concessionaire c4 = new Concessionaire("Rome", "Italy", 25, "Fiat", false);
        Concessionaire c5 = new Concessionaire("Berlin", "Germany", 20, "BMW", true);

        c1.addNewVehicle(new Car("5380KFG", 'G', 100, "Sedan", 4, 500));
        c1.addNewVehicle(new Car("2541BKL", 'D', 120, "Compacte", 4, 450));
        c1.addNewVehicle(new Car("7869MNO", 'G', 220, "Esportiu", 2, 300));
        c1.addNewVehicle(new Motorcycle("4392CDE", 'E', 60, "Moto Esportiva", 15, 600));
        c1.addNewVehicle(new Car("6754GHI", 'E', 110, "Sedan", 4, 480));
        c1.addNewVehicle(new Car("1078XYZ", 'G', 90, "Descapotable", 2, 350));
        c1.addNewVehicle(new Car("2398UVW", 'D', 80, "Utilitari", 4, 400));

        c2.addNewVehicle(new Car("7685RST", 'G', 230, "Esportiu", 2, 320));
        c2.addNewVehicle(new Car("4531IJK", 'D', 110, "Compacte", 4, 460));
        c2.addNewVehicle(new Car("6890OPQ", 'G', 100, "Compacte", 4, 470));
        c2.addNewVehicle(new Car("1246FGH", 'G', 130, "SUV", 4, 600));
        c2.addNewVehicle(new Motorcycle("2389PLM", 'G', 80, "Moto Custom", 12, 500));

        c3.addNewVehicle(new Car("7863LMN", 'G', 140, "Sedan", 4, 490));
        c3.addNewVehicle(new Car("8924PQR", 'D', 200, "Esportiu", 2, 330));
        c3.addNewVehicle(new Car("5407STU", 'G', 130, "Compacte", 4, 455));
        c3.addNewVehicle(new Motorcycle("6709ZYX", 'G', 70, "Moto Naked", 14, 400));
        c3.addNewVehicle(new Car("2538VWX", 'E', 120, "Sedan", 4, 475));
        c3.addNewVehicle(new Car("9761YZA", 'G', 110, "Compacte", 4, 465));
        c3.addNewVehicle(new Car("3146BCD", 'E', 90, "Descapotable", 2, 340));

        c4.addNewVehicle(new Car("4532HIJ", 'G', 260, "Esportiu", 2, 310));
        c4.addNewVehicle(new Car("6834KLM", 'D', 120, "Sedan", 4, 485));
        c4.addNewVehicle(new Car("2957NOP", 'G', 110, "Compacte", 4, 475));
        c4.addNewVehicle(new Car("1476QRS", 'G', 140, "SUV", 4, 610));
        c4.addNewVehicle(new Motorcycle("7531MNO", 'G', 90, "Moto Sport-Turisme", 13, 750));

        c5.addNewVehicle(new Car("1247TUV", 'G', 110, "Compacte", 4, 455));
        c5.addNewVehicle(new Car("5863WXY", 'D', 320, "Esportiu", 2, 325));
        c5.addNewVehicle(new Car("3891ZAB", 'G', 130, "Sedan", 4, 480));
        c5.addNewVehicle(new Car("6423CDE", 'E', 140, "Compacte", 4, 450));
        c5.addNewVehicle(new Car("5791FGH", 'E', 220, "Esportiu", 2, 385));

        Workshop w1 = new Workshop("Barcelona", "Spain", 15, "Taller del Motor");
        Workshop w2 = new Workshop("Madrid", "Spain", 20, "Mechanical Masters");
        Workshop w3 = new Workshop("Lyon", "France", 12, "Speedy Fix");
        Workshop w4 = new Workshop("Milan", "Italy", 18, "Car Care Center");
        Workshop w5 = new Workshop("Berlin", "Germany", 22, "Auto Tech");

        w1.addNewVehicle(new Car("1047WXY", 'G', 160, "Compacte", 4, 400));
        w1.addNewVehicle(new Car("5863OPQ", 'D', 220, "Esportiu", 4, 450));
        w1.addNewVehicle(new Car("3891ABC", 'G', 170, "Berlina", 4, 500));
        w1.addNewVehicle(new Motorcycle("6423LMN", 'E', 50, "Moto Sport-Turisme", 13, 500));

        w2.addNewVehicle(new Car("7481XYZ", 'G', 150, "SUV", 4, 420));
        w2.addNewVehicle(new Car("2956DEF", 'D', 170, "Compacte", 4, 380));
        w2.addNewVehicle(new Car("8302MNO", 'G', 310, "Esportiu", 4, 450));
        w2.addNewVehicle(new Motorcycle("5174PQR", 'E', 40, "Moto Custom", 12, 750));

        w3.addNewVehicle(new Car("9623FGH", 'G', 170, "Descapotable", 2, 300));
        w3.addNewVehicle(new Car("5419JKL", 'D', 120, "Utilitari", 4, 350));
        w3.addNewVehicle(new Car("3840STU", 'G', 180, "Compacte", 4, 400));
        w3.addNewVehicle(new Motorcycle("7201VWX", 'G', 60, "Moto Naked", 14, 400));

        w4.addNewVehicle(new Car("6785BCD", 'G', 180, "Esportiu", 4, 450));
        w4.addNewVehicle(new Car("9530EFG", 'D', 170, "Berlina", 4, 500));
        w4.addNewVehicle(new Car("4218HIJ", 'G', 190, "Compacte", 4, 400));
        w4.addNewVehicle(new Motorcycle("3067KLM", 'G', 70, "Moto Scooter", 11, 300));

        w5.addNewVehicle(new Car("8457NOP", 'G', 90, "Compacte", 4, 400));
        w5.addNewVehicle(new Car("1392QRS", 'D', 210, "Esportiu", 4, 450));
        w5.addNewVehicle(new Car("5062TUV", 'G', 170, "Berlina", 4, 500));
        w5.addNewVehicle(new Motorcycle("2783WXY", 'E', 50, "Moto Sport-Turisme", 13, 500));
        w5.addNewVehicle(new Motorcycle("7149ZAB", 'E', 40, "Moto Custom", 12, 750));

        App.addConcessionaire(c1);
        App.addConcessionaire(c2);
        App.addConcessionaire(c3);
        App.addConcessionaire(c4);
        App.addConcessionaire(c5);

        App.addWorkshop(w1);
        App.addWorkshop(w2);
        App.addWorkshop(w3);
        App.addWorkshop(w4);
        App.addWorkshop(w5);
    }
}
