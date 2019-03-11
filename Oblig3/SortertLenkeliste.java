public class SortertLenkeliste<T extrends Comparable<T>> extends Lenkelist<T> {
  public void leggTil(T x) {
    Node p = start;
    Node tmp = new Node(x);
    Node current;
    if (tmp.data.compareTo(p.data) < 0) {
      tmp.neste = p;
      start = tmp;
    } else {
      current = p;
      p = p.neste;
      for (int i=0; i<size; i++) {
        if (tmp.data.compareTo(p.data) < 0) {
          tmp.neste = p;
          current.neste = tmp;
        } else {
          current = p;
          p = p.neste;
        }
      }
    }
    size++;
  }
}
