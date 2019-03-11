class Baathus {
  private Baat[] baathus;

  public Baathus(int antallPlasser) {
    baathus = new Baat[antallPlasser];
  }

  public void settIn(Baat enBaat) {
    boolean sattInn = false;
    int teller = 0;

    while (teller < baathus.length && sattInn == false) {
      if (baathus[teller] == null) {
        baathus[teller] = enBaat;
        sattInn = true;
      }
      teller++;
    }

    if (sattInn != true) {
      System.out.println("Det er ikke plass til flere baater!");
    }
  }
  public void skrivBaater() {
    for (int i=0; i < baathus.length; i++) {
      if (baathus[i] != null) {
        System.out.println(baathus[i].hentInfo());
      }
    }
  }
}
