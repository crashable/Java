public class Aapning extends HvitRute {
  //Aapning er en subklasse av HvitRute og bruker samme datastruktur som sin superklasse.
  public Aapning(int r, int kol, Labyrint labbe) {
    super(r, kol, labbe);
  }

  public void gaa(String a, String road) {
    road += info() + " GOAL. ";
    /*System.out.println("Reached an ending at:");
    System.out.println(info());*/
    lab.aapninger.add(info());
    lab.rutevei += road + "\n";
    //System.exit(1);
  }
}
