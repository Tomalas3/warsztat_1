package pl.coderslab.warsztat1.zadanie2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        int number = 0, counter = 0;
        int[] table = new int[6];

        String comment = new String();
        boolean theSame = false;

        do {

            System.out.println("Podaj " + (counter + 1) + " liczbe losowania [1-49]:");
            try {
                number = scan.nextInt();
                if (number < 1 || number > 49) {
                    System.out.println("! Liczba spoza zakresu ! ");
                } else {

                    for (int i = 0; i < table.length; i++) {
                        if (number == table[i]) {

                            System.out.println("Ta liczba była już typowana");
                            theSame = true;
                            i = table.length;
                        } else {
                            theSame = false;
                        }
                    }
                    if (theSame == false) {
                        table[counter] = number;
                        counter++;

                    }

                }

            } catch (InputMismatchException ex) {
                System.out.println("!!To nie jest liczba !!");
                scan.next();
            }

        } while (counter != 6);  //do tego miejsca wypełniamy tablice liczbami.

        Arrays.sort(table);
        System.out.println("Wytypowane liczby to: " + Arrays.toString(table));

        // Losowanie 6 liczb

        int volume = 6, down = 1, up = 49, hit = 0;
        boolean repeat = false;  //ustawianie powtarzalności numeru w losowaniu.
        int[] numbersLotto = numbersRandom(volume, down, up, repeat);
        Arrays.sort(numbersLotto);
        System.out.println("Wylosowane liczby to: " + Arrays.toString(numbersLotto));

        for (int i = 0; i < numbersLotto.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[j] == numbersLotto[i]) {
                    hit++;
                }
            }
        }

        if (hit >= 3) {
            System.out.println("!!! GRATULACJE !!! Twoja Liczba trafień : " + hit);
        }
    }


    static int[] numbersRandom(int numberRand, int rangeDown, int rangeUp, boolean repeat) {
        Random rand = new Random();
        int[] table = new int[numberRand];
        if ((numberRand <= rangeUp) || (repeat == true)) {  // warunek potrzebny,żeby program się nie zapętlił przy niepowtarzalności wylosowanej liczby.
            for (int i = 0; i < numberRand; i++) {
                boolean theSame = false;
                int number = rand.nextInt(rangeUp - rangeDown + 1) + rangeDown;
                // sprawdzanie powtarzalności liczby w tabeli
                for (int j = 0; ((j < table.length) && (repeat == false)); j++) {
                    if (number == table[j]) {
                        theSame = true;
                        i--;
                        break;
                    }
                }
                if (theSame == false) {
                    table[i] = number;
                }
            }
        } else {
            System.out.println("Wpisałeś złe wartości do metody."); //możnaby rzucic własnym exeptions na zewnątrz zamiast komunikatu
        }
        return table;
    }
}


