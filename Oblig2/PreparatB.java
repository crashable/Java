public class PreparatB extends Legemiddel {
  int styrke;
  PreparatB(String nvn, Double prs, Double vs, int srk) {
    this.navn = nvn;
    this.pris = prs;
    this.virkestoff = vs;
    this.styrke = srk;
    this.ID = counter;
    counter++;
  }
  public int hentVanedannendeStyrke() {
    return styrke;
 }
}
