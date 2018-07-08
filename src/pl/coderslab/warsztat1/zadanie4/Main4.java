package pl.coderslab.warsztat1.zadanie4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj rodzaj kostki do gry :");

        String code = scan.nextLine();
        int result = RollDice(code);
        System.out.println("Wynik" + result);
    }

    static int RollDice(String code) {

        StringTokenizer token = new StringTokenizer(code, "D+-", true);

        String[] element = {"empty", "empty", "empty", "empty", "empty"};
        int numberToken = 0, x = 1, y = 0, z = 0, result = 0,
                dice = 0;

        boolean plus = false, minus = false;

        while (token.hasMoreTokens()) {
            element[numberToken] = token.nextToken();
            numberToken++;
        }
        System.out.println(Arrays.toString(element)); //test
        //ustalanie pozycji D i znaku +
        if (element[0].equals("D")) {
            x = 1;
            y = Integer.parseInt(element[1]);
        }
        if (element[1].equals("D")) {
            x = Integer.parseInt(element[0]);
            y = Integer.parseInt(element[2]);
        }
        if (element[2].equals("+")) {
            z = Integer.parseInt(element[3]);
            plus = true;
        }
        if (element[3].equals("+")) {
            z = Integer.parseInt(element[4]);
            plus = true;
        }
        if (element[2].equals("-")) {
            z = Integer.parseInt(element[3]);
            minus = true;
        }
        if (element[3].equals("-")) {
            z = Integer.parseInt(element[4]);
            minus = true;
        }
        //sumowanie rzutów kostki
        Random rand = new Random();
        for (int i = 1; i <= x; i++) {
            dice = rand.nextInt(y + 1) + 1;
            result += dice;
        }
        if (plus) {
            result += z;
        }
        if (minus) {
            result -= z;
        }
        return result;
    }
}
