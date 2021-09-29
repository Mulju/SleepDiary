package com.example.unipaivakirja_haltimo_backman_perala;

public class Paivamaara {
    private int paiva;
    private int kuukausi;
    private int vuosi;

    public Paivamaara(int paiva, int kuukausi, int vuosi) {
        this.paiva = paiva;
        this.kuukausi = kuukausi;
        this.vuosi = vuosi;
    }

    public int getPaiva() {
        return paiva;
    }

    public void setPaiva(int paiva) {
        this.paiva = paiva;
    }

    public int getKuukausi() {
        return kuukausi;
    }

    public void setKuukausi(int kuukausi) {
        this.kuukausi = kuukausi;
    }

    public int getVuosi() {
        return vuosi;
    }

    public void setVuosi(int vuosi) {
        this.vuosi = vuosi;
    }
}
