import java.io.File;


public class Hovedprogram {
  public static void main(String[] args) {
    Legesystem legesystem = new Legesystem();
    File fil = new File("inndata.txt");
    legesystem.lesFraFil(fil);
    legesystem.kommandoloekke();
  }
}
