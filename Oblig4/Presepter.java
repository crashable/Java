public class Presepter extends HvitResept {
  Presepter(Legemiddel lm, Lege utl, Pasient p, int rit) {
    this.legemiddel = lm;
    this.utskrivendeLege = utl;
    this.pasient = p;
    this.reit = 3;
    this.price = lm.hentPris();
    this.pasientID = p.getID();
    this.ID = counter;
    pasient.addResept(this);
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
