public class Spesialist extends Lege implements Godkjenningsfritak {
  int kontrollID;
  public Spesialist(String lnvn, int kID) {
    super(lnvn);
    this.kontrollID = kID;
    counter++;
  }
  public int hentKontrollID() {
    return kontrollID;
  }
  public Resept skrivResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    if (legemiddel instanceof PreparatA) {
      pasient.antNarkRes();
      antResept++;
    }
    return new Blaaresepter(legemiddel, this, pasient, reit);
  }
}
