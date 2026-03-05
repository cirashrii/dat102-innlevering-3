import Oppgave4Uke10.TabellMengde;
import Oppgave4Uke10.MengdeADT;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TabellMengdeTest {

    @Test
    public void sjekkOmIkkeInneholderElementer() {
        MengdeADT<Integer> tomTabell = new TabellMengde<Integer>();
        assertTrue(tomTabell.erTom());
    }

    @Test
    void sjekkLeggTilOgInneholder() {
        MengdeADT<Integer> m = new TabellMengde<>();
        m.leggTil(1);
        m.leggTil(2);
        m.leggTil(2);

        assertTrue(m.inneholder(1));
        assertTrue(m.inneholder(2));
        assertFalse(m.inneholder(4));
    }

    @Test
    void sjekkAntallElementer() {
        MengdeADT<Integer> m = new TabellMengde<>();
        m.leggTil(1);
        m.leggTil(2);
        m.leggTil(2);

        assertEquals(2, m.antallElementer());
    }

    @Test
    void sjekkDelmengdeAv() {
        MengdeADT<Integer> m1 = new TabellMengde<>();
        m1.leggTil(1);
        m1.leggTil(2);
        m1.leggTil(3);

        MengdeADT<Integer> m2 = new TabellMengde<>();
        m2.leggTil(1);
        m2.leggTil(2);
        m2.leggTil(3);
        m2.leggTil(4);

        assertTrue(m1.erDelmengdeAv(m2));
    }

    @Test
    void sjekkDelmengdeAvEtterForsteElement() {
        MengdeADT<Integer> m1 = new TabellMengde<>();
        m1.leggTil(2);
        m1.leggTil(3);

        MengdeADT<Integer> m2 = new TabellMengde<>();
        m2.leggTil(1);
        m2.leggTil(2);
        m2.leggTil(3);
        m2.leggTil(4);

        assertTrue(m1.erDelmengdeAv(m2));
    }

    @Test
    void sjekkErIkkeDelmengdeAv() {
        MengdeADT<Integer> m1 = new TabellMengde<>();
        m1.leggTil(1);
        m1.leggTil(2);
        m1.leggTil(3);

        MengdeADT<Integer> m2 = new TabellMengde<>();
        m2.leggTil(1);
        m2.leggTil(2);
        m2.leggTil(3);
        m2.leggTil(4);
        m2.leggTil(5);

        assertFalse(m2.erDelmengdeAv(m1));
    }

    @Test
    void sjekkMengderErLike() {
        MengdeADT<Integer> m1 = new TabellMengde<>();
        m1.leggTil(1);
        m1.leggTil(2);
        m1.leggTil(3);

        MengdeADT<Integer> m2 = new TabellMengde<>();
        m2.leggTil(1);
        m2.leggTil(2);
        m2.leggTil(3);

        assertTrue(m1.erLik(m2));
    }

    @Test
    void sjekkMengderErIkkeLike() {
        MengdeADT<Integer> m1 = new TabellMengde<>();
        m1.leggTil(1);
        m1.leggTil(2);

        MengdeADT<Integer> m2 = new TabellMengde<>();
        m2.leggTil(1);
        m2.leggTil(2);
        m2.leggTil(3);

        assertFalse(m1.erLik(m2));
    }

    @Test
    void sjekkMengderErDisjunkte() {
        MengdeADT<Integer> m1 = new TabellMengde<>();
        m1.leggTil(1);
        m1.leggTil(2);
        m1.leggTil(3);

        MengdeADT<Integer> m2 = new TabellMengde<>();
        m2.leggTil(4);
        m2.leggTil(5);
        m2.leggTil(6);

        assertTrue(m1.erDisjunkt(m2));
    }

    @Test
    void sjekkMengdeErIkkeDisjunkte() {
        MengdeADT<Integer> m1 = new TabellMengde<>();
        m1.leggTil(1);
        m1.leggTil(2);
        m1.leggTil(3);

        MengdeADT<Integer> m2 = new TabellMengde<>();
        m2.leggTil(3);
        m2.leggTil(4);
        m2.leggTil(5);

        assertFalse(m1.erDisjunkt(m2));
    }


    @Test
    void sjekkSnitt1() {
        MengdeADT<Integer> m1 = new TabellMengde<>();
        m1.leggTil(2);
        m1.leggTil(3);

        MengdeADT<Integer> m2 = new TabellMengde<>();
        m2.leggTil(1);
        m2.leggTil(2);
        m2.leggTil(3);
        m2.leggTil(4);
        m2.leggTil(5);

        MengdeADT<Integer> m3 = m1.snitt(m2);
        assertFalse(m3.inneholder(1));
        assertTrue(m3.inneholder(2));
        assertTrue(m3.inneholder(3));
        assertFalse(m3.inneholder(4));
        assertFalse(m3.inneholder(5));
    }

    @Test
    void sjekkSnitt2() {
        MengdeADT<Integer> m1 = new TabellMengde<>();
        m1.leggTil(1);
        m1.leggTil(2);
        m1.leggTil(3);

        MengdeADT<Integer> m2 = new TabellMengde<>();
        m2.leggTil(2);
        m2.leggTil(3);
        m2.leggTil(4);
        m2.leggTil(5);

        MengdeADT<Integer> m3 = m1.snitt(m2);
        assertFalse(m3.inneholder(1));
        assertTrue(m3.inneholder(2));
        assertTrue(m3.inneholder(3));
        assertFalse(m3.inneholder(4));
        assertFalse(m3.inneholder(5));
    }
}
