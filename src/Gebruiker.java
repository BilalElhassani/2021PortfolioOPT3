public class Gebruiker {

    private String contract;
    private String werkgever;
    private int filiaal;

    public Gebruiker (String contract, String werkgever, int filiaal){
        this.contract = contract;
        this.werkgever = werkgever;
        this.filiaal = filiaal;
    }

    public boolean toegelaten(String contractAntwoord, String werkgeverAntwoord, int filiaalAntwoord){
        return contractAntwoord.equalsIgnoreCase(contract) && werkgeverAntwoord.equalsIgnoreCase(werkgever) && filiaalAntwoord == filiaal;
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
        return a;
    }
}
