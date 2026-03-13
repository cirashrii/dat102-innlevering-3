package Oppgave4Uke10;

import java.util.HashSet;
import java.util.Set;

public class JavaSetToMengde<T> implements MengdeADT<T> {
    private Set<T> set;

    public JavaSetToMengde() {
        set = new HashSet<>();
    }

    @Override
    public boolean erTom() {
        return set.isEmpty();
    }

    @Override
    public boolean inneholder(T element) {
        return set.contains(element);
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        for (T element : set) {
            if(!annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        if (this.antallElementer() != annenMengde.antallElementer()) {
            return false;
        }
        return this.erDelmengdeAv(annenMengde);
    }


    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        for (T element : set) {
            if (annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        JavaSetToMengde<T> resultat = new JavaSetToMengde<>();
        for (T element : set) {
            if(annenMengde.inneholder(element)) {
                resultat.leggTil(element);
            }
        }
        return resultat;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        JavaSetToMengde<T> resultat = new JavaSetToMengde<>();
        resultat.leggTilAlleFra(this);
        resultat.leggTilAlleFra(annenMengde);
        return resultat;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        JavaSetToMengde<T> resultat = new JavaSetToMengde<>();
        for (T element : set) {
            if(!annenMengde.inneholder(element)) {
                resultat.leggTil(element);
            }
        }
        return resultat;
    }

    @Override
    public void leggTil(T element) {
        if (element != null) {
            set.add(element);
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        T[] tabell = annenMengde.tilTabell();
        for (int i = 0; i < annenMengde.antallElementer(); i++) {
            leggTil(tabell[i]);
        }
    }

    @Override
    public T fjern(T element) {
        if (set.contains(element)) {
            set.remove(element);
            return element;
        }
        return null;
    }

    @Override
    public T[] tilTabell() {
        T[] tabell = (T[]) new Object[set.size()];
        int i = 0;
        for (T element : set) {
            tabell[i++] = element;
        }
        return tabell;
    }

    @Override
    public int antallElementer() {
        return set.size();
    }
}
