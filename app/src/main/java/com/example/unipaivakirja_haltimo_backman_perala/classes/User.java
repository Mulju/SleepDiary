package com.example.unipaivakirja_haltimo_backman_perala.classes;



public class User {
    private int asetusDarkMode;
    private int asetusKieli;
    private int asetusFontSize;
    private int asetusDDMMYYYY;

    public User(int asetusDarkMode, int asetusKieli, int asetusFontSize, int asetusDDMMYYYY) {
        this.asetusDarkMode = asetusDarkMode;
        this.asetusKieli = asetusKieli;
        this.asetusFontSize = asetusFontSize;
        this.asetusDDMMYYYY = asetusDDMMYYYY;
    }

    public User() {
        this.asetusDarkMode = Constants.SYSTEM_DEFAULT;
        this.asetusKieli = Constants.LANG_FIN;
        this.asetusFontSize = Constants.FONT_SIZE_MEDIUM;
        this.asetusDDMMYYYY = Constants.DD_MM_YYYY;
    }
}

