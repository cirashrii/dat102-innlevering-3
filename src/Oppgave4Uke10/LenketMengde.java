package Oppgave4Uke10;
import Oppgave4Uke10.Node;

public class LenketMengde<T> implements MengdeADT<T>{
    private Node<T> start;
    private int antall;

    @Override
    public boolean erTom() {
            return antall == 0;
    }

    @Override
    public boolean inneholder(T element) {
        Node<T> denne = start;
        while (denne != null) {
            if (denne.data.equals(element)) {
                return true;
            }
            denne = denne.neste;
        }
        return false;
    }


    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        Node<T> current = start;
        while (current != null) {
            if (!annenMengde.inneholder(current.data)) {
                return false;
            }
            current = current.neste;
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        if (this.antall != annenMengde.antallElementer()) {
            return false;
        }
        return this.erDelmengdeAv(annenMengde);
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        Node<T> current = start;
        while (current != null) {
            if (annenMengde.inneholder(current.data)) {
                return false;
            }
            current = current.neste;
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        LenketMengde<T> resultat = new LenketMengde<>();
        Node<T> current = start;
        while (current != null) {
            if (annenMengde.inneholder(current.data)) {
                resultat.leggTil(current.data);
            }
            current = current.neste;
        }
        return resultat;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        LenketMengde<T> resultat = new LenketMengde<>();
        resultat.leggTilAlleFra(this);
        resultat.leggTilAlleFra(annenMengde);
        return resultat;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        LenketMengde<T> resultat = new LenketMengde<>();
        Node<T> current = start;
        while (current != null) {
            if (!annenMengde.inneholder(current.data)) {
                resultat.leggTil(current.data);
            }
            current = current.neste;
        }
        return resultat;
    }

    @Override
    public void leggTil(T element) {
        if (element == null) {
            return;
        }
        if (!inneholder(element)) {
            Node<T> ny = new Node<>(element);
            ny.neste = start;
            start = ny;
            antall++;
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        for (T element : annenMengde.tilTabell()) {
            leggTil(element);
        }
    }

    @Override
    public T fjern(T element) {
        if (element == null) return null;

        Node<T> current = start;
        Node<T> forrige = null;

        while (current != null) {
            if (current.data.equals(element)) {
                if (forrige == null) {
                    start = current.neste;
                } else {
                    forrige.neste = current.neste;
                }
                antall--;
                return current.data;
            }
            forrige = current;
            current = current.neste;
        }
        return null;
    }

    @Override
    public T[] tilTabell() {
        T[] tabell = (T[]) new Object[antall];
        Node<T> current = start;
        int i = 0;
        while (current != null) {
            tabell[i++] = current.data;
            current = current.neste;
        }
        return tabell;
    }

    @Override
    public int antallElementer() {
        return antall;
    }
}
