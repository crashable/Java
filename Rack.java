public class Rack {
  private Node[] rack;
  int counter = 0;

  public Rack(int antNodes) {
    rack = new Node[antNodes];
  }

  public int antProsessorer() {
    int curPros = 0;
    for (int i=0; i<counter; i++) {
      curPros += rack[i].antProsessorer();
    }
    return curPros;
  }

  public int noderMedNokMinne(int paakrevdMinne) {
    int curNodes = 0;
    for (int i=0; i<counter; i++) {
      if (rack[i].noderMedNokMinne(paakrevdMinne) == true) {
        curNodes++;
      }
    }
    return curNodes;
  }
  public void AddNode(int minne, int pros) {
    Node node = new Node(minne, pros);
    rack[counter] = node;
    counter++;
  }
}
