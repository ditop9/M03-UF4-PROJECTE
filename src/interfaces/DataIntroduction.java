package interfaces;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface DataIntroduction {
    static int introduceOption() {
        Scanner sc = new Scanner(System.in);
        int num = -1;
        try {
            num = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR: NO ÉS UNA OPCIÓ VÀLIDA");
        }
        return num;
    }
}
