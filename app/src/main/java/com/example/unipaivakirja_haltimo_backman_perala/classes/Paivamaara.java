/*
 * @(#)Asetukset 11.10.2021 versio 1.0
 *
 * Copyright ryhmä Pikakassa
 *
 */


package com.example.unipaivakirja_haltimo_backman_perala.classes;

/**
 * Tässä luokassa on toteutettu Paivamaara-olion toiminnallisuus.
 * Päivämäärä oliota käytetään Yo-olion toiminnallisuudessa.
 *
 * @version 1.0 11.10.2021
 * @author Samuli Haltimo, Sami Bäckman, Pyry Perälä
 */

public class Paivamaara {
    /** Paivamaara olion muuttujina päivä, kuukausi ja vuosi. */
    private int paiva;
    private int kuukausi;
    private int vuosi;

    /**
     * Luokan konstruktori, millä luodaan Paivamaara-olio,
     * sekä asetetaan parametrina saadut arvot olioon.
     *
     * @param paiva päiväyksen päivä
     * @param kuukausi päiväyksen kuukausi
     * @param vuosi päiväyksen vuosi
     */
    public Paivamaara(int paiva, int kuukausi, int vuosi) {
        this.paiva = paiva;
        this.kuukausi = kuukausi;
        this.vuosi = vuosi;
    }

    /**
     * Päiväyksen päivän getteri
     * @return palauttaa päivän
     */
    public int getPaiva() {
        return paiva;
    }

    /**
     * Päiväyksen kuukauden getteri
     * @return palauttaa kuukauden
     */
    public int getKuukausi() {
        return kuukausi;
    }

    /**
     * Päiväyksen vuoden getteri
     * @return palauttaa vuoden
     */
    public int getVuosi() {
        return vuosi;
    }
}
