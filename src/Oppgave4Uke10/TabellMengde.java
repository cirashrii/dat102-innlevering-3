package Oppgave4Uke10;


public class TabellMengde<T> implements MengdeADT<T> {
    private T[] mengdeTabell;
    private int n;

    public TabellMengde() {
        mengdeTabell = (T[]) new Object[1001];
        n = 0;
    }


    @Override
    public boolean erTom() {
        if (n == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean inneholder(T element) {
        for (int i = 0; i < n; i++) {
            if (mengdeTabell[i] == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        int antallElementer = 0;
        for (int i = 0; i < n; i++) {
            if (annenMengde.inneholder(mengdeTabell[i])){
                antallElementer++;
            }
        }
        if (antallElementer==n) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        if (this.n != annenMengde.antallElementer()) {
            return false;
        }
        return this.erDelmengdeAv(annenMengde);
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        for (int i = 0; i < n; i++) {
            if (annenMengde.inneholder(mengdeTabell[i])){
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> tempMengdetabell = new TabellMengde<>();

        for (int i = 0; i < n; i++) {
            if (annenMengde.inneholder(mengdeTabell[i])){
                tempMengdetabell.leggTil(mengdeTabell[i]);
            }
        }
        return tempMengdetabell;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        MengdeADT<T> tempMengdetabell = new TabellMengde<>();
        tempMengdetabell.leggTilAlleFra(this);
        tempMengdetabell.leggTilAlleFra(annenMengde);

        return tempMengdetabell;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        MengdeADT<T> tempMengdetabell = new TabellMengde<>();

        for (int i = 0; i < n; i++) {
            if (!annenMengde.inneholder(mengdeTabell[i])){
                tempMengdetabell.leggTil(mengdeTabell[i]);
            }
        }
        return tempMengdetabell;
    }

    @Override
    public void leggTil(T element) {
        if (element == null) {
            return;
        }
        if (!inneholder(element)) {
            mengdeTabell[n] = element;
            n++;
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        T[] tempMengdetabell = annenMengde.tilTabell();
        for (int i = 0; i < annenMengde.antallElementer(); i++) {
            leggTil(tempMengdetabell[i]);
        }
    }

    @Override
    public T fjern(T element) {
        if (!inneholder(element)) {
            return null;
        } else {
            for (int i = 0; i < n; i++) {
                if (mengdeTabell[i] == element) {
                    n--;
                    mengdeTabell[i] = mengdeTabell[n];
                    mengdeTabell[n] = null;
                    return element;
                }
            }
        }
        return null;
    }

    @Override
    public T[] tilTabell() {
        return mengdeTabell;
    }

    @Override
    public int antallElementer() {
        return n;
    }
}