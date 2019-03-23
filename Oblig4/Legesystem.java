import java.util.*;
import java.io.*;

public class Legesystem{
    // Opprett lister som lagrer objektene i legesystemet

    public static void main(String[] args){
    }
    public static void lesFraFil(File fil){
        Lenkeliste<Pasient> pasienter = new Lenkeliste<Pasient>();
        Lenkeliste<Legemiddel> legemidler = new Lenkeliste<Legemiddel>();
        Lenkeliste<Lege> leger = new Lenkeliste<Lege>();
        Lenkeliste<Resept> resepter = new Lenkeliste<Resept>();

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
                    String[] inf = innlest.split(" ");
                    pasienter.leggTil(new Pasient(inf[0], inf[1]));
                    if(innlest.charAt(0) == '#'){
                        break;
                    }
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
        System.out.println("MENY");
        System.out.println("1: Fullstending oversikt");
        System.out.println("2: Opprett eller legg til nye elementer");
        System.out.println("3: Bruk resept");
        System.out.println("4: Statisktikk for nerder");
        //System.out.println("5: Skriv all data til fil");
        System.out.println("5: Avslutt");
        System.out.println();
    }
    In tast = new In();
    public void kommandoloekke(){
    skrivMeny();
    int valg;
    do {
        System.out.print("\nValg (0 for Meny): ");
        valg = tast.inInt();
        switch(valg){
            case 5: System.out.println("Programmet avslutter");
                    System.out.println(); break;
            /*case 1: registrerDeltager(); break;
            case 2: trekning(); break;
            case 3: listDeltagere(); break;
            case 4: if( !trukket ) break;
                    if( foersteOmgang == null )
                        foersteOmgang = new Omgang( deltager, true );
                    foersteOmgang.kommandoloekke(); break;
            case 5: if( foersteOmgang == null ) break;
                    if( andreOmgang == null )
                        andreOmgang = new Omgang( reverser(foersteOmgang.rekkeflg), false );
                    andreOmgang.kommandoloekke(); break;
            case 6: autogenerer(); break;
            case 9: skrivMeny(); break;
            default: System.out.println("Du tastet feil");*/
        }
    } while (!(valg == 0));
}
}
