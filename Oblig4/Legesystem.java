import java.util.*;
import java.io.*;

public class Legesystem{
    // Opprett lister som lagrer objektene i legesystemet
    public static Lenkeliste<Pasient> pasienter;
    public static Lenkeliste<Legemiddel> legemidler;
    public static Lenkeliste<Lege> leger;
    public static Lenkeliste<Resept> resepter;

    public static void main(String[] args){
      //Lenke
    }
    public static void lesFraFil(File fil){
        pasienter = new Lenkeliste<Pasient>();
        legemidler = new Lenkeliste<Legemiddel>();
        leger = new Lenkeliste<Lege>();
        resepter = new Lenkeliste<Resept>();

        Scanner scanner = null;
        try{
            scanner = new Scanner(fil);
        }catch(FileNotFoundException e){
            System.out.println("Fant ikke filen, starter opp som et tomt Legesystem");
            return;
        }
        String innlest = scanner.nextLine();
        while(scanner.hasNextLine()){

            String[] info = innlest.split(" ");
            // Legger til alle pasientene i filen
            if(info[1].compareTo("Pasienter") == 0){
                while(scanner.hasNextLine()) {
                    innlest = scanner.nextLine();
                    if(innlest.charAt(0) == '#'){
                      break;
                    }
                    String[] inf = innlest.split(", ");
                    pasienter.leggTil(new Pasient(inf[0], inf[1]));
                }
            }
            //Legger inn Legemidlene
            else if(info[1].compareTo("Legemidler") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    if(innlest.charAt(0) == '#'){
                        break;
                    }
                    String[] legemiddel = innlest.split(", ");
                    if(legemiddel[1].compareTo("a") == 0) {
                        double prs = Double.parseDouble(legemiddel[2]);
                        double vs = Double.parseDouble(legemiddel[3]);
                        int srk = Integer.parseInt(legemiddel[4]);
                        legemidler.leggTil(new PreparatA(legemiddel[0], prs, vs, srk));
                    }
                    else if(legemiddel[1].compareTo("b") == 0){
                        double prs = Double.parseDouble(legemiddel[2]);
                        double vs = Double.parseDouble(legemiddel[3]);
                        int srk = Integer.parseInt(legemiddel[4]);
                        legemidler.leggTil(new PreparatB(legemiddel[0], prs, vs, srk));
                    }else if (legemiddel[1].compareTo("c") == 0){
                        double prs = Double.parseDouble(legemiddel[2]);
                        double vs = Double.parseDouble(legemiddel[3]);
                        legemidler.leggTil(new PreparatC(legemiddel[0], prs, vs));
                    }
                }
            }
            //Legger inn leger
            else if(info[1].compareTo("Leger") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    if(innlest.charAt(0) == '#'){
                        break;
                    }
                    info = innlest.split(", ");
                    int kontrollid = Integer.parseInt(info[1]);
                    if(kontrollid == 0){
                        leger.leggTil(new Lege(info[0]));
                    }else{
                        leger.leggTil(new Spesialist(info[0], kontrollid));
                    }
                }

            }
            //Legger inn Resepter
            else if(info[1].compareTo("Resepter") == 0){
                while(scanner.hasNextLine()){
                    innlest = scanner.nextLine();
                    if(innlest.charAt(0) == '#'){
                        break;
                    }
                    info = innlest.split(", ");
                    int index = Integer.parseInt(info[0]);
                    Lege lege = null;
                    Pasient pasient = null;
                    for (int i=0; i<leger.stoerrelse(); i++) {
                        Lege legeTest = leger.hent(i);
                        if (info[1].compareTo(legeTest.hentNavn()) == 0) {
                            lege = leger.hent(i);
                            break;
                        }
                    }
                    for (int i=0; i<pasienter.stoerrelse(); i++) {
                        Pasient pasientTest = pasienter.hent(i);
                        String id = Integer.toString(pasientTest.getID());
                        //int pasID = Integer.parseInt(info[2]);
                        if (info[2].compareTo(id) == 0) {
                            pasient = pasienter.hent(i);
                            break;
                        }
                    }
                    int reit = Integer.parseInt(info[3]);
                    try {
                        resepter.leggTil(lege.skrivResept(legemidler.hent(index), pasient, reit));
                    } catch(UlovligUtskrift e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
    public void skrivMeny(){
        System.out.println();
        System.out.println("--- MENY ---");
        System.out.println("1: Fullstending oversikt");
        System.out.println("2: Opprett eller legg til nye elementer");
        System.out.println("3: Bruk resept");
        System.out.println("4: Statistikk for nerder");
        //System.out.println("5: Skriv all data til fil");
        System.out.println("9: Avslutt");
        System.out.println("0: Meny");
        System.out.println();
    }

    public String errorMsg() {
        return "Error: Input has to be an integer.";
    }

    public void kommandoloekke() {
        Scanner scanner = new Scanner(System.in);
        skrivMeny();
        int valg;
        do {
            System.out.print("Valg: ");
            valg = scanner.nextInt();
            /*try {
                valg = scanner.nextInt();
            } catch(NumberFormatException e) {
                e.errorMsg();
            }*/
            switch(valg) {
                case 1: System.out.println("Fullstending oversikt.");
                        skrivUt();  break;
                case 2: System.out.println("Opprett eller legg til nye elemeter.");
                        endreTing(); break;
                case 3: System.out.println("Bruker resept.");
                        brukResept(); break;
                case 4: System.out.println("Statistikk for nerder.");
                        statistikk(); break;
                case 9: System.out.println("Programmet avsluttes.");
                        System.out.println(); break;
                case 0: skrivMeny(); break;
                default: System.out.println("Du tastet feil");
            }
        } while (!(valg == 9));
    }

    public void skrivUt() {
        //Prints out all elements, doctors prints out in alphabetical order, use compareTo().
        pasienter.iterator();
        legemidler.iterator();
        leger.iterator();
        resepter.iterator();
        System.out.println();
        System.out.println("Pasienter:");
        for (Pasient e : pasienter) {
            System.out.println(e.navn + ", " + e.foedselsnummer + ", ID: " + e.getID());
        }
        System.out.println();
        System.out.println("Legemidler:");
        for (Legemiddel e : legemidler) {
            System.out.println(e.hentNavn() + ", " + e.hentPris() + ", " + e.hentVirkestoff());
        }
        System.out.println();
        System.out.println("Leger:");
        ArrayList<String> legeNavn = new ArrayList<String>();
        for (Lege e : leger) {
            legeNavn.add(e.hentNavn());
        }
        Collections.sort(legeNavn);
        for (String e : legeNavn) {
            System.out.println(e);
        }
        System.out.println();
        System.out.println("Resepter:");
        for (Resept e : resepter) {
            System.out.println(e.hentLegemiddel().hentNavn() + ", " + e.hentLege().hentNavn() + ", PasientID: " + e.hentPasientID() + ", Reit: " + e.hentReit());
        }
        System.out.println();
    }

    public void endreTing() {
        //Adds either lege, pasient, legemiddel or resept(through lege skrivResept()) (if function)
        //The action has to be checked possible before object creation.
        //Any errors should be informed.
        //Use iterator to look for info in lists.
        //Exit back to menu if wrong input, NumberFormatException.
    }

    public void brukResept() {
        //Follow the user interaction example for the proper if functions.
        System.out.println("Hvilken pasient vil du se resepter for?");
        for (Pasient e : pasienter) {
            System.out.println(e.getID() + ": " + e.navn + "(fnr: " + e.foedselsnummer + ")");
        }
        Scanner scanner = new Scanner(System.in);
        int valg;
        Pasient pasient = null;
        System.out.print("> ");
        valg = scanner.nextInt();
        switch(valg) {
            case 9: System.out.println("Tilbake til meny.");
                    System.out.println(); break;
            default: System.out.println();
                    System.out.println("Valgt pasient: " + pasienter.hent(valg).navn);
                    pasient = pasienter.hent(valg);
                    break;
        }
        System.out.println("Hvilken resept vil du bruke?");
        for (Resept e : resepter) {
            System.out.println(e.hentID() + ": " + e.hentLegemiddel().hentNavn() + "(Reit: " + e.hentReit() + ")");
        }
        Resept resept = null;
        System.out.print("> ");
        valg = scanner.nextInt();
        switch(valg) {
            case 9: System.out.println("Tilbake til meny.");
                    System.out.println(); break;
            default: System.out.println();
                    resept = resepter.hent(valg);
                    System.out.println("Valgt resept: " + resept.hentLegemiddel().hentNavn());
                    if (resept.hentReit() == 0) {
                        System.out.println("Kunne ikke bruke resept paa " + resept.hentLegemiddel().hentNavn() + ". Ingen gjenvaerende reit.");
                    } else {
                        resept.bruk();
                        System.out.println("Brukte resept paa " + resept.hentLegemiddel().hentNavn() + ". Antall gjenvaerende reit: " + resept.hentReit());
                    }
                    break;
        }
    }

    public void statistikk() {
        //Totalt antall utskrevne resepter på vanedannende legemidler.
        int ant = 0;
        for (Legemiddel e : legemidler) {
            if (e instanceof PreparatB) {
                ant++;
            }
        }
        System.out.println("Totalt antall utskrevne resepter pa vaanedannende legemidler: " + ant);
        //Totalt antall utskrevne resepter på narkotiske legemidler.
        for (Legemiddel e : legemidler) {
            if (e instanceof PreparatA) {
                ant++;
            }
        }
        System.out.println("Totalt antall utskrevne resepter pa vaanedannende legemidler: " + ant);
        //Statistikk om mulig misbruk av narkotika skal vises på følgende måte:
          //List opp navnene på alle leger (i alfabetisk rekkefølge) som har skrevet ut
            //minst en resept på narkotiske legemidler, og antallet slike resepter per lege
        System.out.println("Leger som her skrevet ut resepter på narkotiske legemidler: ");
        
          //List opp navnene på alle pasienter som har minst en gyldig resept på
            //narkotiske legemidler, og for disse, skriv ut antallet per pasient.

    }
}
