public class Militaerresepter extends HvitResept{
  Militaerresepter(Legemiddel lm, Lege utl, int pID, int rit) {
    this.legemiddel = lm;
    this.utskrivendeLege = utl;
    this.pasientID = pID;
    this.reit = rit;
    this.price = 0;
    this.ID = counter;
    counter++;
  }
  public String farge() {
    return "hvit";
  }
  public double prisAaBetale() {
    return price;
  }
}
