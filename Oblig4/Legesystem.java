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
                    String[] infos = innlest.split(", ");
                    int kontrollid = Integer.parseInt(infos[1]);
                    if(kontrollid == 0){
                        leger.leggTil(new Lege(infos[0]));
                    }else{
                        leger.leggTil(new Spesialist(infos[0], kontrollid));
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
            System.out.print("> ");
            valg = scanner.nextInt();
            scanner.nextLine();
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
        System.out.println("1. Lege, 2. pasient, 3. legemiddel eller 4. resept?");
        Scanner scanner = new Scanner(System.in);
        int valg;
        System.out.print("> ");
        valg = scanner.nextInt();
        scanner.nextLine();
        String info;
        switch(valg) {
            case 1: System.out.println("Ny lege.");
                    System.out.print("Er legen en spesialist? y/n: \t");
                    info = scanner.next();
                    scanner.nextLine();
                    switch(info) {
                        case "y":
                            System.out.print("Skriv inn legens navn og ID: \t");
                            String infos = scanner.nextLine();
                            String[] inf = infos.split(", ");
                            leger.leggTil(new Spesialist(inf[0], Integer.parseInt(inf[1])));
                            break;
                        case "n":
                            System.out.print("Skriv inn legens navn: \t");
                            info = scanner.nextLine();
                            leger.leggTil(new Lege(info));
                            break;
                    }
                    break;
                    /*int("Skriv inn legens navn: \t");
                    info = scanner.nextLine();
                    leger.leggTil(new Lege(info));
                    break;*/
            case 2: System.out.println("Ny pasient.");
                    System.out.print("Skriv inn pasientens navn: \t");
                    String navn = scanner.nextLine();
                    System.out.print("Foedselsnummer: \t");
                    String fds = scanner.nextLine();
                    pasienter.leggTil(new Pasient(navn, fds));
                    break;
            case 3: System.out.println("Nytt legemiddel.");
                    System.out.print("Hvilken type, 1. a, 2. b eller c? \t");
                    info = scanner.next();
                    scanner.nextLine();
                    switch(info) {
                        case "a": System.out.println("Skriv i form: navn, pris, virkestoff, styrke");
                                  System.out.print("> ");
                                  info = scanner.nextLine();
                                  String[] inf = info.split(", ");
                                  legemidler.leggTil(new PreparatA(inf[0], Double.parseDouble(inf[1]), Double.parseDouble(inf[2]), Integer.parseInt(inf[3])));
                                  break;
                        case "b": System.out.println("Skriv i form: navn, pris, virkestoff, styrke");
                                System.out.print("> ");
                                  info = scanner.nextLine();
                                  inf = info.split(", ");
                                  legemidler.leggTil(new PreparatB(inf[0], Double.parseDouble(inf[1]), Double.parseDouble(inf[2]), Integer.parseInt(inf[3])));
                                  break;
                        case "c": System.out.println("Skriv i form: navn, pris, virkestoff");
                                  System.out.print("> ");
                                  info = scanner.nextLine();
                                  inf = info.split(", ");
                                  legemidler.leggTil(new PreparatC(inf[0], Double.parseDouble(inf[1]), Double.parseDouble(inf[2])));
                                  break;
                    }
                    System.out.println(); break;
            case 4: System.out.println("Ny resept");
                    System.out.println("Hvilket legemiddel?");
                    for (Legemiddel e : legemidler) {
                        System.out.println(e.hentId() + ": " + e.hentNavn());
                    }
                    Legemiddel legemiddel = null;
                    System.out.print("> ");
                    valg = scanner.nextInt();
                    scanner.nextLine();
                    switch(valg) {
                        case 9: System.out.println("Tilbake til meny.");
                                System.out.println(); break;
                        default: legemiddel = legemidler.hent(valg);
                                System.out.println("Valgt legemiddel: " + legemiddel.hentNavn());
                                System.out.println();
                                break;
                         }
                    System.out.println("Hvilken lege?");
                    for (Lege e : leger) {
                        System.out.println(e.getID() + ": " + e.hentNavn());
                    }
                    Lege lege = null;
                    System.out.print("> ");
                    valg = scanner.nextInt();
                    scanner.nextLine();
                    switch(valg) {
                      case 9: System.out.println("Tilbake til meny.");
                              System.out.println(); break;
                      default: lege = leger.hent(valg);
                              System.out.println("Valgt lege: " + lege.hentNavn());
                              System.out.println();
                              break;
                    }
                    System.out.println("Hvilken pasient?");
                    for (Pasient e : pasienter) {
                        System.out.println(e.getID() + ": " + e.navn);
                    }
                    Pasient pasient = null;
                    System.out.print("> ");
                    valg = scanner.nextInt();
                    scanner.nextLine();
                    switch(valg) {
                        case 9: System.out.println("Tilbake til meny.");
                            System.out.println(); break;
                        default: pasient = pasienter.hent(valg);
                            System.out.println("Valgt pasient: " + pasient.navn);
                            System.out.println();
                            break;
                    }
                    System.out.println("Hvor mange reit?");
                    System.out.print("> ");
                    valg = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        resepter.leggTil(lege.skrivResept(legemiddel, pasient, valg));
                    } catch(UlovligUtskrift e) {
                        System.out.println(e.getMessage());
                    }
            case 9: System.out.println("Tilbake til meny.");
                    System.out.println(); break;
            default: System.out.println("Du tastet feil");
                    break;
        }
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
        scanner.nextLine();

        switch(valg) {
            case 9: System.out.println("Tilbake til meny.");
                    System.out.println(); break;
            default: System.out.println();
                    System.out.println("Valgt pasient: " + pasienter.hent(valg).navn);
                    pasient = pasienter.hent(valg);
                    break;
        }
        System.out.println("Hvilken resept vil du bruke?");
        for (Resept e : pasient.hentResepter()) {
            System.out.println(e.hentID() + ": " + e.hentLegemiddel().hentNavn() + "(Reit: " + e.hentReit() + ")");
        }
        Resept resept = null;
        System.out.print("> ");
        valg = scanner.nextInt();
        scanner.nextLine();
        switch(valg) {
            case 9: System.out.println("Tilbake til meny.");
                    System.out.println(); break;
            default: System.out.println();
                    resept = pasient.hentResepter().hent(valg);
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
        System.out.println();
        for (Legemiddel e : legemidler) {
            if (e instanceof PreparatB) {
                ant++;
            }
        }
        System.out.println("Totalt antall utskrevne resepter paa vaanedannende legemidler: " + ant);
        //Totalt antall utskrevne resepter på narkotiske legemidler.
        for (Legemiddel e : legemidler) {
            if (e instanceof PreparatA) {
                ant++;
            }
        }
        System.out.println("Totalt antall utskrevne resepter paa narkotiske legemidler: " + ant);
        //Statistikk om mulig misbruk av narkotika skal vises på følgende måte:
          //List opp navnene på alle leger (i alfabetisk rekkefølge) som har skrevet ut
            //minst en resept på narkotiske legemidler, og antallet slike resepter per lege
        //List them by the doctor part in the prescription function.
        System.out.println("Leger som har skrevet ut resepter paa narkotiske legemidler:");
        ArrayList<String> legeNavn = new ArrayList<String>();
        for (Resept e : resepter) {
            if (e.hentLegemiddel() instanceof PreparatA) {
                legeNavn.add(e.hentLege().hentNavn() + " (" + e.hentLege().hentAnt() + ")");
            }
        }
        Collections.sort(legeNavn);
        for (String e : legeNavn) {
            System.out.println(e);
        }
        //List opp navnene på alle pasienter som har minst en gyldig resept på
        //narkotiske legemidler, og for disse, skriv ut antallet per pasient.
        System.out.println("Pasienter med gyldige resepter paa narkotiske legemidler: ");
        //ArrayList<String> legeNavn = new ArrayList<String>();
        int antR = 0;
        for (Resept e : resepter) {
            if (e.hentLegemiddel() instanceof PreparatA) {
                //Dunno how to get the patients amount of prescriptions.
                System.out.println(e.hentPasient().navn + " (" + e.hentLege().hentAnt() + ")");
            }
        }

    }
}
