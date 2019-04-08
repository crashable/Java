public class Aapning extends HvitRute {
  //Aapning er en subklasse av HvitRute og bruker samme datastruktur som sin superklasse.
  public Aapning(int r, int kol, Labyrint labbe) {
    super(r, kol, labbe);
  }

  public void gaa(String dir, String road) {
    road += info() + "YA";
    /*System.out.println("Reached an ending at:");
    System.out.println(info());*/
    lab.aapninger.add(info());
    lab.rutevei += road;
    //System.exit(1);
  }

  public char tilTegn() {
    return '.';
  }

}
