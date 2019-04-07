public class Aapning extends HvitRute {
  //Aapning er en subklasse av HvitRute og bruker samme datastruktur som sin superklasse.
  public Aapning(int r, int kol, Labyrint labbe) {
    super(r, kol, labbe);
  }

  public void gaa(String a) {
    System.out.println("Reached ending.");
    System.exit(1);
  }
}
