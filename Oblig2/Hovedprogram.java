public class Hovedprogram {
  public static void main(String[] args) {
    PreparatA farlig = new PreparatA("Narks", 500.0, 50.0, 8);
    System.out.print("ID: " + farlig.hentId());
    System.out.print(" Navn: " + farlig.hentNavn());
    System.out.print(" Pris: " + farlig.hentPris());
    System.out.print(" Virkestoff: " + farlig.hentVirkestoff());
    System.out.println(" Narkotisk Styrke: " + farlig.hentNarkotiskStyrke());
    PreparatB vane = new PreparatB("Koka", 350.0, 40.0, 9);
    System.out.print("ID: " + vane.hentId());
    System.out.print(" Navn: " + vane.hentNavn());
    System.out.print(" Pris: " + vane.hentPris());
    System.out.print(" Virkestoff: " + vane.hentVirkestoff());
    System.out.println(" Narkotisk Styrke: " + vane.hentVanedannendeStyrke());
    PreparatC vanlig = new PreparatC("Vann", 299.0, 39.0);
    System.out.print("ID: " + vanlig.hentId());
    System.out.print(" Navn: " + vanlig.hentNavn());
    System.out.print(" Pris: " + vanlig.hentPris());
    System.out.println(" Virkestoff: " + vanlig.hentVirkestoff());
    Lege lege = new Lege("Dr.Phillipsen");
    System.out.print("ID: " + lege.getID());
    System.out.print(" Navn: " + lege.hentNavn());
    System.out.print(" Resept: ");
    try {
      System.out.println(lege.skrivResept(vane,4,3));
    } catch(UlovligUtskrift e) {
      System.out.println(e.getMessage());
    }
    Spesialist doktor = new Spesialist("Dr.Perfekt", 1);
    System.out.print("ID: " + doktor.getID());
    System.out.print(" Navn: " + doktor.hentNavn());
    System.out.print(" Resept: ");
    try {
      System.out.println(doktor.skrivResept(farlig,4,3));
    } catch(UlovligUtskrift e) {
      System.out.println(e.getMessage());
    }
    try { //Here we try the error.
      System.out.println(lege.skrivResept(farlig,2,2));
    } catch(UlovligUtskrift e) {
      System.out.println(e.getMessage());
    }
    Blaaresepter blaa = new Blaaresepter(farlig, doktor, 1, 5);
    System.out.print("ID: " + blaa.hentID());
    System.out.print(" Legemiddel: " + blaa.hentLegemiddel());
    System.out.print(" Lege: " + blaa.hentLege());
    System.out.print(" PasientID: " + blaa.hentPasientID());
    System.out.print(" Reit: " + blaa.hentReit());
    if(blaa.bruk() == true) {
      System.out.print(" Used one.");
    } else {
      System.out.print(" Out of uses.");
    }
    System.out.print(" Farge: " + blaa.farge());
    System.out.println(" Pris: " + blaa.prisAaBetale());
    Militaerresepter mili = new Militaerresepter(vane, lege, 2, 6);
    System.out.print("ID: " + mili.hentID());
    System.out.print(" Legemiddel: " + mili.hentLegemiddel());
    System.out.print(" Lege: " + mili.hentLege());
    System.out.print(" PasientID: " + mili.hentPasientID());
    System.out.print(" Reit: " + mili.hentReit());
    if(mili.bruk() == true) {
      System.out.print(" Used one.");
    } else {
      System.out.print(" Out of uses.");
    }
    System.out.print(" Farge: " + mili.farge());
    System.out.println(" Pris: " + mili.prisAaBetale());
    Presepter pre = new Presepter(vanlig, lege, 3, 7);
    System.out.print("ID: " + pre.hentID());
    System.out.print(" Legemiddel: " + pre.hentLegemiddel());
    System.out.print(" Lege: " + pre.hentLege());
    System.out.print(" PasientID: " + pre.hentPasientID());
    System.out.print(" Reit: " + pre.hentReit());
    if(pre.bruk() == true) {
      System.out.print(" Used one.");
    } else {
      System.out.print(" Out of uses.");
    }
    System.out.print(" Farge: " + pre.farge());
    System.out.println(" Pris: " + pre.prisAaBetale());

  }
}
