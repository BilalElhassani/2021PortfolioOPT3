package Model;

public class Manager extends Gebruiker {

    private String afdeling;

    public Manager(String naam) {
        super(naam);
    }

    public void setAfdeling(String afdeling) { this.afdeling = afdeling; }

    public String getAfdeling() { return this.afdeling; }
}
