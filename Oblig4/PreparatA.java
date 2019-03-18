public class PreparatA extends Legemiddel {
  int styrke;
  PreparatA(String nvn, double prs, double vs, int srk) {
    this.navn = nvn;
    this.pris = prs;
    this.virkestoff = vs;
    this.styrke = srk;
    this.ID = counter;
    counter++;
  }
  public int hentNarkotiskStyrke() {
    return styrke;
  }
}
