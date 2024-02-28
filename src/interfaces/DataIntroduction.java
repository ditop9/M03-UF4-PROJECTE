package interfaces;

import app.App;
import location.Concessionaire;
import location.Workshop;

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
        System.out.println("INTRODUEIX:\n1. TRUE\n2. FALSE");
        int num = introduceInteger();
        if (num == 1) {
            return true;
        } else if (num == 2) {
            return false;
        }
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

        Workshop w1 = new Workshop("Barcelona", "Spain", 15, "Taller del Motor");
        Workshop w2 = new Workshop("Madrid", "Spain", 20, "Mechanical Masters");
        Workshop w3 = new Workshop("Lyon", "France", 12, "Speedy Fix");
        Workshop w4 = new Workshop("Milan", "Italy", 18, "Car Care Center");
        Workshop w5 = new Workshop("Berlin", "Germany", 22, "Auto Tech");

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
