public class Lege {
  int ID = 0;
  static int counter = 0;
  String legeNavn;
  //Resept resept;
  public Lege(String lnvn) {
    legeNavn = lnvn;
    ID = counter;
    counter++;
  }
  public int getID() {
    return ID;
  }
  public String hentNavn() {
    return legeNavn;
  }
  public Resept skrivResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    if(legemiddel instanceof PreparatA) {
      throw new UlovligUtskrift(this, legemiddel);
    }
    return new Militaerresepter(legemiddel, this, pasient, reit);
  }
}
