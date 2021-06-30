package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {

    private ArrayList<Filiaal> filiaals;
    private ArrayList<Gebruiker> gebruikers;
    private Scanner scanner;

    public Database(){
        this.filiaals = new ArrayList<>();
        this.gebruikers = new ArrayList<>();
    }

    public void readWerkgever(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        scanner = new Scanner(new File(file.getAbsolutePath()));

        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(",");

            Werkgever werkgever = new Werkgever(split[0]);
            werkgever.setGebruikersnaam(split[1]);
            werkgever.setWachtwoord(split[2]);
            werkgever.setWerkgeverCode(split[3]);
            werkgever.setGeboortedatum(split[4]);
            this.addWerkgeverToList(werkgever);
        }
    }

    public void readWerknemer(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        scanner = new Scanner(new File(file.getAbsolutePath()));

        while (scanner.hasNextLine()) {

            String[] split = scanner.nextLine().split(",");
            Werknemer werknemer = new Werknemer(split[0]);
            werknemer.setGebruikersnaam(split[1]);
            werknemer.setWachtwoord(split[2]);
            werknemer.setGeboortedatum(split[3]);
            this.addWerknemerToList(werknemer);
        }
    }

    public void werknemerFileWriter(Werknemer werknemer) throws IOException{
        File file = new File("Gebruikers.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(file.getAbsolutePath(),false));

        this.addWerknemerToList(werknemer);

        pw.println(werknemer.getNaam()+ "," + werknemer.getGebruikersnaam()+ "," + werknemer.getWachtwoord()+ "," + werknemer.getGeboortedatum());
        pw.close();
    }

    public void werkgeverFileWriter(Werkgever werkgever) throws IOException {
        File file = new File("Gebruikers.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(file.getAbsolutePath(),false));

        this.addWerkgeverToList(werkgever);

        pw.println(werkgever.getNaam()+ "," + werkgever.getGebruikersnaam()+ "," + werkgever.getWachtwoord()+ "," + werkgever.getWerkgeverCode()+ "," + werkgever.getGeboortedatum());
        pw.close();
    }

    public void addWerkgeverToList(Werkgever werkgever){ gebruikers.add(werkgever);}

    public void addWerknemerToList(Werknemer werknemer){ gebruikers.add(werknemer);}

    public ArrayList<Gebruiker> getGebruikers(){ return gebruikers;}
}
