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

    public void readManager(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        scanner = new Scanner(new File(file.getAbsolutePath()));

        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(",");

            Manager manager = new Manager(split[0]);
            manager.setGebruikersnaam(split[1]);
            manager.setWachtwoord(split[2]);
            manager.setAfdeling(split[3]);
            manager.setGeboortedatum(split[4]);
            this.addManagerToList(manager);
        }
    }

    public void readShiftleader(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        scanner = new Scanner(new File(file.getAbsolutePath()));

        while (scanner.hasNextLine()) {

            String[] split = scanner.nextLine().split(",");
            Shiftleader shiftleader = new Shiftleader(split[0]);
            shiftleader.setGebruikersnaam(split[1]);
            shiftleader.setWachtwoord(split[2]);
            shiftleader.setGeboortedatum(split[3]);
            this.addShiftleaderToList(shiftleader);
        }
    }

    public void shiftleaderFileWriter(Shiftleader shiftleader) throws IOException{
        File file = new File("Gebruikers.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(file.getAbsolutePath(),false));

        this.addShiftleaderToList(shiftleader);

        pw.println(shiftleader.getNaam()+ "," + shiftleader.getGebruikersnaam()+ "," + shiftleader.getWachtwoord()+ "," + shiftleader.getGeboortedatum());
        pw.close();
    }

    public void managerFileWriter(Manager manager) throws IOException {
        File file = new File("Gebruikers.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(file.getAbsolutePath(),false));

        this.addManagerToList(manager);

        pw.println(manager.getNaam()+ "," + manager.getGebruikersnaam()+ "," + manager.getWachtwoord()+ "," + manager.getAfdeling()+ "," + manager.getGeboortedatum());
        pw.close();
    }

    public void addManagerToList(Manager manager){ gebruikers.add(manager);}

    public void addShiftleaderToList(Shiftleader shiftleader){ gebruikers.add(shiftleader);}

    public ArrayList<Gebruiker> getGebruikers(){ return gebruikers;}
}
