package Model;

import java.util.ArrayList;

public class Bedrijf {

    private String naam;
    private ArrayList<Filiaal> filiaals;

    public Bedrijf(String naam, ArrayList<Filiaal> filiaals){
        this.naam = naam;
        this.filiaals= filiaals;
    }

    public String getNaam() {
        return this.naam;
    }

    public ArrayList<Filiaal> getFiliaals() {
        return this.filiaals;
    }
}
