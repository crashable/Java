public class Rute {
  /*Klassen Rute skal ta vare på sine koordinater (kolonne og rad), og skal også ha en
  referanse til labyrinten den er en del av. I tillegg skal klassen ha referanser til sine eventuelle
  nabo-ruter (nord/syd/vest/øst).
  Rute skal ha en abstrakt metode char tilTegn() som returnerer rutens tegnrepresentasjon
  (denne skal følge filformatet som beskrevet lenger opp!). Det skal ikke være mulig å opprette
  et objekt av klassen Rute, kun av subklassene.
  */
  int rad;
  int kolonne;
  Labyrint lab;
  int[] info = new int[2];
  char stuff;
  Rute north;
  Rute south;
  Rute west;
  Rute east;

  public char tilTegn() {
    if (this instanceof HvitRute) {
      return '#';
    }
    return '.';
  }

public void naboRuter() {

}

  public int[] info() {
    info[0] = kolonne;
    info[1] = rad;
    return info;
  }
}
