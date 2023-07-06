package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int resztaDoWydania = 0;
        String odpowiedz;
        Kasa kasa = new Kasa();

        while (resztaDoWydania != -1) {
            System.out.println("Jaką resztę chcesz wydać? (Wpisz 0 aby wyjść)");
            odpowiedz = scanner.nextLine();
            odpowiedz = odpowiedz.replace(".", "");
            odpowiedz = odpowiedz.replace(",", "");
            resztaDoWydania = Integer.parseInt(odpowiedz);;
            kasa.wydajReszte(resztaDoWydania);
        }
    }
}
