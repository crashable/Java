public class Pasient {
  String navn;
  String foedselsnummer;
  int ID = 0;
  static int counter = 0;
  static int antNark = 0;

  public Pasient(String nvn, String bursdag) {
    navn = nvn;
    foedselsnummer = bursdag;
    ID = counter;
    counter++;
  }

  public int getID() {
    return ID;
  }

  public void antNarkRes() {
    antNark++;
  }
}
