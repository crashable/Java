public class Lege<T extends Comparable<Resept>> {
//public class Lege implements Comparable<Resept> {
  int ID = 0;
  static int counter = 0;
  String legeNavn;

  public Lege(String lnvn) {
    legeNavn = lnvn;
    ID = counter;
    counter++;
  }
  public int getID() {
    return ID;
  }
  public String hentNavn() {
    return legeNavn;
  }
  public Resept skrivResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {

    if(legemiddel instanceof PreparatA) {
      throw new UlovligUtskrift(this, legemiddel);
    }
    Militaerresepter milit = new Militaerresepter(legemiddel, this, pasient, reit);
    return milit;
  }
  /*public Resept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    if(legemiddel instanceof PreparatA) {
      throw new UlovligUtskrift(this, legemiddel);
    }
    HvitResept hvit = new HvitResept(legemiddel, this, pasient, reit);
    utskrevedeResepter.leggTil(hvit);
    return hvit;
  }
  public Resept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    if(legemiddel instanceof PreparatA) {
      throw new UlovligUtskrift(this, legemiddel);
    }
    Blaaresepter blaa = new Blaaresepter(legemiddel, this, pasient, reit);
    utskrevedeResepter.leggTil(blaa);
    return blaa;
  }
  public Resept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    if(legemiddel instanceof PreparatA) {
      throw new UlovligUtskrift(this, legemiddel);
    }
    Militaerresepter milit = new Militaerresepter(legemiddel, this, pasient, reit);
    utskrevedeResepter.leggTil(milit);
    return milit;
  }
  public Resept skrivPResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    if(legemiddel instanceof PreparatA) {
      throw new UlovligUtskrift(this, legemiddel);
    }
    Presepter pres = new Presepter(legemiddel, this, pasient, reit);
    utskrevedeResepter.leggTil(pres);
    return pres;
  }*/
}
