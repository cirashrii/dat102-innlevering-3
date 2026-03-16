package Oppgave4Uke11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Integer[] eksempelTabell = opprettTabell();
        Arrays.sort(eksempelTabell);
        Set<Integer> eksempelHashSet = new HashSet<>();
        eksempelHashSet.addAll(Arrays.asList(eksempelTabell));

        boolean sjekkOmSetOgTabellErLik = eksempelHashSet.equals(new HashSet<>(Arrays.asList(eksempelTabell)));
        System.out.println("Hash og tabell er lik = " + sjekkOmSetOgTabellErLik);

//        for(int i = 0; i < eksempelTabell.length; i++) {
//            System.out.print(eksempelTabell[i] + ", ");
//        }
//
//        System.out.println("\n\n\nHASHSET STARTER HER\n");
//
//        for (Integer a: eksempelHashSet) {
//            System.out.print(a + ", ");
//        }

    }

    public static Integer[] opprettTabell() {
        int tall = 376;

        Integer[] tabell = new Integer[100000];
        for (int i = 0; i < tabell.length; i++) {
            tabell[i] = tall;
            tall = (tall + 45713) % 1000000;
        }
        return tabell;
    }

}

// TODO
// Lage en sett med metoder (eller ta det direkte i main) som inkluderer blant annet:
// Opprettelse av tabell
// Størrelse 100 000, og kan inkludere tall mellom 0 og 999 999 (bruk random)
// Der hver verdi er unik
// Og alt skal være sortert (bruk ferdiglagd metode til dette)
// Også skal det overføres til en hashset

// Deretter, når det er ferdig, skal vi kjøre søking og binærsøking ved bruk av desse tabellene
// Også analysere kjøretid ved IntelliJ sin innebygde greier (må dobbelsjekke navnet)
