public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {
  public void leggTil(T x) {
    Node p = start;
    Node tmp = new Node(x);
    Node current;
    if (size == 0) {
      p = new Node(x);
      start = p;
      size++;
      return;
    }
    if (tmp.data.compareTo(p.data) < 0) {
      tmp.neste = p;
      start = tmp;
      size++;
      return;
    } else {
      current = p;  //Current is the node before p.
      p = p.neste;
      if (current.neste == null) {
        current.neste = tmp;
        size++;
        return;
      }
      for (int i=0; i<size; i++) {
        if (tmp.data.compareTo(p.data) < 0) {
          tmp.neste = p;
          current.neste = tmp;
          size++;
          return;
        } else {
          current = p;
          if (p.neste == null) {
            p.neste = tmp;
            size++;
            return;
          }
          p = p.neste;
        }
      }
    }
  }

  public T fjern() {
    return fjern(size-1);
  }

  public void sett(int pos, T x) {
    throw new UnsupportedOperationException();
  }
  public void leggTil(int pos, T x) {
    throw new UnsupportedOperationException();
  }
}
