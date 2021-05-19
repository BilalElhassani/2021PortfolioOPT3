public class Gebruiker {

    private String naam;
    private String geboortedatum;
    private String contract;
    private String functionaliteit;
    private int filiaal;

    public Gebruiker (String naam, String geboortedatum, String contract, String functionaliteit, int filiaal){
        this.naam = naam;
        this.geboortedatum = geboortedatum;
        this.contract = contract;
        this.functionaliteit = functionaliteit;
        this.filiaal = filiaal;
    }

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

    public int getFiliaal() {
        return this.filiaal;
    }

    public boolean toegelaten(String contractAntwoord, String werkgeverAntwoord, int filiaalAntwoord){
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

    public String loon(String contractAntwoord, String werkgeverAntwoord, int filiaalAntwoord, int antwoordSoortContract){
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
