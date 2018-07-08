package pl.coderslab.warsztat1.zadanie3;

import java.util.Scanner;


public class Main3 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String word = "";
        System.out.println("Pomyśl liczbę 0-1000 a ja ją znajdę w max.10 próbach");

        while ((!word.equals("start")) && (!word.equals("s"))) {  //Sprawdzanie czy użytkownik wpisał 'start'
            System.out.println("Wpisz 'start' lub 's' ,żeby zacząć");
            word = scan.next();
        }

        int min = 0, max = 1000;
        boolean end = false, honest = true;
        int counter = 1, quess = 0;
        int checkMin = 0, checkMax = 1000;
        quess = ((max - min) / 2) + min;

        do {                    // sprawdzanie liczby
            boolean exit = false;

            System.out.println("Zgaduję: " + quess);

            do {               //sprawdzanie poprawności wprowadzonych znaków
                System.out.println("Napisz za: ('dużo'-'d') , ('mało'-'m'), ('zgadłeś'-'z') ");
                word = scan.next();
                if ((word.equals("dużo")) || (word.equals("d"))) {
                    checkMax = quess;
                    max = quess;
                    exit = true;
                    counter++;
                }
                if ((word.equals("mało")) || (word.equals("m"))) {
                    checkMin = quess;  //checkMax, checkMin - zmienna do sprawdzania powtarzalności zakresu, czy użytkownik nie oszukuje
                    min = quess;
                    exit = true;
                    counter++;
                }
                if ((word.equals("zgadłeś")) || (word.equals("z"))) {
                    exit = true;
                    end = true;
                }
            } while (exit == false);

            quess = ((max - min) / 2) + min;  //sprawdzanie na końcu,żeby program nie zrobił kolejnej pętli dla honest=false.
            if ((quess >= checkMax) || (quess <= checkMin)) {  //sprawdzanie czy użytkownik nie oszukuje
                end = true;
                honest = false;
            }

        } while (end == false);

        if (honest == true) {
            System.out.println("Zgadłem w " + counter + " próbach");
        } else {
            System.out.println("!!Oszukiwałeś!!");
        }
    }


}
