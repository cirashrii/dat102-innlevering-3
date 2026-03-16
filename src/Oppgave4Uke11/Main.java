package Oppgave4Uke11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Integer[] eksempelTabell = opprettTabell();
        Integer[] finnTabell = new Integer[10000];
        for (int i = 0; i < finnTabell.length; i++) {
            finnTabell[i] = eksempelTabell[i];
        }
        Arrays.sort(eksempelTabell);
        Set<Integer> eksempelHashSet = new HashSet<>(Arrays.asList(eksempelTabell));

        boolean sjekkOmSetOgTabellErLik = eksempelHashSet.equals(new HashSet<>(Arrays.asList(eksempelTabell)));
        System.out.println("Hash og tabell er lik = " + sjekkOmSetOgTabellErLik);

        int count = 0;
        long start = System.nanoTime();
        for(int i = 0; i < finnTabell.length; i++) {
            if (eksempelHashSet.contains(finnTabell[i])) {
                count++;
            }
        }
        long slutt = System.nanoTime();
        long totalNano = slutt - start;
        double gjennomsnittMs = totalNano / 1_000_000.0;
        if (count == 10000) {
            System.out.println("Alle elementer funnet i HashSet.");
            System.out.println("Totaltid: " + gjennomsnittMs + " ms");
        }

        System.out.println();

        start = System.nanoTime();
        for(int i = 0; i < finnTabell.length; i++) {
            Arrays.binarySearch(eksempelTabell,finnTabell[i]);
        }
        slutt = System.nanoTime();
        totalNano = slutt - start;
        gjennomsnittMs = totalNano / 1_000_000.0;
        System.out.println("Alle elementer funnet i Tabell via binary search.");
        System.out.println("Totaltid: " + gjennomsnittMs + " ms");

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
