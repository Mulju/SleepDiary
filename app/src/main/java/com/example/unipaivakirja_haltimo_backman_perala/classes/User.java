/*
 * @(#)Asetukset 11.10.2021 versio 1.0
 *
 * Copyright ryhmä Pikakassa
 *
 */


package com.example.unipaivakirja_haltimo_backman_perala.classes;

/**
 * Tässä Singleton luokassa on toteutettu User-olion toiminnallisuus.
 * User-oliota olisi käytetty asetusten tallentamiseen ja lukemiseen ajon aikana,
 * jotta ei kuormitettaisi järjestelmää hakemalla shared preferenseistä koko ajan tietoa.
 *
 * Singleton luokan tapaan, luokasta on vain yksi olio.
 *
 * @version 1.0 11.10.2021
 * @author Samuli Haltimo, Sami Bäckman, Pyry Perälä
 */

public class User {
    /** Singleton luokan tapaan, luodaan vain yksi olio, siksi final. */
    private static final User ourInstance = new User();
    /** Kullekkin asetukselle oma muuttuja, johon talletetaan haluttu valinta. */
    private int asetusDarkMode;
    private int asetusKieli;
    private int asetusFontSize;
    private int asetusDDMMYYYY;

    /** Userin konstruktori, missä asetetaan asetusten arvot oletusarvoihin. */
    private User() {
        this.asetusDarkMode = Constants.SYSTEM_DEFAULT;
        this.asetusKieli = Constants.LANG_FIN;
        this.asetusFontSize = Constants.FONT_SIZE_MEDIUM;
        this.asetusDDMMYYYY = Constants.DD_MM_YYYY;
    }

    /**
     * Singletonin getteri.
     * @return palauttaa singleton olion.
     */
    public static User getInstance() {
        return ourInstance;
    }

    /**
     * DarkMode-asetuksen getteri.
     * @return palauttaa DarkModen tämän hetkisen valinnan
     */
    public int getAsetusDarkMode() {
        return asetusDarkMode;
    }

    /**
     * DarkMode-asetuksen setteri.
     * Tällä asetetaan asetuksen arvo.
     */
    public void setAsetusDarkMode(int asetusDarkMode) {
        this.asetusDarkMode = asetusDarkMode;
    }

    /**
     * Kieli-asetuksen getteri.
     * @return palauttaa Kieli asetuksen arvon.
     */
    public int getAsetusKieli() {
        return asetusKieli;
    }

    /**
     * Kieli-asetuksen setteri.
     * Tällä asetetaan asetuksen arvo.
     */
    public void setAsetusKieli(int asetusKieli) {
        this.asetusKieli = asetusKieli;
    }

    /**
     * Fontti koon getteri.
     * @return palauttaa asetuksen arvon
     */
    public int getAsetusFontSize() {
        return asetusFontSize;
    }

    /**
     * Fontti koon setteri.
     * Tällä asetetaan asetuksen arvo.
     */
    public void setAsetusFontSize(int asetusFontSize) {
        this.asetusFontSize = asetusFontSize;
    }

    /**
     * Päivämäärän muotoilun getteri
     * @return palauttaa asetuksen arvon
     */
    public int getAsetusDDMMYYYY() {
        return asetusDDMMYYYY;
    }

    /**
     * Päivämäärän muotoilun setteri.
     * Tällä asetetaan asetuksen arvo.
     */
    public void setAsetusDDMMYYYY(int asetusDDMMYYYY) {
        this.asetusDDMMYYYY = asetusDDMMYYYY;
    }
}

