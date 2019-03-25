public abstract class Resept {
  int ID = 0;
  static int counter = 0;
  Legemiddel legemiddel;
  Lege utskrivendeLege;
  Pasient pasient;
  int pasientID;
  int reit;
  double price;
  //pasient.addResept(this);


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

  public Pasient hentPasient() {
    //Vet ikke om denne kommer til å trenges, men jeg lagde den.
    return pasient;
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
