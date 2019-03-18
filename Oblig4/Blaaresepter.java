public class Blaaresepter extends Resept {
  Blaaresepter(Legemiddel lm, Lege utl, Pasient p, int rit) {
    this.legemiddel = lm;
    this.utskrivendeLege = utl;
    this.pasient = p;
    this.reit = rit;
    this.price = lm.hentPris() * 0.25;
    this.ID = counter;
    counter++;
  }
  public String farge() {
    return "blaa";
  }
  public double prisAaBetale() {
    return price;
  }
}
