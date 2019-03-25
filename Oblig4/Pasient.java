public class Pasient {
  String navn;
  String foedselsnummer;
  int ID = 0;
  static int counter = 0;
  static int antNark = 0;
  Stabel<Resept> pasRes;

  public Pasient(String nvn, String bursdag) {
    navn = nvn;
    foedselsnummer = bursdag;
    ID = counter;
    pasRes = new Stabel<Resept>();
    counter++;
  }

  public int getID() {
    return ID;
  }

  public void addResept(Resept resept) {
    pasRes.leggPaa(resept);
  }

  public Stabel<Resept> hentResepter() {
    return pasRes;
  }

  public void antNarkRes() {
    antNark++;
  }
}
