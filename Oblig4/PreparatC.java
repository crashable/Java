public class PreparatC extends Legemiddel {
  PreparatC(String nvn, Double prs, Double vs) {
    this.navn = nvn;
    this.pris = prs;
    this.virkestoff = vs;
    this.ID = counter;
    counter++;
  }
}
