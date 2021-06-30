package Model;

public class Werkgever extends Gebruiker {

    private String werkgeverCode;

    public Werkgever(String naam) {
        super(naam);
    }

    public void setWerkgeverCode(String werkgeverCode) { this.werkgeverCode = werkgeverCode; }

    public String getWerkgeverCode() { return this.werkgeverCode; }
}
