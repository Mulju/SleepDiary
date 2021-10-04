package com.example.unipaivakirja_haltimo_backman_perala.classes;

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

    public int getKuukausi() {
        return kuukausi;
    }

    public int getVuosi() {
        return vuosi;
    }
}
