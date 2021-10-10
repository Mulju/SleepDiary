package com.example.unipaivakirja_haltimo_backman_perala.classes;


import java.util.ArrayList;

public class User {
    private static final User ourInstance = new User();
    private int asetusDarkMode;
    private int asetusKieli;
    private int asetusFontSize;
    private int asetusDDMMYYYY;
    YoData data;

    private User() {
        this.data = YoData.getInstance();
        this.asetusDarkMode = Constants.SYSTEM_DEFAULT;
        this.asetusKieli = Constants.LANG_FIN;
        this.asetusFontSize = Constants.FONT_SIZE_MEDIUM;
        this.asetusDDMMYYYY = Constants.DD_MM_YYYY;
    }

    public static User getInstance() {
        return ourInstance;
    }

    public int getAsetusDarkMode() {
        return asetusDarkMode;
    }

    public void setAsetusDarkMode(int asetusDarkMode) {
        this.asetusDarkMode = asetusDarkMode;
    }

    public int getAsetusKieli() {
        return asetusKieli;
    }

    public void setAsetusKieli(int asetusKieli) {
        this.asetusKieli = asetusKieli;
    }

    public int getAsetusFontSize() {
        return asetusFontSize;
    }

    public void setAsetusFontSize(int asetusFontSize) {
        this.asetusFontSize = asetusFontSize;
    }

    public int getAsetusDDMMYYYY() {
        return asetusDDMMYYYY;
    }

    public void setAsetusDDMMYYYY(int asetusDDMMYYYY) {
        this.asetusDDMMYYYY = asetusDDMMYYYY;
    }

    public void haeYot(){
        data.getYot();
    }


}

