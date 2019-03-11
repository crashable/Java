public class Spesialist extends Lege implements Godkjenningsfritak {
  int kontrollID;
  public Spesialist(String lnvn, int kID) {
    super(lnvn);
    this.kontrollID = kID;
  }
  public int hentKontrollID() {
    return kontrollID;
  }
  public Resept skrivResept(Legemiddel legemiddel, int pasientID, int reit) throws UlovligUtskrift {
    return new Blaaresepter(legemiddel, this, pasientID, reit);
  }
}
