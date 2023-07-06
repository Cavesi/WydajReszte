package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Kasa {
    ArrayList<Integer> nominaly = new ArrayList<>(List.of(500, 200, 100, 50, 20, 10, 5, 2, 1));
    HashMap<Integer, Integer> monety = new HashMap<>();
    HashMap<Integer, Integer> monetyDoWydania = new HashMap<>();

    public Kasa() {
        this.napelnijKase();
    }

    public void napelnijKase() {
        monety.put(500, 1);
        monety.put(200, 3);
        monety.put(100, 5);
        monety.put(50, 10);
        monety.put(20, 20);
        monety.put(10, 200);
        monety.put(5, 100);
        monety.put(2, 100);
        monety.put(1, 10000);
    }

    public void wydajReszte(int iloscDoWydania) {

        monetyDoWydania.clear();

        if (iloscDoWydania < 0) {
            System.out.println("Kwota do wydania nie może być ujemna.");
            return;
        }

        for (Integer nominal : nominaly) {
            while (czyMoznaWydac(iloscDoWydania, nominal)) {
                monety.put(nominal, monety.get(nominal) - 1);
                int ileMonet = monetyDoWydania.getOrDefault(nominal, 0);
                monetyDoWydania.put(nominal, ileMonet + 1);
                iloscDoWydania -= nominal;
            }
        }

        if (iloscDoWydania != 0) {
            System.out.println("Nie ma wystarczająco dużo monet.");
        } else {
            System.out.println("Do wydania:");

            for (Integer nominal : nominaly) {
                int ileMonet = monetyDoWydania.getOrDefault(nominal, 0);

                if (nominal >= 100 && ileMonet > 0) {
                    System.out.println("Do wydania " + monetyDoWydania.get(nominal) + " " + monetaMonetyczyMonet(ileMonet) + " o nominale " + nominal / 100 + " zł.");
                    continue;
                }
                if (ileMonet > 0) {
                    System.out.println("Do wydania " + monetyDoWydania.get(nominal) + " " + monetaMonetyczyMonet(ileMonet) + " o nominale " + nominal + " groszy.");
                }
            }


        }
    }


    public String monetaMonetyczyMonet(int monety) {
        if (monety == 1) {
            return "moneta";
        }
        if (monety % 10 == 2 || monety % 10 == 3 || monety % 10 == 4) {
            return "monety";
        }
        return "monet";
    }

    public boolean czyMoznaWydac(int iloscDoWydania, int moneta) {
        return (iloscDoWydania >= moneta && monety.get(moneta) > 0);
    }


}

