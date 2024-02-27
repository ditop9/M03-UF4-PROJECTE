package interfaces;

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
}
