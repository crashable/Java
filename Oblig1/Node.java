public class Node {
  int minne;
  int antPros;
  public Node(int meme, int ant) {
    minne = meme;
    antPros = ant;
  }
  public int antProsessorer() {
    return antPros;
  }

  public boolean noderMedNokMinne(int paakrevdMinne) {
    if (paakrevdMinne <= minne) {
      return true;
    } else {
      return false;
    }
  }
}
