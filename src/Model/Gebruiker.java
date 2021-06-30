package Model;

public abstract class Gebruiker {

    private String naam;
    private String geboortedatum;
    private String contract;
    private String functionaliteit;
    private String filiaal;
    private String wachtwoord;
    private String gebruikersnaam;

    public Gebruiker (String naam){
        this.naam = naam;
    }

    public void setNaam(String naam) { this.naam = naam; }

    public void setGeboortedatum(String geboortedatum) { this.geboortedatum = geboortedatum;}

    public void setContract(String contract) { this.contract = contract; }

    public void setFunctionaliteit(String functionaliteit) { this.functionaliteit = functionaliteit; }

    public void setFiliaal(String filiaal) { this.filiaal = filiaal; }

    public void setWachtwoord(String wachtwoord) { this.wachtwoord = wachtwoord; }

    public void setGebruikersnaam(String gebruikersnaam) { this.gebruikersnaam = gebruikersnaam; }

    public String getNaam() {
        return this.naam;
    }

    public String getGeboortedatum() {
        return this.geboortedatum;
    }

    public String getContract() {
        return this.contract;
    }

    public String getFunctionaliteit() {
        return this.functionaliteit;
    }

    public String getFiliaal() { return this.filiaal; }

    public String getWachtwoord() { return wachtwoord; }

    public String getGebruikersnaam() { return gebruikersnaam; }

    public boolean toegelaten(String contractAntwoord, String werkgeverAntwoord, String filiaalAntwoord){
        return contractAntwoord.equalsIgnoreCase(contract) && werkgeverAntwoord.equalsIgnoreCase(functionaliteit) && filiaalAntwoord == filiaal;
    }

    public String soortContract(int antwoordSoortContract){
        String a = null;
        if(0 <= antwoordSoortContract && antwoordSoortContract <= 9){
            a = "all-in uurloon";
        } else if( 9 < antwoordSoortContract && antwoordSoortContract <= 15){
            a = "all-in uurloon - belasting";
        } else if(antwoordSoortContract > 15){
            a = "uurloon + vakantiegeld";
        }

        return a;
    }

    public String loon(String contractAntwoord, String werkgeverAntwoord, String filiaalAntwoord, int antwoordSoortContract){
        String a = null;
        if(contractAntwoord.equals(contract)){
            if(0 <= antwoordSoortContract && antwoordSoortContract <= 9){
                a = "all-in uurloon";
            } else if( 9 < antwoordSoortContract && antwoordSoortContract <= 15){
                a = "all-in uurloon - belasting";
            } else if(antwoordSoortContract > 15){
                a = "uurloon + vakantiegeld";
            }
        }

        return a;
    }
}
