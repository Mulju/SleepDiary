/*
 * @(#)Asetukset 11.10.2021 versio 1.0
 *
 * Copyright ryhmä Pikakassa
 *
 */


package com.example.unipaivakirja_haltimo_backman_perala.classes;

import com.example.unipaivakirja_haltimo_backman_perala.classes.Paivamaara;

/**
 * Tässä luokassa on toteutettu Yo-olion toiminnallisuus.
 * Yo-olioon tallennetaan käyttäjältä saadut arvot,
 * joiden pohjalta luodaan yksittäistä yötä kuvaava olio.
 *
 * @version 1.0 11.10.2021
 * @author Samuli Haltimo, Sami Bäckman, Pyry Perälä
 */

public class Yo {
    Paivamaara paivamaara;
    private int nukututTunnit;
    private String nahdytUnet;
    private String ennenNukkumaan;

    /**
     * Yo-luokan konstruktori.
     * @param paiva Paivamaaraa varten päivä
     * @param kuukausi Paivamaaraa varten kuukausi
     * @param vuosi Paivamaaraa varten vuosi
     * @param nukututTunnit yön aikana nukutut tunnit
     * @param nahdytUnet yön aikana nähdyt unet
     * @param ennenNukkumaan mitä käyttäjä teki ennen nukkumaan menoa
     */
    public Yo(int paiva, int kuukausi, int vuosi, int nukututTunnit, String nahdytUnet, String ennenNukkumaan){
        this.paivamaara = new Paivamaara(paiva, kuukausi, vuosi);
        this.nukututTunnit = nukututTunnit;
        this.nahdytUnet = nahdytUnet;
        this.ennenNukkumaan = ennenNukkumaan;
    }

    public Paivamaara getPaivamaara() {
        return paivamaara;
    }

    public int getNukututTunnit() {
        return nukututTunnit;
    }

    public String getNahdytUnet() {
        return nahdytUnet;
    }

    public String getEnnenNukkumaan() {
        return ennenNukkumaan;
    }

    /**
     * Tarvittiin, jotta listanäkymään tulostuu tekstiä, eikä olion osoitetta.
     * @return palauttaa yön päivämäärän tekstinä
     */
    public String toString() {
        return Integer.toString(paivamaara.getPaiva()) + "." + Integer.toString(paivamaara.getKuukausi()) + "." +
                Integer.toString(paivamaara.getVuosi());
    }
}
