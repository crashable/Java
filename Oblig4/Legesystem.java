import java.util.*;
import java.io.*;

public class Legesystem{
    // Opprett lister som lagrer objektene i legesystemet

    public static void main(String[] args){

    }
    private static void lesFraFil(File fil){
        Scanner scanner = null;
        try{
            scanner = new Scanner(fil);
        }catch(FileNotFoundException e){
            System.out.println("Fant ikke filen, starter opp som et tomt Legesystem");
            return;
        }
        Lenkeliste<Pasient> pasienter = new Lenkeliste<Pasient>();
        Lenkeliste<Legemiddel> legemidler = new Lenkeliste<Legemiddel>();
        Lenkeliste<Lege> leger = new Lenkeliste<Lege>();
        Lenkeliste<Resept> resepter = new Lenkeliste<Resept>();

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
                    int index = Integer.parseInt(info[0]);
                    innlest = scanner.nextLine();
                    info = innlest.split(", ");
                    //Put all of this in a for-loop for each legemiddel?
                    //if(info[0].compareTo("0"))
                    //Try to use the get function to check if it's correct, then add in.
                    //Lege lege = new Lege("ere");
                    //Pasient pasient  = new Pasient("ere", "123");
                    Lege lege;
                    Pasient pasient;
                    for (int i=0; i<leger.stoerrelse()+1; i++) {
                        Lege legeTest = leger.hent(i);
                        if (info[1].compareTo(legeTest.hentNavn()) == 0) {
                            lege = leger.hent(i);
                        }
                    }
                    for (int i=0; i<pasienter.stoerrelse()+1; i++) {
                        Pasient pasientTest = pasienter.hent(i);
                        String id = Integer.toString(pasientTest.getID());
                        //int pasID = Integer.parseInt(info[2]);
                        if (info[2].compareTo(id) == 0) {
                            pasient = pasienter.hent(i);
                        }
                    }
                    int reit = Integer.parseInt(info[3]);
                    try {
                        resepter.leggTil(lege.skrivResept(legemidler.hent(index), pasient, reit));
                    } catch(UlovligUtskrift e) {
                        System.out.println(e.getMessage());
                    }


                    //
                    // Her må du finne legen, legemiddelet, og pasienten som ligger
                    // i lenkelistene utifra informasjonen.
                    //
                    // Dette burde skilles ut i hjelpemetoder leter gjennom listene
                    // og returnerer riktig objekt, ut ifra informasjonen som ble lest inn
                    //
                    // Opprett et reseptobjekt med skrivResept funksjonen i legen,
                    // og legg det til i en lenkeliste
                    //
                    // Dersom legeobjektene dine oppretter PResepter, kan du ignorere reit
                    //
                    //
                }
            }
        }
    }
}
