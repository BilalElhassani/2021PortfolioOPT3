public class Werkgever extends Gebruiker{

    private int werkgeverCode;

    public Werkgever(String naam, String geboortedatum, String contract, String functionaliteit, int filiaal, int werkgeverCode) {
        super(naam, geboortedatum, contract, functionaliteit, filiaal);
        this.werkgeverCode = werkgeverCode;
    }

    public int getWerkgeverCode() {
        return this.werkgeverCode;
    }
}
