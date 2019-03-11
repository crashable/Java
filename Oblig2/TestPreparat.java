public class TestPreparat {
  public static void main(String[] args) {
    PreparatA test1 = new PreparatA("Test", 1.2, 2.2, 4);
    System.out.println("ID: " + test1.hentId() + " Navn: " + test1.hentNavn() +
      " Pris: " + test1.hentPris() + " Virkestoff: " + test1.hentVirkestoff() +
    " Narkotisk Styrke: " + test1.hentNarkotiskStyrke());
    PreparatB test2 = new PreparatB("Aha!", 4.4, 1.9, 9);
    System.out.println("ID: " + test2.hentId() + " Navn: " + test2.hentNavn() +
      " Pris: " + test2.hentPris() + " Virkestoff: " + test2.hentVirkestoff() +
    " Vanedannende Styrke: " + test2.hentVanedannendeStyrke());
    PreparatC test3 = new PreparatC("Cool", 6.1, 1.1);
    System.out.println("ID: " + test3.hentId() + " Navn: " + test3.hentNavn() +
      " Pris: " + test3.hentPris() + " Virkestoff: " + test3.hentVirkestoff());
  }
}
