package Model;

import java.util.ArrayList;

public class Filiaal {

    private String naam;
    private Integer filiaalcode;
    private String adres;
    private ArrayList<Gebruiker> gebruikers;

    public Filiaal(String naam, Integer filiaalcode, String adres){
        this.naam = naam;
        this.filiaalcode = filiaalcode;
        this.adres = adres;
    }

    public String getNaam() {
        return this.naam;
    }

    public Integer getFiliaalcode() {
        return this.filiaalcode;
    }

    public String getAdres() {
        return this.adres;
    }

    public ArrayList<Gebruiker> getGebruikers() {
        return this.gebruikers;
    }

    public void addGebruiker(){

    }
}
