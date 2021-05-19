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
        return true;
    }

    public String soortContract(int antwoordSoortContract){
        String a = null;
        return a;
    }

    public String loon(String contractAntwoord, String werkgeverAntwoord, int filiaalAntwoord, int antwoordSoortContract){
        String a = null;
        return a;
    }
}
