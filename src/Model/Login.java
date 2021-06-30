package Model;

import java.io.FileNotFoundException;

public class Login {

    private static Login singleton = null;
    private final Database dbs;
    private Gebruiker loggedInGebruiker;

    private Login() throws FileNotFoundException{
        this.dbs = new Database();
        dbs.readWerkgever("Gebruikers.txt");
        dbs.readWerknemer("Gebruikers.txt");
        loggedInGebruiker = null;
    }

    public static Login getInstance() throws FileNotFoundException {
        if(singleton == null){
            return singleton = new Login();
        }
        return singleton;
    }

    public boolean loginCheck(String gebruikersnaam, String wachtwoord){
        for (Gebruiker gebruiker: dbs.getGebruikers()){
            if(gebruikersnaam.equals(gebruiker.getGebruikersnaam()) && wachtwoord.equals(gebruiker.getWachtwoord())){
                loggedInGebruiker = gebruiker;
                return true;
            }
        }
        return false;
    }

    public boolean registerCheck(String gebruikersnaam) {
        for (Gebruiker gebruiker: dbs.getGebruikers()) {
            if(gebruikersnaam.equals(gebruiker.getGebruikersnaam()) ){
                return true;
            }
        }
        return false;
    }

    public Database getDbs() {
        return dbs;
    }

    public Gebruiker getGebruiker(){
        return loggedInGebruiker;
    }

    public void logout(){
        loggedInGebruiker = null;
    }

    public void setGebruiker(Gebruiker gebruiker){
        this.loggedInGebruiker = gebruiker;
    }
}
