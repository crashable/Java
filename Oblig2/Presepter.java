public class Presepter extends HvitResept {
  Presepter(Legemiddel lm, Lege utl, int pID, int rit) {
    this.legemiddel = lm;
    this.utskrivendeLege = utl;
    this.pasientID = pID;
    this.reit = 3;
    this.price = lm.hentPris();
    this.ID = counter;
    counter++;
  }
  public double prisAaBetale() {
    if(this.price <= 108){
      this.price = 0;
      return price;
    }
    this.price = this.price - 108;
    return price;
  }
  public String farge() {
    return "hvit";
  }
}
