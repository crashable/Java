public class Pasient {
  String navn;
  String foedselsnummer;
  int ID = 0;
  static int counter = 0;
  //Stabel<Resept>; //??????

  public Pasient(String nvn, String bursdag) {
    navn = nvn;
    foedselsnummer = bursdag;
    ID = counter;
    counter++;
  }

}