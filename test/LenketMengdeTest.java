import Oppgave4Uke10.LenketMengde;
import Oppgave4Uke10.MengdeADT;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LenketMengdeTest {
    @Test
    void testLeggTilOgInneholder() {
        LenketMengde<Integer> m = new LenketMengde<>();
        m.leggTil(1);
        m.leggTil(2);
        m.leggTil(2);

        assertTrue(m.inneholder(1));
        assertTrue(m.inneholder(2));
        assertEquals(2, m.antallElementer());
    }

    @Test
    void testUnion() {
        LenketMengde<Integer> m1 = new LenketMengde<>();
        LenketMengde<Integer> m2 = new LenketMengde<>();

        m1.leggTil(1);
        m1.leggTil(2);

        m2.leggTil(2);
        m2.leggTil(3);

        MengdeADT<Integer> union = m1.union(m2);

        assertEquals(3, union.antallElementer());
        assertTrue(union.inneholder(1));
        assertTrue(union.inneholder(2));
        assertTrue(union.inneholder(3));
    }

    @Test
    void testSnitt() {
        LenketMengde<Integer> m1 = new LenketMengde<>();
        LenketMengde<Integer> m2 = new LenketMengde<>();

        m1.leggTil(1);
        m1.leggTil(2);

        m2.leggTil(2);
        m2.leggTil(3);

        MengdeADT<Integer> snitt = m1.snitt(m2);

        assertEquals(1, snitt.antallElementer());
        assertTrue(snitt.inneholder(2));
    }

    @Test
    void testMinus() {
        LenketMengde<Integer> m1 = new LenketMengde<>();
        LenketMengde<Integer> m2 = new LenketMengde<>();

        m1.leggTil(1);
        m1.leggTil(2);
        m1.leggTil(3);

        m2.leggTil(2);

        MengdeADT<Integer> minus = m1.minus(m2);

        assertEquals(2, minus.antallElementer());
        assertFalse(minus.inneholder(2));
    }

    @Test
    void testFjern() {
        LenketMengde<Integer> m = new LenketMengde<>();
        m.leggTil(1);
        m.leggTil(2);

        assertEquals(1, m.fjern(1));
        assertFalse(m.inneholder(1));
        assertEquals(1, m.antallElementer());
    }
}
