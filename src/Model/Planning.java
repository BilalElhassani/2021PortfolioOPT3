package Model;

public class Planning {

    private int collies;
    private int medewerkers;
    private double aantalMinuten;
    private double eindtijd;

    public Planning (){};

    public void setCollies(int collies) { this.collies = collies; }

    public void setMedewerkers(int medewerkers) { this.medewerkers = medewerkers; }

    public double berekenEindTijd(int collies, int medewerkers){
        aantalMinuten = collies * 2.0;
        eindtijd= (360 + (aantalMinuten / medewerkers)) / 60;
        return eindtijd;
    }

    public double getEindtijd() {
        return eindtijd;
    }
}
