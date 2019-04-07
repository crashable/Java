public class Aapning extends HvitRute {
  //Aapning er en subklasse av HvitRute og bruker samme datastruktur som sin superklasse.
  public Aapning(int r, int kol, Labyrint labbe) {
    super(r, kol, labbe);
  }

  public void gaa(String a) {
    System.out.println("Reached an ending at:");
    System.out.println(info());
    String str = info();
    lab.addTo(str);
    //lab.aapninger.add(info());
    //System.exit(1);
  }
}
