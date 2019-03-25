public class Militaerresepter extends HvitResept{
  Militaerresepter(Legemiddel lm, Lege utl, Pasient p, int rit) {
    this.legemiddel = lm;
    this.utskrivendeLege = utl;
    this.pasient = p;
    this.reit = rit;
    this.price = 0;
    this.pasientID = p.getID();
    this.ID = counter;
    pasient.addResept(this);
    counter++;
  }
  public String farge() {
    return "hvit";
  }
  public double prisAaBetale() {
    return price;
  }
}
