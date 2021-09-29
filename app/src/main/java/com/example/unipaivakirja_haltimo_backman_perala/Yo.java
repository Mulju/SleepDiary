package com.example.unipaivakirja_haltimo_backman_perala;

public class Yo {
    Paivamaara paivamaara;
    private int nukututTunnit;
    private String nahdytUnet;
    private String ennenNukkumaan;

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
}
