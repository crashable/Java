public class Legemiddel {
  int ID = 0;
  static int counter = 0;
  String navn;
  double pris;
  double virkestoff;

  public int hentId() {
    return ID;
  }
  public String hentNavn() {
    return navn;
  }
  public double hentPris() {
    return pris;
  }
  public double hentVirkestoff() {
    return virkestoff;}
}
