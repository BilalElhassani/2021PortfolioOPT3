package Model;

public abstract class Gebruiker {

    private String naam;
    private String geboortedatum;
    private String filiaal;
    private String wachtwoord;
    private String gebruikersnaam;

    public Gebruiker (String naam){
        this.naam = naam;
    }

    public void setNaam(String naam) { this.naam = naam; }

    public void setGeboortedatum(String geboortedatum) { this.geboortedatum = geboortedatum;}

    public void setFiliaal(String filiaal) { this.filiaal = filiaal; }

    public void setWachtwoord(String wachtwoord) { this.wachtwoord = wachtwoord; }

    public void setGebruikersnaam(String gebruikersnaam) { this.gebruikersnaam = gebruikersnaam; }

    public String getNaam() {
        return this.naam;
    }

    public String getGeboortedatum() {
        return this.geboortedatum;
    }

    public String getFiliaal() { return this.filiaal; }

    public String getWachtwoord() { return wachtwoord; }

    public String getGebruikersnaam() { return gebruikersnaam; }
}
