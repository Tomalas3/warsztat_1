package pl.coderslab.warsztat1.zadanie1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Random rand = new Random();
        int numberRandom = rand.nextInt(100) + 1;
        int number = 0, result = 2, counter = 0;
        String comment = new String();
        do {
            System.out.println("Podaj liczbę całkowitą [1-100]:");
            try {

                number = scan.nextInt();
                result = checkNumberRandom(number, numberRandom);
                counter++;

                if (result == -1) {
                    comment = "Za mało";
                }
                if (result == 1) {
                    comment = "Za dużo";
                }
                if (result == 0) {
                    comment = "!!! Brawo trafiłeś w " + counter + " próbach !!! To liczba: " + numberRandom;
                }
                System.out.println(comment);
            } catch (InputMismatchException ex) {
                System.out.println("!!To nie jest liczba !!");

                scan.next();
            }

        } while (result != 0);

    }

    static int checkNumberRandom(int number, int random) {
        //program do sprawdzenia wylosowanej liczby (zwraca:-1 za mała, 0 trafiony, 1 za duza
        int result = 2;
        if (number < random) {
            result = -1;
        } else if (number > random) {
            result = 1;
        } else {
            result = 0;
        }

        return result;
    }
}
































































































