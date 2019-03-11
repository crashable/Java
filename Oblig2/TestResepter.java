public class TestResepter {
  public static void main(String[] args) {
    PreparatA lgm1 = new PreparatA("legemiddel1", 300.5, 5.1, 10);
    PreparatB lgm2 = new PreparatB("legemiddel2", 20204.2, 3.12, 4);
    PreparatC lgm3 = new PreparatC("legemiddel3", 11112.1, 2.2);
    Militaerresepter milir = new Militaerresepter(lgm1, new Lege("Adam"), 1, 4);
    System.out.print("ID: " + milir.hentID());
    System.out.print(" Legemiddel: " + milir.hentLegemiddel());
    System.out.print(" Lege: " + milir.hentLege());
    System.out.print(" PasientID: " + milir.hentPasientID());
    System.out.print(" Reit: " + milir.hentReit());
    System.out.print(" Farge: " + milir.farge());
    System.out.print(" Pris: " + milir.prisAaBetale());
    if(milir.bruk() == true) {
      System.out.println(" Used one.");
    } else {
      System.out.println(" Out of uses.");
    }
    Presepter pres = new Presepter(lgm2, new Lege("Bob"), 2, 6);
    System.out.print("ID: " + pres.hentID());
    System.out.print(" Legemiddel: " + pres.hentLegemiddel());
    System.out.print(" Lege: " + pres.hentLege());
    System.out.print(" PasientID: " + pres.hentPasientID());
    System.out.print(" Reit: " + pres.hentReit());
    System.out.print(" Farge: " + pres.farge());
    System.out.print(" Pris: " + pres.prisAaBetale());
    if(pres.bruk() == true) {
      System.out.println(" Used one.");
    } else {
      System.out.println(" Out of uses.");
    }
    Blaaresepter blaa = new Blaaresepter(lgm3, new Lege("Carl"), 3, 10);
    System.out.print("ID: " + blaa.hentID());
    System.out.print(" Legemiddel: " + blaa.hentLegemiddel());
    System.out.print(" Lege: " + blaa.hentLege());
    System.out.print(" PasientID: " + blaa.hentPasientID());
    System.out.print(" Reit: " + blaa.hentReit());
    System.out.print(" Farge: " + blaa.farge());
    System.out.print(" Pris: " + blaa.prisAaBetale());
    if(blaa.bruk() == true) {
      System.out.println(" Used one.");
    } else {
      System.out.println(" Out of uses.");
    }
  }
}
