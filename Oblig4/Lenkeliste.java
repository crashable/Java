import java.util.Iterator;

public class Lenkeliste<T> implements Liste<T> {
  int size = 0;

  }

  public Iterator<T> iterator() {
    System.out.println("Test 1");
    Lenkeliste test = new Lenkeliste<T>;
    System.out.println("Test 2");
    return new LenkelisteIterator(Lenkeliste<T> test); //Dunno how to return this.
    System.out.println("Test 3");
  }

  class LenkelisteIterator implements Iterator<T> {
    //This is hella confusing;
    //Stuff is taken from 27.02 lecture, check if correct.
    private Lenkeliste<T> testListe;
    private int indeks = 0;
    public LenkelisteIterator(Lenkeliste<T> test) {
      testListe = test;
    }

    public boolean hasNext() {
      return indeks < testListe.stoerrelse();
    }
    public T next() {
      return testListe.hent(indeks++);
    }
  //  void remove();
  }

  class Node {
    Node neste = null;
    T data;
    Node(T x) {data = x;}

  public Node start = null;

  public int stoerrelse() {
    return size;
  }

  public void leggTil(T x) {
    //legg til bakerst
    Node p;
    if (size == 0) {
      p = new Node(x);
      start = p;
    } else {
      p = start;
      while (p.neste != null) {
        p = p.neste;
      }
      p.neste = new Node(x);
    }
    size++;
  }

  public void leggTil(int pos, T x) {
    //Legg til mellom elementene
    if (size == 0 && pos != 0) {
      throw new UgyldigListeIndeks(0);
    }
    if (pos > size || pos < 0) {
      throw new UgyldigListeIndeks(pos);
    }
    Node p = start;
    Node tmp;
    if (pos == 0) {
      tmp = new Node(x);
      tmp.neste = p;
      start = tmp;
    } else {
      try {
        for (int i=0; i<pos-1; i++) {
        p = p.neste;
        }
      } catch(UgyldigListeIndeks e) {
        System.out.println(e.getMessage());
      }
      tmp = new Node(x);
      tmp.neste = p.neste;
      p.neste = tmp;
    }
    size++;
  }

  public void sett(int pos, T x) {
    //Erstatt element
    if (size == 0 || pos == size || pos < 0) {
      throw new UgyldigListeIndeks(0);
    }
    Node p = start;
    try {
      for (int i=0; i<pos; i++) {
        p = p.neste;
      }
    } catch(UgyldigListeIndeks e) {
      System.out.println(e.getMessage());
    }
    p.data = x;
  }

  public T hent(int pos) {
    //Returnerer element
    if (size == 0 || pos == size || pos < 0) {
      throw new UgyldigListeIndeks(0);
    }
    Node p = start;
    try {
      for (int i=0; i<pos; i++) {
        p = p.neste;
      }
    } catch(UgyldigListeIndeks e) {
      System.out.println(e.getMessage());
    }
    return p.data;
  }

  public T fjern() {
    if (size == 0) {
      throw new UgyldigListeIndeks(0);
    }
    Node p;
    p = start;
    start = p.neste;
    size--;
    return p.data;
  }

  public T fjern(int pos) {
    //Fjerner fra posisjon
    if (size == 0 || pos == size || pos < 0) {
      throw new UgyldigListeIndeks(0);
    }
    Node p = start;
    if (pos == 0) {
      start = p.neste;
      size--;
      return p.data;
    }
    try {
      for (int i=0; i<pos-1; i++) {
        p = p.neste;
      }
    } catch(UgyldigListeIndeks e) {
      System.out.println(e.getMessage());
    }
    Node tmp = p.neste;
    p.neste = tmp.neste;
    size--;
    return tmp.data;
  }

  public void print() {
    Node p = start;
    for (int i=0; i<size; i++) {
      System.out.print(p.data);
    }
    System.out.println(p.data);
  }
}
