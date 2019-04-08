public class HvitRute extends Rute {
  /*HvitRute og SortRute er subklasser av Rute. Disse må implementere char tilTegn() som
  deklareres i Rute.
  */
  public HvitRute(int r, int kol, Labyrint labbe) {
    rad = r;
    kolonne = kol;
    lab = labbe;
  }

  public char tilTegn() {
    return '.';
  }

  public void gaa(String dir, String road)   {
    //System.out.println(info());
    road += (info() + " -> ");
    if (dir!="south") {
      south.gaa("north", road);
    }
    if (dir!="north") {
      north.gaa("south", road);
    }
    if (dir!="west") {
      west.gaa("east", road);
    }
    if (dir!="east") {
      east.gaa("west", road);
    }
  }

}
