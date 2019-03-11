public abstract class Resept {
  int ID = 0;
  static int counter = 0;
  Legemiddel legemiddel;
  Lege utskrivendeLege;
  int pasientID;
  int reit;
  double price;

  public int hentID() {
    return ID;
  }

  public Legemiddel hentLegemiddel() {
    return legemiddel;
  }

  public Lege hentLege() {
    return utskrivendeLege;
  }

  public int hentPasientID() {
    return pasientID;
  }

  public int hentReit() {
    return reit;
  }

  public boolean bruk() {
    if(reit > 0) {
      reit = reit-1;
      return true;
    }
    return false;
  }

  abstract public String farge();

  abstract public double prisAaBetale();
}
