package interfaces;

import app.App;
import location.Concessionaire;
import location.Workshop;
import vehicles.Car;

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
        if (plate.matches("^(([A-Z]{2}\\d{4}[A-Z]{2})|([0-9]{4}[A-Z]{3}))$")) {
            return plate;
        } return null;
    }
    static boolean introduceBoolean() {
        int num;
        do {
            System.out.println("INTRODUEIX:\n1. TRUE\n2. FALSE");
            num = DataIntroduction.introduceInteger();
            if (num != 1  && num != 2) {
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

        c1.addNewVehicle(new Car("5380KFG", 'G', 150, "Sedan"));
        c1.addNewVehicle(new Car("2541BKL", 'D', 180, "Compacte"));
        c1.addNewVehicle(new Car("7869MNO", 'G', 200, "Esportiu"));
        c1.addNewVehicle(new Car("4392CDE", 'E', 170, "Compacte"));
        c1.addNewVehicle(new Car("6754GHI", 'E', 190, "Sedan"));
        c1.addNewVehicle(new Car("1078XYZ", 'G', 170, "Descapotable"));
        c1.addNewVehicle(new Car("2398UVW", 'D', 160, "Utilitari"));

        c2.addNewVehicle(new Car("7685RST", 'G', 160, "Esportiu"));
        c2.addNewVehicle(new Car("4531IJK", 'D', 180, "Compacte"));
        c2.addNewVehicle(new Car("6890OPQ", 'G', 170, "Compacte"));
        c2.addNewVehicle(new Car("1246FGH", 'G', 180, "SUV"));

        c3.addNewVehicle(new Car("7863LMN", 'G', 190, "Sedan"));
        c3.addNewVehicle(new Car("8924PQR", 'D', 200, "Esportiu"));
        c3.addNewVehicle(new Car("5407STU", 'G', 180, "Compacte"));
        c3.addNewVehicle(new Car("2538VWX", 'E', 160, "Sedan"));
        c3.addNewVehicle(new Car("9761YZA", 'G', 170, "Compacte"));
        c3.addNewVehicle(new Car("3146BCD", 'E', 170, "Descapotable"));
        c3.addNewVehicle(new Car("5247EFG", 'G', 160, "Utilitari"));

        c4.addNewVehicle(new Car("4532HIJ", 'G', 180, "Esportiu"));
        c4.addNewVehicle(new Car("6834KLM", 'D', 170, "Sedan"));
        c4.addNewVehicle(new Car("2957NOP", 'G', 190, "Compacte"));
        c4.addNewVehicle(new Car("1476QRS", 'G', 190, "SUV"));

        c5.addNewVehicle(new Car("1247TUV", 'G', 160, "Compacte"));
        c5.addNewVehicle(new Car("5863WXY", 'D', 180, "Esportiu"));
        c5.addNewVehicle(new Car("3891ZAB", 'G', 170, "Sedan"));
        c5.addNewVehicle(new Car("6423CDE", 'E', 190, "Compacte"));
        c5.addNewVehicle(new Car("5791FGH", 'E', 160, "Esportiu"));
        c5.addNewVehicle(new Car("2185IJK", 'D', 170, "Descapotable"));
        c5.addNewVehicle(new Car("7932LMN", 'G', 160, "Utilitari"));

        Workshop w1 = new Workshop("Barcelona", "Spain", 15, "Taller del Motor");
        Workshop w2 = new Workshop("Madrid", "Spain", 20, "Mechanical Masters");
        Workshop w3 = new Workshop("Lyon", "France", 12, "Speedy Fix");
        Workshop w4 = new Workshop("Milan", "Italy", 18, "Car Care Center");
        Workshop w5 = new Workshop("Berlin", "Germany", 22, "Auto Tech");

        w1.addNewVehicle(new Car("1047WXY", 'G', 160, "Compacte"));
        w1.addNewVehicle(new Car("5863OPQ", 'D', 180, "Esportiu"));
        w1.addNewVehicle(new Car("3891ABC", 'G', 170, "Berlina"));
        w1.addNewVehicle(new Car("6423LMN", 'E', 190, "Compacte"));

        w2.addNewVehicle(new Car("7481XYZ", 'G', 150, "SUV"));
        w2.addNewVehicle(new Car("2956DEF", 'D', 170, "Compacte"));
        w2.addNewVehicle(new Car("8302MNO", 'G', 180, "Esportiu"));
        w2.addNewVehicle(new Car("5174PQR", 'E', 160, "Compacte"));

        w3.addNewVehicle(new Car("9623FGH", 'G', 170, "Descapotable"));
        w3.addNewVehicle(new Car("5419JKL", 'D', 190, "Utilitari"));
        w3.addNewVehicle(new Car("3840STU", 'G', 180, "Compacte"));
        w3.addNewVehicle(new Car("7201VWX", 'E', 160, "Berlina"));

        w4.addNewVehicle(new Car("6785BCD", 'G', 180, "Esportiu"));
        w4.addNewVehicle(new Car("9530EFG", 'D', 170, "Berlina"));
        w4.addNewVehicle(new Car("4218HIJ", 'G', 190, "Compacte"));
        w4.addNewVehicle(new Car("3067KLM", 'G', 190, "SUV"));

        w5.addNewVehicle(new Car("8457NOP", 'G', 160, "Compacte"));
        w5.addNewVehicle(new Car("1392QRS", 'D', 180, "Esportiu"));
        w5.addNewVehicle(new Car("5062TUV", 'G', 170, "Berlina"));
        w5.addNewVehicle(new Car("2783WXY", 'E', 190, "Compacte"));
        w5.addNewVehicle(new Car("7149ZAB", 'E', 160, "Esportiu"));

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
